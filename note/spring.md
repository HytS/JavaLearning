## Mybatis 3
### java Api
sqlSession
使用mybatis的主要java接口


## spring

### 解释下什么是 AOP
AOP（Aspect-Oriented Programming，面向方面编程），可以说是 OOP（Object-Oriented Programing，面向对象编程）的补充和完善。OOP 引入封装、继承和多态性等概念来建立一种对象层次结构，用以模拟公共行为的一个集合。当我们需要为分散的对象引入公共行为的时候，OOP 则显得无能为力。也就是说，OOP 允许你定义从上到下的关系，但并不适合定义从左到右的关系。例如日志功能。日志代码往往水平地散布在所有对象层次中，而与它所散布到的对象的核心功能毫无关系。对于其他类型的代码，如：安全性、异常处理和透明的持续性也是如此。这种散布在各处的无关的代码被称为横切（cross-cutting）代码，在 OOP 设计中，它导致了大量代码的重复，而不利于各个模块的重用。

AOP利用一种‘横切’技术，剖解开封装的对象内部，并将那些影响了多个类的公共行为封装到一个可重用模块，并将其名为“Aspect”，简单地说，就是将那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可操作性和可维护性。AOP 代表的是一个横向的关系，如果说“对象”是一个空心的圆柱体，其中封装的是对象的属性和行为；那么面向方面编程的方法，就仿佛一把利刃，将这些空心圆柱体剖开，以获得其内部的消息。而剖开的切面，也就是所谓的“方面”了。然后它又以巧夺天功的妙手将这些剖开的切面复原，不留痕迹。

使用横切技术，AOP把软件系统分为核心关注点和横切关注点。业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点。横切关注点的一个特点是，它们经常发生在核心关注点的多处，而各处都基本相似。比如：权限认证、日志、事务处理。AOP 的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
### ioc的理解
ioc是inversion of control的缩写，一般翻译成控制反转，简单来说就是把复杂系统分解成相互合作的对象，这些对象类通过封装后，内部实现对外部是透明的，从而降低了解决问题的复杂度。ioc理论提出的观点：借助于‘第三方’实现具有依赖关系的对象之间的解耦（ioc容器就是第三方）；由于引进了中间位置的第三方，使得abcd这4个对象没有了耦合关系，全部对象的控制器全部上缴给ioc容器，所以ioc容器成了整个系统的关键核心，把所有对象粘合在一起发生作用，如果没有ioc容器，对象和对象之间会彼此失去联系

为什么ioc是控制反转
软件在没有引进ioc容器前，对象a依赖于对象b，对象a在初始化或运行到某一点的时候，自己必须先主动去创建或使用已创建的对象b，无论使用还是创建，控制器在自己手上
软件引入ioc容器后，对象a和对象b失去了直接联系，所以当对象a运行到需要使用对象b时，ioc容器会主动创建一个对象b注入到a需要的地方；可以看到由主动到被动，控制器颠倒了


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
