
















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

### bean的声明周期
* bean容器找到配置文件中spring bean的定义
* bean容器利用java reflection api创建一个bean实例
* 如果涉及到一些属性值利用set()设置一些属性值
* 如果bean实现BeanNameAware接口，调用setBeanName方法，传入bean的名字
* 如果bean实现了BeanClassLoaderAware接口，调用setBeanClassLoader(),传入ClassLoader对象的实例
* 如果bean实现BeanFactoryAware接口，调用setBeanFactory方法，传入BeanFactory对象的实例
* 与上面类似，如果实现了其他*.aware接口，就调用相应的方法
* 如果有和加载这个bean的spring容器相关的BeanPostProcessor对象，执行postProcessBeforeInitialization()
* 如果bean实现了InitializaingBean接口，执行afterPropertiesSet方法
* 如果bean配置文件中的定义包含init-method属性，执行指定的方法
* 如果有和加载这个bean的spring容器相关的BeanPostProcessor对象，执行postProcessAfterInitialization()
* 当要销毁bean的时候，如果bean实现类DisposableBean接口，执行destory方法
* 当要销毁bean的时候，如果bean在配置文件中的定义包含destroy-method属性，执行指定的方法

![图片](https://images.xiaozhuanlan.com/photo/2019/b5d264565657a5395c2781081a7483e1.jpg)

### spring aop
#### 对aop的理解
aop能够将哪些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块之间的耦合度
spring aop就是基于动态代理的，如果要代理的对象，实现了某个接口，那么spring aop就会使用jdk proxy，去创建代理对象，而对于没有实现接口的对象，就无法使用jdk proxy进行代理，这时spring aop会使用Cglib生成一个被代理对象的子类作为代理
![图片](https://oss.javaguide.cn/github/javaguide/system-design/framework/spring/230ae587a322d6e4d09510161987d346.jpeg)

当然也可以使用AspectJ，spring aop已经集成AspectJ
Target：被通知的对象
Proxy：向目标对象应用通知之后创建的代理对象
连接点/JoinPoint：目标对象的所属类中，定义的方法均为连接点
切入点/Pointcut：被截面拦截/增强的连接点（切入点一定是连接点，连接点不一定是切入点）
通知/Advice：增强的逻辑/代码，即拦截到目标对象的连接点之后要做的事
Aspect：切入点+通知
Weaving：将通知应用到目标对象，进而生成代理对象的过程动作

#### spring aop和Aspect aop区别
spring aop属于运行时增强，AspectJ属于编译时增强，spring aop基于代理，AspectJ 基于字节码操作
spring aop已经集成了AspectJ，AspectJ比spring aop功能更强，spring aop更简单


#### AspectJ定义的通知类型有哪些
* Before（前置通知）：目标对象的方法调用之前触发
* After（后置通知）：目标对象的方法调用之后触发
* AfterReturning（返回通知）：目标对象的方法调用完成，在返回结果值之后触发
* AfterThrowing（异常通知）：目标对象的方法运行中抛出异常后触发，AfterReturning和AfterThrowing两者互斥。如果方法调用成功无异常，则会有返回值；如果方法抛出异常，则不会有返回值
* Around（环绕通知）：编程式控制目标对象的方法调用。环绕通知是所有通知类型中可操作范围最大的一种，因为它可以直接拿到目标对象，以及要执行的方法，所以环绕通知可以任意的在目标对象的方法调用前后搞事，甚至不调用目标对象的方法

#### 多个切面的执行顺序如何控制
1、通常使用@Order注解直接定义切面顺序（值越小优先级越高）
2、实现Order接口重写getOrder方法（返回值越小优先级越高）

### spring mvc
#### mvc理解
mvc是模型、视图、控制器的缩写，核心思想是通过将业务逻辑、数据、显示分离来组织代码
model1
整个web界面几乎全部用jsp页面组成，只有少量的javabean来处理数据库连接
这个模式下，jsp既是控制层又是表现层，控制逻辑和表现逻辑混杂在一起，代码利用率低

model2
javaweb开发模式：javaBean（model）+jsp（view）+servlet（controller）
* model：系统涉及的数据就是dao和bean
* view：展示模型中的数据，只是用来展示
* controller：接受用户请求，并将请求发送至model，最后返回数据给jsp并展示给用户

model2的抽象和封装程度不够，

spring mvc
MVC 是一种设计模式，Spring MVC 是一款很优秀的 MVC 框架。Spring MVC 可以帮助我们进行更简洁的 Web 层的开发，并且它天生与 Spring 框架集成。Spring MVC 下我们一般把后端项目分为 Service 层（处理业务）、Dao 层（数据库操作）、Entity 层（实体类）、Controller 层(控制层，返回数据给前台页面)。


#### spring mvc的核心组件有哪些
* DispatcherServelet：核心的中央处理器，负责接受请求、分发，并给与客户端相应
* HandlerMapping：处理器映射器，根据url去匹配查找能处理的Handler，并会将请求涉及到的拦截器和Handler一起封装
* HandlerAdapter：处理器适配器，根据HandlerMapping找到的Handler，适配执行对应的Handler
* Handler：请求处理器，处理实际请求的处理器
* viewResoler：视图解析器，根据Handler返回的逻辑视图，解析并渲染真正的视图，并传递给DispathcerServlet

#### spring mvc的工作原理
![图片](https://oss.javaguide.cn/github/javaguide/system-design/framework/spring/de6d2b213f112297298f3e223bf08f28.png)

流程说明：
* 客户端发送请求，DispatcherServlet拦截请求
* DispatcherServlet根据请求信息调用HandlerMapping，HandlerMapping根据url去匹配查找能处理的Handler（即controller控制器），并会将请求涉及到的拦截器和Hanler一起封装
* DispatcherServlet调用HandlerAdapter执行Handler
* Handler完成对用户的请求后，会返回一个ModelAndView对象给DispatcherServlet（ModelAndView包含了数据模型以及相应的视图的信息。model返回的是数据对象，view是逻辑上的view）
* ViewResolver会根据逻辑view查找实际的view
* DispatcherServlet把返回的model传给view
* 把view返回给请求者

#### 统一异常怎么做
推荐使用注解的方式统一异常处理，使用@ControllerAdvice+@ExceptionHandler这两个注解
这种异常处理方式下，会给所有或者指定的Controller织入异常处理的逻辑（aop），当controller中的方法抛出异常的时候，由被@ExceptionHandler注解修饰的方法进行处理。

ExceptionHandlerMethodResolver中getMappedMethod方法决定了异常具体被哪个被@ExceptionHandler修饰的方法处理异常

getMappedMethod()会首先找到可以匹配处理异常的所有方法信息，然后从小到大排序，最后取最小的哪一个匹配的方法（即匹配度最高的方法）

### spring框架中用到了哪些设计模式
* 工厂设计模式：spring使用工厂模式通过BeanFactory、ApplicationContext创建bean对象
* 代理设计模式：springaop功能的实现
* 单例设计模式：spring中的bean默认都是单例的
* 模板方法设计模式：spring中jdbcTemplate、hibernateTemplate等以Template结尾的对数据库操作的类，它们就用到了模板模式
* 包装器设计模式：我们的项目需要连接多个数据库，而且不同的用户在每次访问中根据需要会去访问不同的数据库。这种模式让我们可以根据客户的需求能够动态切换不同的数据源
* 观察者模式：spring事件驱动模型就是观察者模式的应用
* 适配器模式：spring aop的增强或通知（advice）使用到了适配器模式，spring mvc中也使用到了适配器模式适配Controller

### spring事务
#### spring管理事务的方式有几种
* 编程式事务：在代码中硬编码（不推荐）：通过TransactionTemplate或者TransactionManager管理事务，实际应用很少使用
* 声明式事务：在xml配置文件中配置或者直接基于注解（推荐）：实际是通过aop实现（基于@Transactional的全注解方式使用最多）

#### spring事务中哪几种事务传播行为



# hello-algo
## 复杂度
## 数据结构
### 数据结构分类
#### 逻辑结构：线性与非线性
逻辑结构解释了数据元素之间的逻辑关系
线性数据结构：链表、栈、队列、哈希表、数组
非线性数据结构：树、图、堆
非线性数据结构可以进一步被分为树形结构和网状结构

#### 物理结构：连续和分散
物理结构反映了数据在计算机内存中的存储方式  ，可分为连续存储和分散存储
所有数据结构都是基于数组和链表或二者组合而成的；基于数组实现的数据结构被称为静态数据结构；基于链表实现的数据结构被称为动态数据结构

#### 基本数据类型
数据结构是在计算机中组织和存储数据的方式
#### 数字编码
整数在计算机中以补码存储。在补码的表示下，计算机对加法和减法一视同仁

## 数组和链表
### 数组
#### 初始化数组
```
//存储在栈上
int nums[5] {1,2,3,4,5}
//存储在堆上，需要手动释放空间
int* nums=new int[5]{1,2,3,4,5}
```
### 小结
#### 为什么哈希表同时包含线性数据结构和非线性数据结构
哈希表底层是数组，为了解决哈希冲突，可能会使用链式地址。在拉链法中，数组中的每个地址指向一个链表，当链表的长度超过一定阈值时，又可能被转化成树，所以哈希表可能同时包含线性数据结构和非线性数据结构
#### char类型的长度是1byte吗
char类型的数据长度由编程语言的编码方法决定，java（utf-16）的char是2byte
### 链表
#### 初始化链表
初始化各节点对象，构建引用关系
插入节点
访问节点
删除节点：只需改变一个节点的引用就好
查找
### 列表 
list表示元素的有序集合
#### 初始化列表
vector<int> nums1;//无初始值
vector<int> nums={1,2,3,4,5}//有初始值
#### 访问元素
列表本质上是数组，可以在O（1）的时间里访问和更新元素
#### 小结

## 栈与队列
### 栈
#### 基于链表的实现 
使用链表实现栈时，可以将头节点看作栈顶，将尾节点看作栈底
#### 基于数组的实现
使用数组实现栈时，可以将数组的尾部作为栈顶
#### 栈典型应用
浏览器中的后退与前进、软件中的撤销和反撤销
程序内存管理
### 队列
#### 队列实现
##### 基于链表的实现
可以将链表的头节点和尾节点看作队首和队尾，规定队尾仅可插入节点，队头仅可删除节点
##### 基于数组的实现
数组删除元素时间复杂度为O(n),出队效率低
可以使用front指向队首元素的索引，维护一个size它用于记录队列长度，rear=front+size，得出rear指向队尾元素的下一个位置，基于此设计，数组中包含元素的有效区间是[front,rear-1]
* 入队操作：将输入元素赋值给rear索引处，size+1
* 出队操作： 将front+1，size-1
##### 队列典型应用
* 淘宝订单
* 各类待办事项
### 双向队列
允许在头部和尾部增删节点    
#### 双向队列实现
基于双向链表的实现
将双向链表的头节点对应队头，尾节点对应队尾
基于数组的实现
使用环形数组实现双向队列
### 小结
## 哈希表
### 哈希表
又叫散列表，通过建立key与value之间的映射，实现高效的元素查询。输入一个key，可以在O(1)时间内找到value
哈希表中进行增删改查的时杂都是O(1)
#### 哈希表常用操作
初始化、查询操作、添加键值对和删除键值对
##### 初始化
* Map<Integer,String> map=new HashMap();
##### 遍历
三种常用的遍历方式：遍历键值对、遍历键、遍历值
#### 哈希表简单实现
最简单的情况，使用数组实现哈希表。在哈希表中，数组中的每个空位称为桶（bucket），每个桶可以存储一个键值对，因此，查询操作就是找到key对应的桶，并在桶中获取value
通过hash函数可以基于key定位对应的桶，哈希函数的作用是将一个较大的输入空间映射到一个较小的输出空间

哈希函数的计算过程
1、通过某种哈希算法计算得到哈希值
2、将哈希值对桶数量（数组长度）capacity取模，从而获得key对应的数组索引index
然后，利用index在哈希表中访问对应的桶，从而获取value
#### 哈希冲突和扩容
哈希函数的作用是将所有key组成的输入空间全部映射到数组所有索引构成的输出空间。而输入空间往往远大于输出空间。因此，理论上一定存在“多个输入对应相同输出”的情况。

哈希表容量n越大，多个key被分配到同一个桶的概率就低，冲突就越少。可以通过扩容哈希表来减少哈希冲突

哈希表扩容需要将所有键值对从原哈希表迁移到新哈希表，非常耗时

### 哈希冲突
### 哈希算法
### 小结


