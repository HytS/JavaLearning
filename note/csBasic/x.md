




### 使用redis实现一个排行榜怎么做


### Set的应用场景是什么
redis中Set是一种无序集合，集合中的元素没有先后顺序但都唯一，有点类似java的HashSet
Set的应用场景如下：
* 存放的数据不能有重复的场景：网站uv统计（数据量巨大的场景还是HyperLogLog更合适）、文章点赞、动态点赞
* 需要获取多个数据源交集、并集和差集：共同好友（交集）、共同粉丝（交集）、共同关注（交集）、好友推荐（差集）、音乐推荐（差集）、订阅号推荐（差集+交集）
* 需要随机获取数据源中的元素的场景：抽奖系统、随机点名

### 使用Set实现抽奖系统怎么做
如果想要使用Set实现一个简单的抽奖系统的话，直接使用以下几个命令就好
* SADD key member1 member2 ...:向指定集合添加一个或多个元素
* SPOP key count:随机移除并获取指定集合中一个或多个元素，适合不允许重复中奖的场景
* SRANDMEMBER key count:随机获取指定集合中指定数量的元素，适合允许重复中奖的场景

### 使用Bitmap统计活跃用户怎么做
Bitmap存储的是连续的二进制数字，通过Bitmap，只需要一个bit位来表示某个元素对应的值或者状态，key就是对应元素本身。我们直到8bit组成一个byte，所以Bitmap可以极大节省空间

可以将Bitmap看作是一个存储二进制数字的数组，数组中每个元素的下表叫offset（偏移量）

### 使用HyperLogLog统计页面uv怎么做
使用HyperLogLog统计页面uv主要需要用到下面这两个命令：
* PFADD key element1 element2 ...:添加一个或多个元素到HyperLogLog中
* PFCOUNT key1 key2:获取一个或多个HyperLogLog的唯一计数

1、将访问指定页面的每个用户id添加到HyperLogLog中
PFADD PAGE_1:uv user1 user2..usern
2、统计指定页面的uv
PFCOUNT PAGE_1:uv

## redis持久化机制
redis持久化机制（RDB持久化、AOF持久化、RDB和AOF混合持久化）

## redis线程模型
对于读写命令来说，redis一直是单线程模型。不过，在4.0之后引入多线程来执行大键值对的异步删除操作，6.0之后引入了多线程来处理网络请求（提高网络io读写性能）
### redis单线程模型
redis基于reactor模式设计开发了一套高效的事件处理模型（Netty的线程模型也基于reactor模式），这套事件处理模型对应的是redis中的文件事件处理器。由于文件事件处理器是单线程方式运行的，所以我们说redis是单线程模型

* 文件事件处理器使用io多路复用程序来同时监听多个套接字，并根据套接字目前执行的任务来为套接字关联不同的事件处理器
* 当被监听的套接字准备好执行连接应答、读取、写入、关闭等操作时，与操作相对应的文件事件就会产生，这时文件事件处理器就会调用套接字之前关联好的事件处理器来处理这些事件

虽然文件事件处理器以单线程方式运行，但通过使用io多路复用程序来监听多个套接字，文件事件处理器既实现了高性能的网络通信模型，又可以很好地与redis服务器中其他同样以单线程方式运行地模块进行对接，这保持了redis内部单线程设计地简单性

#### 既然是单线程，那么怎么监听大量的客户端连接呢？
redis通过io多路复用程序来监听来自客户端的大量连接（或者说是监听多个socket），它会将感兴趣的事件及类型注册到内核中并监听每个事件是否发生
这样做的好处：io多路复用技术的使用让redis不需要额外创建多余的线程来监听客户端的大量连接，降低了资源的消耗

文件事件处理器主要包含4个部分：
* 多个socket（客户端连接）
* io多路复用技术（支持多个客户端连接的关键）
* 文件事件分派器（将socket关联到相应的事件处理器）
* 事件处理器（连接应答处理器、命令请求处理器、命令回复处理器）

