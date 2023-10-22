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

