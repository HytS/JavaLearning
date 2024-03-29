### 数据类型
整数默认类型是int，byte、char、short参与运算都会转换成int参与运算；boolean不能与其他类型相互转换
数据输入：1、导包2、创建Scanner对象3、接收数据（sc.nextInt()）
Random产生随机数（1、导入包2、创建对象（Random r=new Random()）3、产生随机数（int num=r.nextInt(10) 10代表产生的随机数是0-9））

### 内存分配
内存分配
寄存器：给cpu使用；本地方法栈：jvm在使用os功能的时候使用；方法区：存储可以运行的class文件；堆内存：存储数组和对象，new创建的都放在堆内存；方法栈：方法运行时使用的内存，进入方法栈中执行
数组
arr=null;arr不会存储数组的内存地址；


### 对象、变量
创建对象时会先加载类信息，分配空间，最后把地址分配给引用；对象的属性默认值遵守数组规则

可变参数：java允许将同一个类中多个同名同功能参数不同的方法封装为一个方法；实参可以是0个或1个，实参可以是数组；可变参数要放在形参列表中的最后；一个形参列表只有一个可变参数

javaBean：可以理解为实体类，其对象用于在程序中封装数据
标准javaBean要求：成员变量使用private；提供每一个成员变量的getter/setter方法；必须提供一个无参构造器
### 类
创建对象时会先加载类信息，分配空间，最后把地址分配给引用；方法区的常量池里存放字符信息，方法区里加载类的信息
### 作用域
成员变量可以加修饰符，可以在本类及其他类中使用，有默认值，属性伴随着对象的创建而创建，随着对象的销毁而销毁；局部变量不可以加修饰符，只能在本类的方法中，无默认值，局部变量随着代码块的结束而销毁
局部变量是在栈上分配，局部变量没有默认值，必须被初始化后才能使用，若声明时未初始化，则赋予默认值，局部变量只在声明它的方法、构造方法、语句块内可见，
静态变量是指在类中定义的一个变量，它与类相关而不与实例相关；静态变量可以通过类名和实例名来访问；静态变量在类加载时被创建，在整个程序运行期间都存在，直到程序结束时才被销毁；多个线程访问静态变量会导致数据一致性问题，为了确保静态变量的线程安全性，现需要采用适当的同步措施

### 构造器和this
* 构造器是完成对象的初始化，不是创造对象；构造器没有返回值，修饰符可以默认；构造器的调用由系统完成；
* 创建对象：加载类信息只会加载一次，在堆中分配空间，进行默认初始化（0和null），显式初始化（赋值），构造器初始化，再把堆中的地址返回给对象引用
* jvm会给每个对象分配this，哪个对象调用，this就代表那个对象
* this只能在类定义的内部使用；this只要访问构造器就必须放在第一句
### 修饰符
访问修饰符（同一个类、同一个包的不同类、不同包的子类、不同包下的无关类）
private、protected不能修饰类（外部类）；类和接口不能被private修饰
子类和父类不在同一个包内：子类实例可以访问其从父类继承来的protected方法，不能访问父类实例的protected方法
protected可以修饰数据成员、构造方法、方法成员，不能修饰类（内部类除外），接口和接口的成员变量和成员方法不能声明为protected

访问控制和继承
父类中声明为public的方法在子类中也必须是public；父类中声明为protectedd的方法在子类中要么声明为protected要么声明为public，不可以声明为private；父类中声明为private的方法，不能被子类继承
成员变量一般私有；方法一般公开；如果该成员只希望本类访问，使用私有；

非访问修饰符
synchronized和volatile修饰符，主要用于线程的编程
final修饰的类不能被继承，修饰的方法不能被继承类重新定义
static修饰符：局部变量不能被修饰static；静态方法不能使用类的非静态变量
abstract修饰符：抽象类不能实例化对象，声明抽象类是为了将来对该类扩充；抽象方法不能被声明为final和static；任何继承抽象类的子类必须实现父类的所有抽象方法，除非子类也是抽象类；
synchronized声明的方法同一时间只能被一个线程访问
transient修饰符：序列化的对象包含被transient修饰的实例变量时，jvm跳过该特定的变量，
volatile修饰符：volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
### 继承
当一个类没有extend、implement关键字，则默认继承Object
super：可以实现对父类成员的访问
this：指向自己的引用

子类可以继承父类的私有成员，但是子类不能直接访问父类的私有属性和方法，需要通过父类提供的公共方法去访问
子类不可以继承父类的构造器
创建子类对象时，会先访问父类构造器，完成父类初始化，再去访问子类构造器
在创建子类对象时，不管调用子类哪个构造器，默认调用父类的无参构造器，如果父类没有无参构造器，需要在调用子类构造器时使用super指定使用父类的哪个构造器完成父类的初始化；super在使用时需要放在构造器第一行
super的访问不限于直接父类，如果爷爷类和本类有重名的方法和属性，也可以使用super去访问爷爷类的成员