#### redis6.0之前为什么不使用多线程
redis4.0之后就已经加入了对多线程的支持；不过，redis4.0增加的多线程主要是针对一些大键值对的删除操作命令，使用这些命令就会使用主线程之外的其他线程来‘异步处理’

原因：
* 单线程编程容易且更易维护
* redis的性能瓶颈不在cpu，主要在内存和网络
* 多线程就会存在死锁、线程上下文切换等问题，甚至会影响性能

#### redis6.0之后为何引入多线程
redis6.0引入多线程主要是为了提高网络io读写性能，，因为这个是redis中的一个性能瓶颈
虽然，redis6.0引入多线程，但是redis的多线程只是在网络数据的读写这类耗时的操作上使用，执行命令仍然是单线程顺序执行。因此，不需要担心线程安全问题

redis6.0的多线程默认是禁用的，只使用主线程。如需开启需要设置io线程数>1,需要修改redis配置文件redis.conf
io-threads 4 #设置1的话只会开启主线程，官网建议4核的机器建议设置为2或3个线程
另外：
* io-threads的个数一旦设置，不能通过config动态设置
* 当设置ssl后，io-threads将不工作

开启多线程后，默认只会使用多线程进入io写入writes，即发送数据给客户端，如果需要开启多线程io读取reads，同样需要修改redis配置文件redis.conf
io-threads-do-reads yes
开启多线程没有太大提升，不建议开启

#### redis后台线程
redis主要逻辑是单线程完成的，但实际还有一些后台线程用于执行一些比较耗时的操作：
* 通过bio_close_file后台线程来释放AOF/RDB等过程中产生的临时资源文件
* 通过bio_aof_fsync后台线程调用fsync函数将系统内核缓冲区还未同步到磁盘的数据强制刷到磁盘中（AOF文件）
* 通过bio_lazy_free后台线程放大对象占用的内存空间

### redis内存管理
#### redis给缓存数据设置过期时间有啥用？
一般情况下，我们设置保存的缓存数据有时候会设置一个过期时间，因为内存是有限的，如果缓存中的所有数据都是一直保存的话，分分钟out of memory
redis自带了给缓存数据设置过期时间的功能
expire key 60 # 数据在60s后过期
setex key 60 value # 数据在60s之后过期
ttl key # 查询数据还有多久过期

注意：redis中处理字符串类型有自己独有设置过期时间的命令setex外，其他方法都要依靠expire命令来设置过期时间。另外，persist命令可以移除一个键的过期时间
##### 过期时间除了有助于缓解内存的消耗，还有什么作用
很多时候，我们的业务场景就是需要某个数据只在某一时间段内存在，如果使用传统的数据库来处理，一般都是自己判断过期，这样更麻烦并且性能要差很多

#### redis是如何判断数据是否过期？
redis通过一个叫做过期词典（可以看作hash表）来保存数据过期的时间。过期词典的键指向redis数据库中的某个key，过期词典的值是一个long long 类型的整数，这个整数保存了key所指向的数据库键的过期时间 

#### 过期数据的删除策略
如果假设你设置了一批key只能存活1分钟，1分钟之后，redis是怎么对这批key进行删除的呢？
常用的过期数据的删除策略就两个
1.惰性删除：只会在取出key的时候对数据进行过期检查，这样对cpu最友好，但是可能会造成过多的过期key没有被删除
2.定期删除：每隔一段时间抽取一批key执行删除过期key操作。并且，redis底层会通过限制删除操作执行的时长和频率来减少删除操作对cpu时间的影响
定期删除对内存更友好，惰性删除对cpu更友好。redis采用定期删除+惰性删除

仅仅通过给key设置过期时间还有问题，因为还是可能存在定期删除和惰性删除漏掉了很多过期key的情况/这样导致大量过期key堆积在内存里，然后就out of memory，可以通过redis内存淘汰机制解决问题

#### redis内存淘汰机制
volatile-lru:从已设置过期时间的数据集中挑选最近最少使用的数据淘汰
volatile-ttl:从已设置过期时间的数据集挑选要过期的数据淘汰
volatile-random:从已设置过期时间的数据集中挑选任意数据淘汰
allkeys-lru:当内存不足以纳新写入数据时，在键空间内，移除最少使用的key
allkeys-random：从数据集中任意选择数据淘汰
no-eviction：禁止驱逐数据，也就是说当内存不足以纳新写入数据时，新写入数据会报错
volatile-lfu:从已设置过期时间的数据集中挑选最不经常使用的数据淘汰
allkeys-lfu:当内存不足以纳新写入数据时，在键空间中，移除最不经常使用的key


## redis事务
### 什么是redis事务
redis事务提供了一种将多个命令请求打包的功能，然后再按顺序执行打包的所有命令，并且不会被中途打断
redis事务开发中用的少，功能比较鸡肋；除了不满足原子性和持久性，事务中的每条命令都与redis服务器进行网络交互，这是浪费资源的行为

### 如何使用redis事务
redis可以通过multi、exec、discard、watch等命令来实现事务功能
multi命令后可以输入多个命令，redis不会立即执行这些命令，而是将它们放到队列里，当调用了exec命令后，再执行所有命令
过程：1、开始事务（multi）2、命令入队（批量操作redis命令，fifo的顺序执行）3、执行事务（exec）
你可以通过discard命令取消一个事务，它会清空事务队列里保存的所有命令
你可以通过watch命令监听指定的key，当调用exec执行事务时，如果一个被watch监听的key被其他客户端/session修改的话，整个事务都不会被执行
如果watch和事务在同一个session中，并且被watch监视的key被修改的操作发生在事务内部，这个事务是可以被执行成功的

### redis事务支持原子性吗
redis的事务和平时理解的关系型数据库的事务不同。事务具有原子性、隔离性、持久性、一致性
原子性：事务是最小的执行单位，不允许分割。事务的原子性保证了事务要么全部完成，要么完全不起作用
隔离性：并发访问数据库，一个用户的事务不被其他事务干扰，各并发事务之间的数据库是独立的
持久性：一个事务被提交后，它对数据库的变化是持久的，即使数据库发生故障也不应该对其有影响
一致性：执行事务前后，数据保持一致，多个事务对同一个数据读取结果是一致的
redis事务在运行错误的情况下，除了执行过程中出现错误的命令外，其他命令都能正常执行。并且，redis事务不支持回滚操作。因此，redis事务不满足原子性（redis开发者认为没有必要实现回滚，命令执行错误应该在开发过程中发现而不是生产过程中）。

### redis事务支持持久性吗
redis不同于memcached的重要一点就是，redis支持持久化，而且提供了3中持久化方式：
* 快照（RDB）
* 只追加文件（AOF）
* RBD和AOF的混合持久化（4.0新增）

与RDB持久化相比，AOF持久化的实时性更好。在redis的配置文件中存在3种不同的AOF持久化方式，分别是：
appendfsync always # 每次有数据修改发生时都会调用fsync函数同步AOF文件，fsync完成后线程返回，这样会降低redis的速度
appendfsync everysec # 每秒调用fsync函数同步一次AOF
appendfsync no # 让os决定何时进行同步，一般为30s一次

AOF持久化策略为no、everysec时都会存在数据丢失的情况，always下基本可以满足持久性要求，但性能太差
因此，redis事务的持久性也是没有办法保证的

### 如何解决redis事务的缺陷
redis从2.6开始执行lua脚本，功能与事务相似。我们可以利用lua脚本来批量执行多条redis命令，这些命令会被提交到redis服务器一次性执行，减小网络开销

一段lua脚本执行过程不会有其他脚本或redis命令同时执行，保证了操作不会被其他指令插入或打扰