不同包下的类，必须先导包才可以访问；如果某个类使用不同包下的相同类名，此时默认只能导入一个类的包，另一个类要使用全名访问
子类不能直接访问父类的私有属性和方法；创建子类对象，会先调用父类构造器先完成父类的初始化，然后再调用子类构造器；创建子类对象时，默认调用父类的构造器，如果没有无参构造器，就要在子类构造器中用super指定父类构造器
子类不继承父类的构造器，只是隐式/显式的调用
如果父类的构造器带有参数，必须在子类构造器中使用super显式的调用父类构造器并配以适当的参数
如果父类的构造器没有参数，则在子类构造器中不必使用super调用父类构造器
子类构造器中第一句没有写带参或不带参的super(),就默认调用无参的super

### final
final修饰的引用变量指的是它里面的地址不能变，但是地址指向的对象内容是可以变化的
常量在编译阶段会把使用常量的地方换成真实的字面量
final修饰的方法可以被继承但是不能重写；final修饰的类不能继承；final修饰的属性一定要赋值，但是赋值后就不能被修改了

final可以修饰类、方法、属性和局部变量；被final修饰，不可以继承父类、不可以重写父类的方法、不可以修改类的属性值和局部变量；
final修饰属性时必须赋初值，并且不能修改；赋值的位置：定义时、构造器、代码块；
final类不能继承，但是可以实例化对象
如果类没有被final修饰但是有final方法，则可以继承但是不能重写；如果一个类被final修饰，就没有必要再修饰为final方法
final不能修饰构造方法；final和static一起修饰不会导致类加载；
包装类都是final，String也是final
### 重载和重写
重载就是同样的方法根据输入数据的不同，做出不同的处理；重载：允许同一个类中存在多个同名方法，但要求形参个数、类型、顺序选一个不同
声明为final不能被重写；声明为static的方法不能被重写，但是可以被再次声明；子类和父类在同一个包内，子类可以重写除private和final以外的所有方法；子类和父类不在同一个包内，那么子类只能重写父类声明为protected和public的非final方法
重写的方法可以抛出任何非强制异常，无论被重写方法是否抛出异常；但是不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常
每个被重载的方法都必须有独一无二的参数列表；

重写时，子类不能缩小父类的访问权限，子类的返回值只能和父类相同或是父类的返回类型的子类
子类不能重写私有方法、静态方法，

### 多态
父类的向下引用 Cat cat = (Cat)animal
父类的引用可以指向子类的对象
访问属性需要看编译类型
父类的向上引用 Animal animal = new Cat()
可以调用父类的所有成员，不能调用子类的特有成员
在编译阶段，能调用那些成员由编译类型决定；方法的调用看运行类型
java转型问题的核心：父类引用指向子类对象，子类引用不能指向父类对象
向上转型时会遗失除与父类对象公有的其他方法。
只能强制转换父类的引用，不能强转父类的对象，对象不能改变；
要求父类的引用必须指向的是当前目标类型的对象
子类之间不能相互转换；向下转型后，可以调用子类的所有成员

属性的值看编译类型，属性没有重写问题
动态绑定机制：当调用对象方法时，该方法会和该对象的内存地址/运行类型绑定；当调用对象属性时，没有动态绑定，哪里声明哪里使用




### ==、equals、hashcode、toString、finalize
==判断基本类型的时候比较的是值；判断引用类型时判断的是地址，比较的是两个对象是不是同一个；
hashcode：根据对象不同返回不同的数值；两个引用指向同一个对象，则哈希值一定相同；两个引用指向不同对象，哈希值不同
toString：默认返回全类名@+哈希值十六进制；直接输出一个对象时，toString会被默认调用；toString一般用来返回对象的属性信息
finalize：对象被回收时系统调用finalize(),子类可以重写该方法；当对象没有引用时，系统认为该对象是垃圾；垃圾回收器的调用可以是系统（算法），也可以是System.gc()

两个引用，如果指向同一个对象，哈希值一定一样，如果指向不同对象，哈希值不一样
哈希值根据地址得来，不等同于地址

当输出一个对象时，默认调用toString
对象被回收时，系统自动调用finalize；当对象没有引用时，jvm就认为这个对象是垃圾对象
### 静态方法和静态类
静态变量是该类所有对象共享的变量
类加载时类方法会放在方法区；静态变量在类加载时就生成了，无论是否创建对象，静态变量都已经存在
静态变量在jdk8以前放在方法区中，8以后的版本放在堆中类对应的class对象中，通过反射加载class对象
访问静态变量：类名.静态变量
静态变量的生命周期随类加载而开始，随类销毁而结束