如果lua脚本运行时出错并中途结束，出错之后的命令是不会被执行的。并且，出错之前执行的命令是无法被撤销的，无法实现类似关系型数据库执行失败可以回滚的那种原子性效果。因此，通过lua脚本来批量执行redis命令实际上也不完全满足原子性

如果想要让lua脚本全部执行，必须保证语句语法和命令都是对的

## redis性能优化
### 使用批量操作减少网络传输
一个redis命令的执行可以简化为4步：1、发送命令2、命令排队3、命令执行4、返回结果
其中，第1步和第4步耗费时间之和称为rtt（往返时间），也就是数据在网络上的传输时间
使用批量操作可以减少网络传输次数，进而减少网络开销
另外，除了能减少rtt之外，发送一次命令的socket io成本也较高，批量操作还可以减少socket io成本

#### 原生批量操作命令
MGET:获取一个或多个指定key值
MEST：设置一个或多个指定key的值
HMGET：获取指定哈希表中一个或多个字段的值
HMEST：同时将一个或多个field-value对设置到指定哈希表中
SADD：向指定集合添加一个或多个元素

在redis官方提供的分片集群解决方案redis cluster下，使用这些原生批量操作命令可能回存在一些问题。比如MGET无法保证所有的key都在同一个hash slot上，MGET可能需要多次网络传输，原子操作也无法保证。不过相较于非批量操作，还是可以节省不少网络传输次数

整个步骤的简化版（通常由redis客户端实现，无序手动实现）
1、找到key对应的所有hash slot 2、分别向对应的redis节点发起MGET请求获取数据 3、等待所有请求执行结束，重新组装数据，保持跟入参key的顺序一致，然后返回结果 

如果想要解决这个多次网路传输的问题，常用的方法是自己维护key与slot的关系；但是这样会让系统复杂性提升

> redis cluster并没有使用一致性哈希，采用的是哈希槽分区，每一个键值对都属于一个hash slot。当客户端发送命令请求的时候，需要先根据key通过计算公式找到对应的哈希槽，然后查询哈希槽与节点的映射关系，即可找到目标redis节点







## redis生产问题
### 缓存穿透
#### 什么是缓存穿透


## spring基础
### 什么是spring框架
spring是一款开源的轻量级java开发框架，一般说的spring框架指的是spring framework，它是很多模块的集合，使用这些模块可以帮助开发，比如spring支持ioc（控制反转）和aop（面向切片编程）、可以很好的对数据库进行访问
### spring包含的模块有那些
#### Core container
spring框架的核心模块，主要提供ioc依赖注入功能支持。spring其他功能都依赖此模块，
* spring-core:spring框架基本的核心工具类
* spring-beans：提供对bean的创建、配置和管理等功能的支持
* spring-context：提供对国际化、事件传播、资源加载等功能的支持
* spring-expression：提供对表达式语言的支持，只依赖core模块，不依赖其他模块，可以单独使用
#### AOP
* spring-aspects：该模块为与AspcetJ的集成提供支持
* spring-aop：提供了面向切面的编程实现
* spring-instrument：提供了为jvm添加代理的功能，它为tomcat提供了一个织入代理，能够为tomcat传递类文件，就像这些文件被类加载器加载一样
#### data Access
* spring-jdbc：提供了对数据库访问的抽象jdbc。不同的数据库都有自己独立的api用于操作数据库，而java程序只需要和jdbc api交互，这样就屏蔽了数据库的影响
* spring-tx：提供对事务的支持
* spring-orm：提供对Hibernate、JPA、iBatis等orm框架的支持
* spring-oxm：提供一个抽象层oxm（Object-to-xml-Mapping）
* spring-jms:消息服务。
#### spring web
* spring-web：对web功能实现提供一些最基础的支持
* spring-webmvc：提供对spring mvc的实现
* spring-websocket：提供了对webSocket的支持，webSocket可以让客户端和服务端进行双向通信
* spring-webflux：提供对webflux的支持。webflux是spring framework 5.0引入的新的响应式框架，与spring mvc不同，它不需要servlet api，是完全异步（异步：指两个或两个以上的对象或事件不同时存在或发生；或多个相关事务的发生无需等待其前一事务的完成）
#### messaging
* spring-messaging：主要负责spring框架集成的基础的报文传送应用
#### spring test
spring团队提倡测试驱动开发（tdd）。有了ioc的帮助，单元测试和集成测试变得更简单，spring的测试模块对JUnit（单元测试框架）、TestNG等常用测试框架支持的都比较好

### spring、spring mvc、spring boot之间有什么关系
spring包含了多个功能模块，spring-core是最重要的模块，spring中的其他模块（spring mvc）的功能实现基本都需要依赖该模块

spring mvc是spring中的一个重要模块，主要赋予spring 快速构建mvc架构的web程序能力。mvc是模型、视图、控制器的简写，核心思想是将业务逻辑、数据、显示分离来组织代码

使用spring进行开发各种配置过于麻烦比如开启某些spring特性时，需要xml或java进行显式设置。于是spring-boot诞生了
spring旨在简化j2ee企业应用程序开发，spring-boot旨在简化spring开发（减少配置文件）
spring boot只是简化了配置，如果需要构建mvc架构的web程序，还是需要spring mvc框架，只是说spring boot简化了spring mvc的很多配置

## spring ioc
### 对spring ioc的理解
ioc（控制反转）是一种设计思想，而不是一种具体的技术实现。ioc的思想就是将原本在程序中手动创建对象的控制权，交由spring框架来管理
#### 为什么叫控制反转
* 控制：指的是对象创建（实例化、管理）的权力
* 反转：控制器交给外部环境（spring框架、ioc容器）

将对象之间的互相依赖关系交给ioc容器管理，并由ioc容器完成对象的注入。这样可以很大程度上简化应用的开发，把应用从复杂的依赖关系中解放出来。ioc容器就像一个工厂一样，当我们需要创建一个对象的时候，只需要配置好配置文件/注解即可，完全不用考虑对象是如何创建出来的

在实际项目中一个Service类可能依赖了很多其他的类，假如我们要实例化这个Service，可能每次都要搞清这个Service所有底层类的构造函数，这很麻烦。如果利用ioc的话，只需要配置好，然后在需要的地方引用就行了。

spring中，ioc容器是spring用来实现ioc的载体，ioc容器实际上是Map（key，value），Map中存放的是各种对象
spring时代一般通过xml文件配置bean，后来开发人员认为xml文件配置不太好，于是改用springboot注解配置

### 什么是spring bean
bean代指那些被ioc容器所管理的对象；我们需要告诉ioc容器帮助我们管理哪些对象，这个是通过配置元数据来定义的。配置元数据可以是xml文件、注解或java配置类
### 将一个类声明为bean的注解有哪些
* @Component：通用的注解，可标注任意类为spring组件。如果一个bean不知道属于那一层，可以用@Component注解标注
* @Repository：对应持久层即DAO层，主要用于数据库相关操作
* @Service：对应服务层，主要涉及一些复杂的逻辑，需要用到DAO层
* @Controller：对应Spring mvc控制层，主要用于接收用户请求并调用Service层返回数据给前端页面


### @Component与@Bean的区别是什么
* @Component注解作用于类，而@Bean注解作用于方法
* @Component通常是通过类路径扫描来自动侦测以及自动装配到spring容器中（我们可以使用@ComponentScan注解定义要扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中）。@bean注解通常是我们标有该注解的方法中定义产生这个bean，@bean告诉了spring这是某个类的实例。当我需要用它的时候还给我
* @bean注解比@Component注解的自定义性更强，而且很多时候我们只能通过@bean注解注册bean。比如当我们引用第三方库中的类需要装配到spring容器时，则只能通过@bean来实现