场景：表示对象自己的行为的且方法中需要访问实例成员的，该方法声明为实例方法；如果该方法以执行一个共用功能为目的，则可以声明为静态方法
工具类无需创建对象，建议将工具类的构造器声明为私有；工具类内部都是静态方法，每一个静态方法完成一个功能；

静态方法和普通方法随着类的加载而加载，都是把结构信息放在方法区
静态方法中无this参数，普通方法中隐含着this参数
静态方法可以通过类名和对象名调用，普通方法只能通过对象名调用
静态方法不允许使用和对象有关的关键字（this,super），普通方法可以
静态方法中只能访问静态变量和静态方法

main方法由虚拟机调用，java虚拟机调用main时不用创建对象
main方法接收String类型的数组参数
main方法中可以直接调用main所在类的静态变量和方法，但是不能直接访问非静态成员

### 代码块
代码块只有方法体，在类加载时或创建对象时，被隐式调用；
static{}静态代码块 {}普通代码块
代码块的调用顺序在构造器之前
静态代码块的作用：如果要在启动系统时对静态资源进行初始化，则建议使用静态代码块完成数据的初始化操作
静态代码块随着类加载只执行一次，普通代码块每创建一个对象就加载一次
类加载的时机：1、创建对象实例时2、创建子类对象实例时，父类也会被加载3、使用类的静态成员时
创建一个对象，类的调用顺序：1、调用静态代码块和静态属性初始化（二者优先级相同）2、调用普通代码块和普通属性初始化3、构造器
构造器的最前面隐含了super和调用普通代码块，静态相关的代码块和属性初始化在类加载时就执行完成了
创建一个子类，调用顺序：父类静态代码块、子类静态代码块、父类普通代码块、父类构造器、子类普通代码块、子类构造器

### 单例模式
单例模式：可以保证系统中应用该模式的这个类永远只有一个类，即一个类只能有一个对象    
懒汉单例：1、私有化构造器2、新建一个静态成员变量存放对象，只加载一次，只有一份3、提供一个方法对外返回单例对象
饿汉单例：1、定义一个单例类2、单例必须私有构造器3、定义一个静态变量存储一个对象：属于类，与类一起加载一次

## 接口
接口：给出一些没有实现的方法，封装到一起，到某个类要使用时再具体实现
jdk8之后，接口里可以有静态方法、默认方法，即在接口中可以有方法的具体实现
接口中成员都是public；
在接口中，抽象方法可以不加abstract；接口不能实例化；一个普通类实现接口必须要实现接口里所有方法，否则就要声明为抽象类；一个接口不能继承类，可以继承接口；
接口里的属性是 public static final； 访问接口属性：接口名.属性名
一个类实现多个接口，接口的规范不能冲突，多个接口有同样的静态方法不冲突；一个类继承父类，又实现了接口，父类中有和接口同名的，默认使用父类的；一个类实现多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可；
除非实现接口的类是抽象类，否则该类要定义接口中的所有方法；一个实现接口的类必须实现接口内的所有方法，否则就要声明为抽象类
接口中的方法必须是抽象方法；接口不能包含成员变量，除了static和final变量；接口中每一个方法也是隐式抽象的，接口中的方法被隐式的指定为public abstract；接口中可以含有变量，只是会隐式指定为 public static final；

### 接口为什么不能实例化
实例化的实例意义是在jvm的堆中开辟一片空间，比如Person p=new Person();开辟出一片空间用于存放Person对象，p指向Person对象

接口中存放的是静态属性和方法声明
java内存空间分为堆、栈、代码、静态数据由此可见接口所有的东西的具体值都是存放在代码区和静态数据区，所以接口的这块地址上没有实际的值要存储，所以没必要浪费一片空间，即接口的实例化没有意义

多态参数：接口引用可以接受不同的对象
接口类型的变量(if)可以指向实现了该接口(IF)的类的对象实例（IF if = new Cat() if=new Dog()）
### 抽象类
如果一个类没有足够的信息去描述一个具体的对象，这样的类就是抽象类；抽象类除了不能实例化对象，其他的和普通类一样，因为抽象类不能实例化对象，所以必须被继承
抽象类使用场景：当父类直到子类一定要完成，但是每个子类该行为的实现又不同，这时，父类就把该行为定义为抽象方法，具体的实现交给子类

构造方法和静态方法不能声明为抽象方法
抽象类：当父类需要声明但是又不知如何实现时，可以将其声明为抽象方法，类为抽象类
抽象类的价值多用于设计，让子类继承并实现抽象类；抽象类不能被实例化
抽象类可以没有抽象方法，一旦包含抽象方法就要声明为抽象类
abstract只能修饰方法和类，不能修饰变量、代码块、构造器
抽象方法不能有主体；如果一个类继承了抽象类就必须实现抽象类的所有方法，除非该类声明为抽象类
抽象方法不能用final、static、private修饰，因为这些关键字与重写违背

### 模板方法模式
模板方法模式：当系统中出现同一个功能在多处被开发时，而功能大部分代码都是一样的，只有其中部分不同时
步骤：1、定义一个抽象类2、定义2个方法，相同代码放在模板方法中，不同代码放在抽象方法中3、子类继承抽象类，重写抽象方法
模板方法建议用final修饰，防止子类重写模板方法

多态中成员访问特点
方法调用：编译看左边，运行看右边
变量调用：编译看左边，运行看左边
有继承/实现关系的类可以在编译阶段进行强制转换，如果转换后的类型和对象真实对象的类型不是同一个类型，运行时会抛出异常

### 抽象类和接口的区别
#### 语法层面
* 抽象类可以提供成员方法的实现细节，接口只能存在public abstract方法
* 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final

抽象类中的方法可以有方法体，但是接口中的方法不行；抽象类的成员变量可以是任意类型的，接口中的方法只能是public static final类型的；




### 内部类
内部类可以直接访问私有属性
局部内部类定义在外部类的局部位置上，通常在方法或代码块中，并有类名；可以访问外部类的所有成员；不可以添加访问修饰符，地位上是局部变量；局部内部类访问外部类成员：直接访问；外部类访问局部内部类成员：先创建对象再访问（必须再作用域内）；外部其他类不能访问局部内部类
外部类名.this.成员：其他类访问外部类成员

匿名内部类定义在外部类的局部位置（new 类或接口(参数列表){重写方法;};） 本质是类；没有类名；是个对象
匿名内部类本质上是一个没有名字的局部内部类，同时也代表一个对象；匿名内部类产生的对象类型，相当于是当前new的那个的类型的子类类型
匿名内部类访问外部类成员：直接访问；外部其他类访问内部类：不能访问


成员内部类：定义在外部类的成员位置，不用static修饰；可以直接访问外部类的所有成员；可以添加任何一个修饰符；Outer.Inner in=new Outer().new Inner();
成员内部类可以直接访问外部类静态成员
成员内部类访问外部类：直接访问 内部类访问外部类的实例成员：创建外部类对象再访问（也可以写个返回内部类对象的方法）；在成员内部类中访问所在外部类对象，格式：外部类名.this

静态内部类：定义在外部类成员位置并用static修饰；可以直接访问外部类的静态成员，不可以访问非静态成员，可以添加任意访问修饰符，不可以直接访问非静态成员
Outer.Inner inner=new Outer.Inner();
静态内部类可以直接访问外部类的静态成员，静态内部类不可以直接访问外部类的实例成员；外部类访问静态内部类：创建对象，再访问
静态内部类访问外部其他类：外部类名.成员名



### 枚举
枚举是一种特殊的类，enum定义的枚举类继承了Enum类（values():返回枚举类中所有的值,ordinal()：可以找到每个枚举常量的索引,valueOf()：返回指定字符串值的枚举常量）
枚举是final类，不可以被继承，构造器是私有的，对外不能创建对象；枚举类的第一行默认都是罗列枚举对象的名称的；枚举类相当于是多例模式
枚举可以和普通类一样用自己的变量、方法和构造函数，构造函数只可以使用private修饰，所以外部无法调用；枚举可以包含具体方法，也可以包含抽象方法，如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它
自定义枚举：不需要提供set方法，因为枚举对象是只读、对枚举对象使用final+static修饰、枚举对象名通常大写表示
自定义步骤：构造器私有化、本类内部创造一组对象、对外暴露对象（public static final）、提供get方法
enum枚举类
使用enum实现枚举类，用enum代替class，常量名(实参列表)，多个常量用,间隔
如果使用enum实现枚举，要将定义常量对象写在最前面；使用enum开发一个枚举类会默认继承enum类
枚举对象必须放在枚举类的行首；如果使用无参构造器创建枚举对象，则实参和小括号可以省略

枚举成员方法（values：返回枚举类中所有常量；valueOf：将字符串转换为枚举对象，字符串必须为已有的常量名；compareTo：比较枚举常量的位置）