```
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl();
    }
}
上面的代码相当于下面的xml配置
<beans>
    <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

### 注入bean的注解有哪些
spring内置的@Autowired以及jdk内置的@Resource和@Inject都可以用于注入bean
@Autowired和@Resource使用的比较多一些


### @Autowired和@Resource的区别是什么
Autowired属于spring内置的注解，默认的注入方式为byType（根据类型进行匹配），也就是说会先根据接口类型去匹配并注入bean（接口的实现类）

当一个接口存在多个实现类的情况，byType这种方式就无法正确注入对象了，因为这个时候spring会同时找到多个满足条件的选择，默认情况下它自己不知道选择哪一个
这种时候，注入方式会变成byName（根据名称进行匹配），这个名称通常是类名（首字母小写）。比如下面代码中的smsService就是这里的名称
```
@Autowired
private SmsService smsService
```
举个例子，SmsService有两个实现类：SmsServiceImpl1和SmsServiceImpl2，且它们都被spring容器所管理
```
//报错，byName和byType无法匹配到bean
@Autowired
private SmsService smsService;
//正确注入smsServiceImpl1对象对应的bean
@Autowired
private SmsService smsServiceImpl1;
//正确注入 SmsServiceImpl1 对象对应的bean，smsServiceImpl1就是上面说的名称
@Autowired
@Qualifier(value="smsServiceImpl1")
private SmsService smsService;
```

一般建议通过@Qualifier注解来显式指定名称而不是依赖变量的名称；@Resource属于jdk提供的注解，默认注入方式为byName，如果无法通过名称匹配到bean的话，注入方式会变成byType
@Resource有两个比较重要的属性：name、type
如果仅指定name属性则注入方式为byName，，如果仅指定type属性则注入方式为byType，如果同时指定name+type属性（不建议），则注入方式为byType+byName


总结：
* 当一个接口存在多个实现类，@Autowired和@Resource都需要通过名称才能正确匹配到bean，Autowired可以通过@Qualifier注解来显式指定名称，Resource可以通过name属性来显式指定名称
* @Autowired支持在构造函数、方法、字段和参数上使用。@Resource主要用于字段和方法的注入，不支持在构造函数或参数上使用


### bean的作用域有哪些
spring中的bean的作用域有以下几种
* singleton：ioc容器中只有唯一的bean实例。spring中的bean默认都是单例的，是对单例设计模式的应用
* prototype：每次获取都会创建一个新的bean实例。也就是说，连续getBean()两次，得到的是两个不同的Bean实例
* request（仅web应用可用）：每一次http请求都会产生一个新的bean（请求bean），该bean仅在当前http request内有效
* session（仅web应用可用）:每一次来自新session的http请求都会产生新的bean（会话bean），该bean仅在当前http session内有效
* application/global-session（仅web应用可用）：每个web应用在启动时创建一个bean（应用bean），该bean仅在当前应用启动时间内有效
* websocket（仅web应用可用）：每一次websocket会话产生一个新的bean

#### 如何配置bean的作用域
xml方式
<bean id="" class="" scope="singleton"></bean>

注解方式：
@Bean
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public Person PersonPrototype(){
    return new Person();
}


### Bean是线程安全的吗？
spring框架中的bean是否线程安全，取决于其作用域和状态
最常用的两种作用域prototype和singleton为例，几乎所有场景的bean作用域都是使用默认的singleton。
prototype作用域下，每次获取都会创建一个新的bean实例，不存在资源竞争问题，所以 不存在线程安全问题。singleton作用域下，ioc容器中只有唯一的bean实例，可能存在资源竞争问题（取决于bean是否有状态）。如果这个bean是有状态的话，那就存在线程安全问题（有状态bean是指包含可变的成员变量的对象）
不过大部分bean实例都是无状态（没有定义可变的成员变量）的（比如DAO、Service），这种情况下，bean是安全的

对于有状态单例bean的线程安全问题，解决方法有两种：
1、在bean中尽量避免定义可变的成员变量
2、在类中定义一个ThreadLocal成员变量，将需要的可变成员变量保存在ThreadLocal中