### 异常
throw用于在代码中抛出异常；throws用于在方法声明中指定可能会抛出异常的类型
try-with-resource：用来打开资源并且可以在语句执行完毕后确保每个资源都被关闭
try(resource declaration){//使用的资源}
catch(ExceptionType E){//异常块}

声明自定义异常
满足的条件：所有异常都必须是Throwable的子类；如果希望写一个检查性异常类，则需要继承Exception类；如果希望写一个运行时异常类，就需要继承RuntimeException

只继承Exception类来创建的异常类是检查性异常类


编译异常：如果不处理，程序无法通过；运行异常：不检查异常，由程序逻辑错误引起的
异常处理机制：try-catch、throws（抛出异常）；如果没有显式处理异常，默认是throws
throws：抛出异常交给调用者来处理
try-catch：异常发生，后面的代码不会执行；异常不发生，执行try语句代码；可以有多个catch语句，捕获不同异常（要求父类异常在后，子类异常在前）
如果出现异常，try后的语句不会执行，直接执行catch语句代码

throws异常处理：如果语句执行中可能出现某种异常，但不能确定如何处理异常，显式声明将异常抛出，表明该方法不对异常进行处理，由方法的调用者进行处理
throws后面的异常类型可以是方法中产生的异常类型也可以是它的父类
运行时异常，程序中没有处理默认throws处理
子类重写父类方法时，所抛出的异常类型要么和父类一致要么是父类异常的子类
在throws过程中，如果有try-catch，则不必throws

自定义异常：当程序中出现某些错误，但错误信息并没在Throwable子类中，这时可以自己设计异常类
一般下，自定义异常继承RuntimeException，把自定义异常做成运行时异常，可以使用默认处理机制
throws在方法声明处添加异常类型；throw在方法体中添加异常对象

装箱：基本类型——>包装类型  拆箱 包装类型-->基本类型；jdk5之前是手动装箱拆箱；jdk5之后是自动装箱（valueOf），自动拆箱（xxValue）;
只要是基本数据类型，==判断的就是值是否相同

Integer->String toString()

### 用户自己写一个String类会发生什么
如果用户自己写一个String类，就会加载不进内存
原因：基于jvm的双亲委派机制，类加载器收到加载器的请求，会把这个请求委派给他的父类加载器。只有父类加载器自己无法完成加载请求时，子类才会自己加载。这样用户自定义的String类的加载请求就会达到顶层的Bootstrap Classloader启动类加载器，启动类加载器加载的是系统中的String对象，而用户编写的java.lang.String不会被加载

不能自己写以java开头的类，其要么由于类加载器的双亲委派机制不能加载进内存，要么即使用自定义的类加载器去强行加载，也会收到SecurityException

toString方法的基本作用是给子类继承，子类对象调用可以返回自己的地址，存在的意义是让子类重写，以便返回子类对象的内容
对象进行内容比较时建议使用equals方法，更安全

创建字符串的方式
* 通过new创建的字符串对象，每一次new都会申请一个内存空间，虽然内容相同，但是地址值不同
* 以""方式给出的字符串，只要字符序列相同，无论在程序代码中出现几次，jvm只会建立一个string对象，并在字符串池中维护

String 调用intern()时，如果常量池中包含一个等于该String对象的字符串，则返回池中的字符串，否则将该String对象添加到对象池中，并返回此对象的引用；intern()返回的是常量池的地址

常量相加，发生在池中；变量相加，发生在堆中
String、StringBuffer、StringBuilder是final，不能被继承
String的字符串存放在 final char value[],地址不可以修改
StringBuffer的字符内容放在char value[]中，所有变化不用每次改变地址来完成，效率高于String
StringBuilder字符序列放在堆中 

String创建的字符串存储在公共池中，而new创建的字符串在堆上
在堆区进行对象生成的过程是不会检测该对象是否已经存在。因此通过new创建的对象，一定是不同的对象，即使字符串内容一样
对于字符串的加运算，当编译成class文件时，会自动编译成StringBuffer来进行字符串的连接操作
创建格式化字符串：
contact是通过复制数组再通过char数组进行拼接生成一个新的对象，地址会变动，而+不会

StringBuffer和StringBuilder类对象可以修改字符串而不创建新的类
在使用StringBuffer类时，每次都会对StringBuffer对象本身进行操作，而不是产生新对象，如果要对字符串本身进行修改推荐StringBuffer
StringBuilder类和StringBuffer最大的区别在于StringBuilder的方法不是线程安全的（不能同步访问），StringBuilder比StringBuffer快，大多推荐StringBuilder

相较于StringBuffer，String发生长度变化，非常消耗内存；

String保存的是字符串常量，StringBuffer保存的是字符串变量；StringBuffer每次更新的是内容，不是内存地址
StringBuffer()创建了一个大小为16的char[];构造器也可以指定数组大小，参数可以是数字或者是字符串（字符串长度+16）

String->StringBuffer append(),StringBuffer构造器
StringBuffer->String String构造器，toString()
StringBuffer线程安全，StringBuilder线程不安全
对字符串需要大量操作时，不用String
### 日期和时间
#### Date
publc Date(long time) 把时间毫秒值转换成Date日期对象
public setTime(long time) 设置日期对象时间为当前时间毫秒值对应的时间
#### SimpleDateFormat
可以把日期时间格式化成为想要的格式
public final String format(Date date) 将日期格式化为日期/时间字符串
public final String format(Object time) 将时间毫秒值化为日期/时间字符串
yMdHms
public Date parse(String source)  从给定字符串的开始解析文本以生成日期

#### Calendar
是个抽象类，不能实例化；代表系统此时的日历对象
public static Calender getInstance() 获取当前日历对象
calendar是可变日期对象，其对象本身表示的时间将产生变化

### jdk8中新增日期类
### 包装类
包装类变量的默认值可以是null；包装类可以将基本类型的数据转换为字符串类型(Integer.toString),也可以将字符串类型的数值转化为真实的数据类型(Integer.parseXX)


### java正则表达式
正则表达式定义了字符串的模式，可以用来搜索、编辑或处理文本；
this is text :匹配字符串"this is text"
this\s+is\s+text:this后的'\s+'可以匹配多个空格，之后匹配is字符串，再之后的\s+匹配多个空格再跟上'text'字符串
^\d+(\.\d+)?:^定义了以什么开始；\d+匹配一个或多个数字；?设置括号内的选项是可选的；\.匹配"."；可以匹配2.21
public boolean matches(String regex) 判断是否匹配正则表达式

### Arrays类
专门用来操作数组元素的
public static?String?toString?(类型[]?a) 返回数组的内容
public static?void?sort?(类型[]?a) 对数组进行默认升序排序
public static?<T>?void?sort?(类型[]?a, Comparator<? super T>?c) 使用比较器对象自定义排序
自定义排序规则：设置Comparator接口对应的比较器对象，来定制比较规则（如果左边大于右边返回正数，右边大于左边返回负数，左右相等返回0）

### Lambda表达式
简化匿名内部类的代码写法
(匿名内部类被重写方法的形参列表 )->{被重写方法的代码}
lambda表达式只能简化函数式接口的匿名内部类的写法形式
函数式接口：必须式接口的匿名内部类，接口中只能有一个抽象方法
#### 省略写法
如果只有一个参数，可以省略参数类型,()也可以省略；如果lambda表达式只有一行代码，可以省略{}和';'，如果这行代码是return，必须省略return

重载的方法必须拥有不同的参数列表，不能仅仅依据修饰符或返回类型的不同来重载方法




Collection接口实现遍历：迭代器遍历（所有实现Collection接口的类都有一个Iterator()方法用于返回一个Iterator接口的对象，即一个迭代器）
Iterator对象称为迭代器，用于遍历Collection中的元素

迭代器的运行原理
Iterator i=col.iterator()//获取迭代器
while(i.hasNext()){//判断是否还有下一个元素，如果有返回true
    System.out.println(i.next())//下移并将下移后集合位置的元素返回
}

ArrayList基本等同于Vector，ArrayList线程不安全，但是执行效率高
transient表示不会被序列化
当创建ArrayList对象时，如果使用无参构造器，则elementData容量为0，第一次添加扩容为10，若再次添加，扩容为上次的1.5倍；如果使用指定大小的构造器，elementData容量为指定大小，如果需要扩容则扩容为上次的1.5 倍
不安全效率高

无参构造器创建ArrayList、有参构造器创建和使用ArrayList

Vector底层也是对象数组，线程安全，vector类的操作方法有synchronized；在开发中，需要线程安全选择vector；扩容：如果无参，初始为10，然后按2倍扩容；如果指定大小，按2倍扩容
安全效率不高


LinkedList修改某个节点对象的方法：set；得到某个节点对象的方法：get

set接口无序（添加和取出的顺序不一致），但是取出的顺序是固定的，没有索引；不允许重复元素，最多包含一个null；
set接口的遍历方式：迭代器、增强for；不能使用索引的方式获取

HashSet实际是HashMap；可以存放null，但是只能有一个；不保证元素有序，不能有重复的元素或对象；不是线程安全，如果多个线程同时修改HashSet，最终结果是不确定的。
HashSet的扩容：HashSet底层是HashMap；添加一个元素时，会将hash值转化为索引值；找到存储数据表table，查看索引值处是否存在元素，如果没有直接插入元素，如果有则调用equals比较，相同则不添加，不同则添加到最后；当链表长度>8且table大小>=64会进行树化

HashSet的底层机制：第一次添加元素时，table数组扩容到16，临界值是16*0.75=12；当table大小达到12，会扩容到16*2=32，新的临界值为32*0.75=24；HashSet扩容，当链表中元素总和>12时也会扩容

LinkedHashSet是HashSet的子类；LinkedHashSet的底层是LinkedHashMap，底层维护了一个table数组和双向链表；LinkedHashSet根据元素的hashcode决定元素的存储位置，同时使用链表维护元素的次序，使得元素看起来是以插入顺序存储的；LinkedHashSet不允许添加重复元素

在添加一个元素时，先求hash值再求索引，确定该元素在hashtable表上的位置，然后将添加的元素加入双向链表（如果已经存在，不添加）
添加第一次，将table扩容到16，存放的节点类型是LinkedHashMap$Entry

Map和Collection并列存在，用于保存具有映射关系的key-value
Map中的k-v可以是任何引用类型的数据，保存在HashSet$Node对象中
Map中key不可以重复，value可以重复；key和value都可以是null，但是key只能有一个null，value可以有很多个null；一对k-v是放在node中的

HashMap是一个散列表，它存储的内容是键值对映射；HashMap实现了Map接口，根据键的Hashcode值存储数据，最多允许一条记录的键为null，不支持线程同步；HashMap的key和value类型可以相同也可以不同

HashMap底层维护了node类型的table数组，默认为null；当创建对象时，将加载因子初始化为0.75
当添加k-v时，通过key的hash值得到table的索引，然后判断索引处是否有元素。如果没有元素直接添加，如果有元素，继续判断该索引处key和准备添加的key是否相同，如果相等直接替换val，如果不相同还要判断是树结构还是链表结构；如果添加时发现容量不够还要扩容

第一次添加时，table扩容为16，临界值是12，再次扩容，容量为32，临界值为24；在java8中，如果数组长度达到8且链表元素个数>=64，就会树化，否则使用数组扩容机制

Hashtable存放的元素是键值对；hashtable的键值对不能都是null；hashtable是线程安全的，hashMap是线程不安全的

properties继承Hashtable类实现Map接口也是用键值对的形式保存数据；properties可以从xxx.properties文件中加载数据到properties类对象并进行读取和修改

迭代器Iterator
next()：返回迭代器的下一个元素，并将迭代器的指针移到下一个位置
hasNext()：用于判断集合是否还有下一个元素可以访问
remove()：从集合删除迭代器最后访问的元素

集合选型规则


有界类型参数：有些时候，可能会想限制那些被允许传递到一个类型参数的类型种类范围
要声明一个有界的类型参数，首先列出类型参数的名称，后跟extend，最后紧跟它的上界
泛型类的类型参数声明部分也包含一个或多个参数类型。一个泛型参数用于指定一个泛型类型名称的标识符

类型通配符一般使用?代替具体的类型参数
<? extends T>表示该通配符所代表的类型是T类型的子类
<? super T>表示该通配符所代表的类型是T类型的父类
泛型好处：编译时，检查添加元素类型，保证安全性；减少类型转换次数，提高效率；不在提示编译警告
泛型在类声明和实例化时要指定好需要的类型；泛型可以保证只要编译正常，运行时不会抛出类型转换异常；泛型的作用是在类声明时通过一个标识表示类中某个属性的类型，或某个方法返回值类型、参数类型

在指定泛型具体类型后，可以传入该类型或其子类型
自定义泛型类，普通成员可以使用泛型；使用泛型的数组不能初始化；静态方法中不能使用类的泛型
泛型类的类型是在创建对象时确定的（因为创建对象时需要确定其类型）；如果在创建对象时没有指定类型，默认Object

自定义泛型接口，泛型接口的类型在继承接口或实现接口时确定
自定义泛型方法，可以定义在普通类中也可以定义在泛型类中；当泛型方法被调用时，类型被确定

泛型不具备继承性；<?> 支持任意泛型类型 <? extends A> 支持A类和A的子类 <? super A> 支持A类和A的父类，不限于直接父类

### java流、文件和io
一个流可以理解为一个数据的序列
读取控制台输入：java的控制台由System.in完成，为了获得一个绑定到控制台的字符流，可以把System.in包装在一个BufferReader对象中创建字符流
从控制台读取多字符输入：从BufferReader对象读取一个字符需要使用read()
从控制台读取字符串：从标准输入读取一个字符串需要使用BufferReader的readLine()

控制台的输出由 print( ) 和 println() 完成。这些方法都由类 PrintStream 定义，System.out 是该类对象的一个引用。
PrintStream 继承了 OutputStream类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。

FileInputStream用于从文件读取数据，它的对象可以用new来创建；可以使用字符串类型的文件名来创建一个输入流对象来读取文件
FileOutputStream用来创建一个文件并向文件中写数据；如果该流在打开文件进行输出前，目标文件不存在，那么该流就会创建文件
File类有两个方法可以创建文件夹（mkdir、mkdirs）
一个目录就是一个File对象，它包含其他文件和文件夹。如果创建一个File对象并且它是一个目录，调用isDirectory()会返回true，可以通过调用该对象的list()来提取它包含的文件和文件夹的列表
删除目录或文件：可以使用过delete();需要注意当删除某一目录时，必须保证该目录下没有其他文件才能正确删除

网络编程：编写运行在多个设备的程序，这些设备都通过网络连接起来
tcp：是一种面向连接、可靠的、基于字节流的传输层通信协议，tcp保障了两个程序之间的可靠通信
udp：一个无连接、不可靠协议，提供了程序之间要发送数据的数据报
socket编程


java设计者提供了实现Runnable接口创建线程；java是单继承的，在继承一个父类的情况下，再继承Thread类实现线程不现实

从java设计上看，继承Thread类和实现Runnable接口创建线程没有差别，实现Runnable接口更加适合多个线程共享一个资源的情况，并且避免了单继承的弊端

线程完成任务后会自动退出，或者使用变量控制run方法退出的方式停止线程

start底层会创建新的线程，run是一个简单的方法调用，不会启动新的线程
interupt 中断线程但并没有结束线程，一般用于中断休眠线程；sleep 使当前线程休眠
yield 让出cpu，让其他线程执行，但礼让的时间不确定，所以礼让未必成功
join 线程的插队，插入的线程一旦成功，则肯定先执行完插入的线程所有任务

用户线程/工作线程：当线程的任务执行完或通知方式结束
守护线程：一般为工作线程服务，当所有的工作线程结束，守护线程自动结束

在多线程编程中，一些敏感线程不允许被多个线程同时访问，此时就采用同步访问计数，保证数据在同一时刻最多有一个线程访问
线程同步：当有一个线程对内存进行操作时，其他线程不可以对该内存地址进行操作，直到该线程完成操作，其他线程才可以对内存地址进行操作


同步代码块
synchronized(对象){//获得对象的锁才能操作同步代码}
synchronized可以放在方法声明中，标识整个方法为同步方法

java中引入互斥锁，保证共享数据操作的完整性
每个对象都对应于一个可称为互斥锁的标记，这个标记保证在任一时刻只有一个线程访问该对象
当某个对象用synchronized修饰时表明该对象在任一时刻只能有一个线程访问
同步会导致程序的执行效率降低；非静态同步方法的锁可以是this，也可以是其他对象，要求是同一对象；静态同步对象的锁可以是当前类本身
同步方法如果没有被static修饰，默认锁对象是this；如果方法被static修饰，默认锁对象是当前类.class;实现步骤：分析要被上锁的代码、选择同步方法/同步代码块、要求多个线程的锁对象为同一个

释放锁操作：当前线程的同步方法，同步代码块执行结束；当前线程在同步代码块，同步方法遇到了break、return/出现了未处理的Error、Exception，导致异常结束/执行了线程对象的wait方法，当前线程暂停，并释放锁

线程执行同步代码块或同步方法时，程序调用sleep、yield方法会暂停当前线程，不会释放锁
线程执行代码块，其他线程使用该线程的suspend将线程挂起，不会释放锁

文件在数据中以流的形式来操作；流是数据源和程序之间经历的路径；输入流：数据从数据源到程序
输出流：数据从程序到数据源；创建文件的构造器 File()

流按操作数据单位分为字节流和字符流；按数据流的流向分为输入流和输出流；按流的角色分为节点流、处理流;字节流 InputStream OutputStream  字符流 Reader Writer

InputStream子类：FileInputStream BufferInputStram


### 反射
1.反射的基本概念
使用反射机制可以构造类对象，动态获取当前class的信息比如方法的信息、注解信息、方法的参数、属性
2.实现反射相关的类库
construct、field、method分别获取类的构造方法、成员变量、方法信息
3.反射技术的应用
    1- jdbc加载驱动连接 class.forname时运用到了反射技术
    2- spring框架用反射来实例化对象
    3- 自定义注解生效（反射+aop）
    4- 第三方核心的框架
    5- 动态代理的场景
4.优点
增加程序的灵活性，可以在运行的过程中动态对类进行修改和操作；提高代码的复用率；可以在运行时轻松获取任意一个类的方法、属性
5.缺点
反射会涉及到动态类型的解析，所以jvm无法对这些代码进行优化，导致性能要比非反射调用更低；使用反射后代码可读性更低；

6. 程序运行过程的对比
Java程序的运行过程：
Person.java -> 编译器 -> Persion.class -> Java虚拟机 ->运行程序
Person = new Person()
虚拟机在执行的时候已经确切知道要实例化哪个类的对象

使用Java反射后程序运行的过程：
Java反射? -> 编译器 <=> 运行程序
虚拟机在实例化对象的时候，可以事先不知道要实例化哪个类的对象，传参的时候虚拟机根据参数确定要实例化哪个类的对象；根据参数不同，虚拟机可以实例化任意类型对象。
Class clz = Class.forName("persionPackage.Persion");
 
Object obj = clz.newInstance();
 
执行Class.forName的时候，类加载器会根据参数persionPackage.Persion去找这个类，把这个类加载到Java虚拟机，同时获取这个类的Class对象，每个类都有Class类型的对象，
 
这个对象保存了对应对象的元信息（属性，方法，构造函数）接下来再调用newInstance方法来实例化对象

