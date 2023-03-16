# javaAdvanced
## 类变量和类方法
### 类变量/静态变量
* 类变量是该类的所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，同样，任何一个该类的对象去修改它时，修改的也是同一个变量
* 最大的特点就是会被Child类的所有对象实例共享
#### 类变量内存布局
* 类加载时，类方法会放在方法区中
* 静态变量被同一个类的所有对象共享；静态变量在类加载的时候就生成了
* jdk8以前放在方法区中，以后的版本放在堆中类对应的class对象中，通过反射机制加载一个class对象（类加载的时候会生成一个class对象）

#### 细节
* 静态变量的访问修饰符的访问权限范围和普通属性一样
* 类名.静态变量 Animal.animal
* 什么时候需要用类变量?
  当我们需要让某个类的所有对象都共享一个变量
* 类变量和实例变量的区别
  类变量是该类的所有对象共享的，而实例变量（属性）是每个对象共享的
* 加上static称为类变量或者静态变量，否则称为实例变量
* 实例变量不能通过类名.类变量名访问；类变量可以使用类名.类变量名或者对象名.类变量名来访问（前提是满足访问修饰符的访问权限和范围）
* 类变量是在类加载时就初始化了（会生成class对象），即使你没有创建对象，只要类加载了，就可以使用类变量了
* 类变量的生命周期随类的加载开始，随着类消亡而销毁

### 类方法
* 访问修饰符 static 数据返回类型 方法名(){}
* 开发自己的工具类时，可以将方法做成静态的，方便调用

#### 注意事项
* 类方法和普通方法都是随着类的加载而加载，将结构信息储存在方法区
* 类方法中无this的参数、普通方法中隐含着this的参数（类方法中不能用this，普通方法中不能用this）
* 类方法可以通过类名调用，也可以通过对象名调用
* 普通方法和对象有关，需要通过对象名调用，不能通过类名调用
* 类方法中不允许使用和对象有关的关键字，比如this和super，普通方法则可以
* 类方法中只能访问静态变量或静态方法
* 普通成员方法，既可以访问普通变量/方法，也可以访问静态变量/方法
* 静态方法，只能访问静态成员；非静态方法，可以访问静态成员和非静态成员（必须遵守访问权限）

## main方法
### 语法
* main方法是虚拟机调用
* java虚拟机需要调用main方法，所以该方法的访问权限必须是public
* java虚拟机在执行main方法时不必创建对象，所以该方法必须是static
* 该方法接受String类型的数组参数，该数组中保存执行java命令是传递给所运行的类的参数
* java执行的程序 参数1 参数2 参数3
### 特别说明
* 在main方法中，我们可以直接调用main方法所在类的静态方法或静态属性
* 但是，不能直接访问该类的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员


## 代码块
### 基本介绍
* 代码块（初始化块）属于类中的成员，类似于方法，将逻辑语句封装于方法体中
* 只有方法体，没有方法名、参数、返回，不需要通过对象或类显式调用，在加载类时，或创建对象时隐式调用
```
[修饰符]{代码};
```
* 修饰符可选只能选static
* 有static的是静态代码块，没有就是普通代码块
* ；号可以写也可以忽略//即 [修饰符]{代码}
* 相当于另一种形式的构造器，构造器的补充
* 当构造器中有相同的语句，可以把相同的语句放入到一个代码块中
* 不管调用那个构造器，都会先去调用代码块中的内容
* 代码块调用顺序优先于构造器

### 细节
* Ⅰ静态代码块随着类的加载而执行，并且只会执行一次，普通代码块，每创建一个对象，就执行
* Ⅱ类什么时候被加载？
* 1、创建对象实例时 new
* 2、创建子类对象实例，父类也会被加载
* 3、使用类的静态成员时


* Ⅲ普通代码块在创建对象实例时，会被隐式的调用，被创建一次就被调用一次；如果只是使用类的静态成员时，普通代码块不会被执行

* Ⅳ创建一个对象时，在一个类调用顺序是：
* 1、调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用），静态属性初始化是让一个方法返回一个值，把方法赋给静态属性
* 2、调用普通代码块和普通属性的初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和多个普通属性初始化，则按定义顺序调用）
* 3、调用构造器

* 构造方法（构造器）的最前面隐含了super和调用普通代码块，静态相关的代码块、属性初始化在类加载时，就执行完毕了，因此是优先于构造器和普通代码块执行的
* 创建一个子类时（继承关系），他们的静态代码块，静态属性初始化，    普通代码块，普通属性初始化，构造方法调用如下：
* Ⅰ、父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
* Ⅱ、子类的静态代码块和静态属性（优先级一样，按定义顺序执行）
* Ⅲ、父类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
* Ⅳ、父类的构造方法
* Ⅴ、子类的普通代码块和普通属性初始化优先级一样，按定义顺序执行）
* Ⅵ、子类的构造方法

* 静态代码块只能直接调用静态成员（静态属性和静态方法），普通代码块可以调用任意成员


## 单例模式和final-重要
* 采取一定的方法保证在整个软件运行过程中，对某一个类只能存在一个对象实例
### 单例模式饿汉式
* 构造器私有化防止直接new
* 类的内部创建对象static
* 向外暴露一个静态的公共方法 getInstance
  
### 单例模式懒汉式
* 私有化构造器
* 定义一个static属性
* 提供一个public的static方法，再返回一个Cat对象
  
### 区别
* 最主要的区别是创建对象的时机不同，饿汉式是类加载时就创建了对象实例，懒汉式是在使用时才创建
* 饿汉式不存在线程安全问题，懒汉式存在线程安全问题
* 饿汉式存在浪费资源的可能，因为如果程序员一个对象实例都没有使用，那么饿汉式创建的对象就浪费了，懒汉式是使用时才创建，就不存在这个问题
* java.lang.Runtime就是经典单例模式

### final
#### 基本使用
* final可以修饰类、属性、方法和局部变量
#### 特殊情况
* 当不希望类被继承时，可以用final修饰
* 当不希望父类的某个方法被子类覆盖/重写（override）时，可以用final修饰
* 当不希望类的某个属性值被修改，可以用final修饰
* 当不希望局部变量被修改可以用final修饰
#### 细节
* final修饰的属性又叫常量，一般用xx_xx_xx来命名
* final修饰的属性在定义时，必须赋初值，并且以后不能再修改，赋值可以在如下位置之一
* Ⅰ、定义时
* Ⅱ、在构造器中
* Ⅲ、在代码块中
* 如果final修饰的属性时静态的，则初始化的位置只能是①定义时、②在静态代码块；不能在构造器中赋值
* final类不能继承，但是可以实例化对象
* 如果类不是final类但是含有final方法，则方法虽然不能重写，但是可以被继承
* 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
* final不能修饰构造方法
* final和static搭配使用效率更高，不会导致类加载（只是想用一下那个属性）；底层编译器做了优化处理
* 包装类（Integer,Boolean）都是final，String类也是final类


## 抽象类
### 引出
* 当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那个类就是抽象类
### 细节
* 用abstract关键字修饰一个类时，这个类就是抽象类
* 用abstract来修饰一个方法时，这个方法就是抽象方法 
* //访问修饰符 abstract 返回类型 方法名(参数列表);最重要的就是没有方法体
* 抽象类的价值更多作用是在于设计，是设计者设计好后，让子类继承并实现抽象类
* 抽象类不能被实例化
* 抽象类不一定包含abstract方法。即抽象类可以没有abstract方法
* 一旦类包含类abstract方法，则这个类必须声明为abstract
* abstract只能修饰类和方法，不能修饰属性和其他的

* 抽象类可以有任意的成员（抽象类还是类）
* 抽象方法不能有主体，即不能实现
* 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非他自己也声明为抽象类
* 抽象方法不能使用private、final、static来修饰，因为这些关键字都是和重写相违背的
### 模板设计模式

### 面试题：抽象类和接口的区别

## 接口详解
### 接口介绍
* 接口就是给出一些没有实现的方法，封装到一起，到某个类要使用时，再根据具体情况把这些放啊写出来
```
interface 接口名{
    //属性
    //方法
}
class 类名 implements 接口{
    自己属性;
    自己方法;
    必须实现的接口的抽象方法;
}
```
* 在jdk7.0之前接口里的所有方法都没有方法体
* jdk8.0之后接口类可以有静态方法、默认方法(需要default修饰)，即接口里可以有方法的具体实现
* 在接口中，抽象方法可以不加abstract


### 细节
* 接口不能被实例化
* 接口中所有的方法是public方法，接口中抽象方法可以不用abstract修饰
* 一个普通类实现接口，就必须将该接口的所有方法都实现
* 抽象类实现接口，可以不用实现接口的方法
* 一个类同时可以实现多个接口
* 接口中的属性只能是final的，而且是public static final修饰符；比如int a=1;==public static final int a=1;
* 接口中属性的访问形式：接口名.属性名
* 一个接口不能继承其他的类，但是可以继承多个别的接口
* interface A extends B,C{}
* 接口的修饰符只能是public 和默认，这点和类的修饰符是一样的
* 
### 接口与继承
* 猴子与老猴子（继承）；猴子学习飞行（实现）
* 继承解决代码的复用性
* 接口更加灵活 继承满足is-a，接口like-a的关系


### 接口与多态
#### 多态特性
* 多态参数:接口引用可以接受不同的对象
* 接口类型的变量(if)可以指向实现了该接口(IF)的类的对象实例
* IF if=new Monster()  if=new Car();
* 访问接口的属性就用接口名.属性名，IF.a

## 四种内部类详解
### 基本介绍
* 一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类，嵌套其他类的称为外部类；内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系

### 内部类分类
* 定义在外部类局部位置上（比如方法内）
* Ⅰ 局部内部类（有类名） Ⅱ  匿名内部类（没有类名）
* 定义在外部类的成员位置上
* Ⅰ 成员内部类（没有static修饰） Ⅱ  静态内部类（使用static修饰）

### 局部内部类（本质仍是类）
* 局部内部类是定义在外部类的局部位置上，通常在方法中或者代码块，并有类名
* 1、可以直接访问外部类的所有成员，包含私有的
* 2、不能添加访问修饰符，因为它的地位就是一个局部变量。局部变量是不能使用修饰符的。但是可以使用final修饰，因为局部变量也可以使用final
* 3、作用域：仅仅在定义它的方法或代码块中
* 4、局部内部类--访问-->外部类的成员（访问方式：直接访问）
* 5、外部类--访问-->局部内部类的成员（访问方式：创建对象，再访问；注意：必须在作用域内）
* 6、外部其他类---不能访问-->局部内部类（因为局部内部类地位是一个局部变量）
* 7、如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类成员，则可以使用（外部类名.this.成员）去访问//其他类访问外部类成员
* 

### 匿名内部类
* 说明：匿名内部类是定义在外部类的局部位置，比如方法中，并且没有类名
```
new 类或接口(参数列表){
    类体
};
```
* 本质是类；内部类；没有类名；同时还是一个对象
#### 细节
* 匿名内部类的语法比较奇怪，因为匿名内部类既是一个类的定义，同时它本身也是一个对象，从语法上看，它既有定义类的特征，又有创建对象的特征
* 可以直接访问外部类的所有成员，包含私有的
* 不能添加访问修饰符，因为他的地位就是一个局部变量
* 作用域：仅仅在定义它的方法或代码块中
* 匿名内部类---访问--->外部类成员[访问方式：直接访问]
* 外部其他类--不能访问-->匿名内部类（因为匿名内部类地位是局部变量）
* 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类成员，则可以使用（外部类名.this.成员）去访问
* 使用场景：把匿名内部类当作实参
### 成员内部类
* 成员内部类是定义在外部类的成员位置，不用static修饰
* 可以直接访问外部类的所有成员包括私有的
* 可以添加任意一个修饰符，因为它的地位就是一个成员
* 作用域和外部类的其他成员一样，作用域为整个类体,可以在整个外部类中使用。比如前面案例，在外部类的成员方法中创造成员内部类对象，再调用方法
* 成员内部类--访问--->外部类（比如属性）[访问方式：直接访问]
* 外部类--访问--->内部类 [访问方式：创建对象再访问]//也可以写个方法返回内部类对象
* 外部其他类--访问-->成员内部类
```
方式1
Outer08 outer082 = new Outer08();
Inner08 inner081 = outer08.new Inner08();
方式2
 Outer08.Inner08 inner082 = outer08.getInnerInstance();
```
* 如果外部类和局部内部类的成员重名时，内部类访问，默认遵循就近原则，内部类如果想访问外部类成员，则可以使用（外部类名.this.成员）去访问

### 静态内部类
* 静态内部类是定义在外部类的成员位置，并有static修饰
* 可以直接访问外部类的所有静态成员，包含私有的，但是不能直接访问非静态成员
* 可以添加任意访问修饰符，包含私有的，但是不能直接访问非静态成员
* 作用域：同其他的成员，为整个类体
* 静态内部类--访问-->外部类（比如静态属性）[访问方式：直接访问所有静态成员]
* 外部类--访问-->静态成员 访问方式：创建对象，再访问
* 外部其他类--访问--->静态内部类
```
方式1
B b1=new A.B();//这里就不会创建一个A对象实例
b1.say();
方式2
B b2=new A().getBInstance();
```
* 如果外部类和局部内部类的成员重名时，静态内部类访问的时候，默认遵循就近原则，内部类如果想访问外部类成员，则可以使用（外部类名.成员）去访问

## 枚举Enum
### 枚举类
#### 自定义枚举
* 不需要提供set方法，因为枚举对象通常为只读
* 对枚举对象/属性使用final+static共同修饰，实现底层优化
* 枚举对象名通常要全部大写，常量的命名规范
* 枚举对象根据需要，也可以有多个属性
##### 步骤
* 构造器私有化
* 本类内部创造一组对象
* 对外暴露对象（通过为对象添加public final static）
* 可以提get方法，不要提供set方法
### enum枚举类
* 使用enum实现枚举类
* 使用关键字enum代替class
* 常量名(实参列表)
* 如果有多个常量，使用，号间隔
* 如果使用enum实现枚举，要求将定义常量对象写在前面
* 当使用enum开发一个枚举类时，默认会继承enum类
* 传统的 public static final Season SPRING=new Season("","");简化成SPRING("",""),这里必须知道它调用的是哪个构造器
* 如果使用无参构造器创建枚举对象，则实参列表和小括号可以省略
* 当有多个枚举对象时，使用，号间隔，最后有一个分号结尾
* 枚举对象必须放在枚举类的行首
* 访问对象实例就是访问toString方法
```
enum Gender{
    BOY;
}
Gender boy =Gender.BOY;
system.out.println(boy);//就是访问Gender父类enum的tostring方法
```
### 枚举成员方法
### 细节
* 使用enum关键字，就不能继承其他类了，因为已经隐式继承了Enum类 
* enum实现的枚举类，仍然是一个类，所以还是可以实现接口的
### 成员方法
* toString:返回当前对象名，子类可以重写该方法，用于返回对象的属性信息
* name:返回当前对象名（常量名），子类中不能重写
* ordinal:返回当前对象的位置号，默认从0开始
* values:返回当前枚举类中的所有常量
* valueOf:将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
* compareTo:比较两个枚举常量，比较的是位置号


## 注解
* 注解也被称为元数据，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息
* 使用Annotation是要在其前面加上@符号，并把该annotation当作一个修饰符使用  
* @interface不是接口，而是注解类 
### override注解
* @Override：限定某个方法，重写父类方法
#### 使用说明
* @override表示指定重写父类的方法（从编译层面上）
* 如果不写@override注解，而父类仍有重名方法，也构成重写
* @override只能修饰方法，不能修饰其他类，包，属性
* 查看@override注解源码为@Target（ElementType.MRTHOD），说明只能修饰方法
* @Target是修饰注解的注解，称为元注解
### deprecated注解
* Deprecated：用于表示某个程序元素（类、方法）已经过时
* 可以修饰方法、类、字段、包、参数
* @Target（value{CONSTRUCTOR，  FIELD,LOCAL_VARIABLE,METHOD,PACKAGE,PARAMETER,TYPE}）
* @Deprecated的作用可以做到新旧版本的兼容和过渡
### suppressWarnings注解
* @SuppressWarnings：抑制编译器警告
### 四种元注解
#### @Retention注解
* 只能用于修饰一个Annotation定义，用于指定该annotation可以保留保存多长时间，@retention包含一个RetentionPolicy类型的成员变量，使用@Retention时必须为该value成员变量指定值
* SOURCE：编译器使用后，直接丢弃这种策略的注释
* CLASS：编译器将把注解记录在class文件中，当运行java程序时，jvm不会保留注解，这是默认值
* RUNTIME：编译器将把注解记录在class文件中，当运行java程序时，jvm会保留注接
  
#### @Target
* 用于修饰annotation定义，用于指定被修饰的annotation能用于修饰哪些程序元素
#### @Documented
* 用于指定被该元annotation修饰的annotation类将被javadoc工具提取成文档，即在生成文档时，可以看到该注解
#### @Inherited注解
* 被它修饰的annotation将具有继承性，如果某个类使用了被@Inherited修饰的annotation，其子类将自动具有该注解， 


## 异常
### 异常-面试
#### 举例常见异常的例子
* 编译异常和运行异常
#### error和exception的区别和对应的例子
* error：jvm无法解决的问题
* exception:其他因编程错误或偶然的外在因素导致的一般性问题
### 异常的概念
* 程序执行中发生的不正常情况称为异常（语法错误和逻辑错误不是异常）
* 执行过程中的异常时间分为error和Exception
* error：jvm无法解决的严重问题
* exception：其他因编程错误或偶然的外在因素导致的一般性问题
* exception分为两大类：运行时异常、编译时异常
### 异常体系图
  编译异常                             运行异常
* java源程序--javac.exe---字节码文件--java.exe--在内存中加载、运行类

* 运行时异常，编译器检查不出来。一般是指编程时的逻辑错误，是程序员应该避免其出现的异常 java.lang.RuntimeExcption类及它的子类都是运行时异常
* 对于运行时异常，可以不作处理，因为这类异常很普遍，若全处理会对程序的可读性和运行效率产生影响
* 编译时异常是编译器要求必须处理的异常
### 常见的异常
* NullPointerExcption 空指针异常
* 当应用程序试图在需要对象的地方使用null时，抛出该异常
* ArithmeticException 数学运算异常
* ArrayIndexOutOfBoundsException数组下标越界异常
* 用非法索引访问数组
* ClassCastException 类型转换异常
* 当试图将对象强制转换为不是实例的子类时，抛出该异常    
* NumberFormatException数字格式不正确异常
* 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换成适当格式时，会抛出异常-->使用异常我们可以确保输入是满足条件数字

### 编译异常
* 编译异常指在编译期间，就必须处理的异常，否则代码不能通过编译
* 常见的编译异常
* SQLexception 操作数据库时，查询表可能发生异常
* IOException 操作文件时发生的异常
* FileNotFoundException 当操作一个不存在的文件时，发生异常
* ClassNotFoundException 加载类，而该类不存在时异常
* EOFException 操作文件到文件末尾发生异常
* IIlegalArguementException 参数异常
### 异常处理方式
* Ⅰ try-catch-finally
* 程序员在代码中捕获发生的异常，自行处理

```
try{
    //代码有可能有异常
}catch(Exception e){
    //捕获到异常
    //1、当异常发生的时候   
    //2、系统将异常封装成Exception对象e，传递给catch
    //3、得到异常处理对象后，程序员自己处理
    //4、如果没有发生异常catch代码块不执行
}finally{
    //1、不管try代码块是否有异常发生，始终要执行finally
    //2、通常将释放资源的代码放在finally
}
```
* Ⅱ throws处理机制
* 将发生的异常抛出，交给调用者（方法）来处理，最顶级的处理者就是jvm
* jvm-->main-->f1()方法-->f2()方法抛出异常--throws-->f1()可以选择try-catch-finally/throws->main可以选择try-catch-finally/throws-->jvm（处理异常：1、输出异常信息2、退出程序）
* try-catch=finally和throws二选一
* 如果程序员没有显式的处理异常，默认就是throws



## try|catch|throws
### 掌握度
1、知道 try catch finally 的一个执行顺序，以及掌握如何使用他们。
2、还有一个很重要的点就是，如果有 finally，那么无论是否发生异常，都有执行 finally 的语句，即使 catch 里面有 return 语句，那么也会执行 finally。

3、明白 try-catch-finally 来处理异常了，为啥还需要 和 throws 的使用区别，就是有了 try-catch-finally 来处理异常了，为啥还需要 throws 呢

这个面试其实问的不多，在笔试选择题会多一些
### 面试

13、throw和throws的区别

14、try catch会影响性能吗？为什么抛出异常的时候会影响性能？
### try-catch异常处理
* java提供try和catch来处理异常，try块用于包含可能出错的代码，catch块用于处理try块中发生的异常，
* 如果没有finally，语法上允许
#### try-catch细节
* 如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块中
* 如果异常没有发生，则顺序执行try的代码块，不会进入到catch代码块
* 如果希望不管是否发生异常，都执行某段代码，则使用finally{}(加finally代码块)
* 可以有多个catch语句，捕获不同的异常(进行不同的业务处理)，要求父类异常在后，子类异常在前，比如（Exception在后，NullPointerExcepting在前），如果发生异常，只会匹配一个catch
* 可以进行try-finally配合使用，这种用法相当于没有捕获异常，因此程序会直接崩掉（应用场景：执行一段代码，不管是否发生异常，都必须执行某个业务逻辑）

#### 小结
* 如果出现异常，则try块中异常发生后，try块剩下的语句不再执行，将执行catch块中的语句，如果有finally，最后还需要执行finally块中的语句


### throws异常处理
#### 基本介绍
* 如果语句执行中可能生成某种异常，但是不能确定如何处理异常，则此方法应显式的声明抛出异常，表明该方法将不对这些异常进行处理，而是由该方法的调用者负责处理
* 在方法声明中用throws语句可以声明抛出异常的列表，throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类，throws后面可以是异常列表，即抛出多个异常
#### 细节
* 对与编译异常，程序中必须处理，比如try-catch或throws
* 对于运行时异常，程序中如果没有处理，默认就是throws方式处理
* 子类重写父类的方法时，对抛出异常的规定：子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么时父类抛出异常类型的子类（见throwDetail.java）
* 在throws过程中，如果有方法try-catch，就相当于处理异常，就不必throws

### 自定义异常
* 当程序中出现了某些错误，但该错误信息并没有在Throwable子类中描述处理，这个时候可以自己设计异常类，用于描述错误信息
* 一般情况，自定义异常继承RuntimeException；把自定义异常做成运行时异常，这样可以使用默认的处理机制

### throw和throws区别
||意义|位置|后面跟的东西|
|---|---|---|---|
|throws|异常处理的一种方式|方法声明处|异常类型|
|throw|手动生成异常对象的关键字|方法体中|异常对象|


## 八大常用类
* 针对八种基本数据里欸选哪个相应的引用类型--包装类
* 有了类的特点，就可以调用类中的方法
|基本数据类型|包装类|
|---|---|
|booLean|Boolean|
|char|Character|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|父类：Number
|float|Float|
|double|Double|

## Integer类：拆箱与装箱
### 面试问题
1、掌握拆箱与装箱的大致过程
2、了解下缓存池 cache，掌握下缓存的数值范围，另外关于这种缓存之类的，后面 JVM 会详细讲

一般面试官会问你下装箱和拆箱的理解，然后具体的这种数值比较，判断 true false 之类的，一般在笔试中出现多一些
### 包装类
* jdk5以前的手动装箱和拆箱的方式，装箱：基本类型->包装类型，反之，拆箱
* jdk5以后（含jdk5）的自动装箱和拆箱方式
* 自动装箱底层调用的是valueOf方法
* 注意：只要有基本数据类型，==判断的就是值是否相同

### Integer类：拆箱与装箱

//手动装箱int->Integer
int n1=100;
//方式1
Integer integer=new Integer(n1);
//方式2
Integer integer1=Integer.valueOf(n1);

//手动拆箱 Integer->int
int i=integer.intValue();
//自动装箱
int n2=200;
Integer integer2=n2;//底层使用valueOf()
```
public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
```
//自动拆箱
int n3=integer2;//底层使用intValue()

#### 包装类型和String类型的转换
##### 包装类Integer-->String
```
Integer n1=100;
//方式1
String str=n1.toString();
//方式2
String str2=n1+"";
//方式3
String str3=String.valueOf(n1);
```
##### String-->包装类Integer
```
String str4="1234";
Integer i=Integer.parseInt(str4);
Integer i1=new Integer(str4);
```
#### 包装类的常用方法
```
Integer.MIN_VALUE//返回最小值
Integer.MAX_VALUE//返回最大值

Character.isDigit('a')//判断是不是数字
Character.isLetter('a')//判断是不是字母
Character.isUpperCase('a')//判断是不是大写
Character.isLowerCase('a')//判断是不是小写

Character.isWhitespace('a')//判断是不是空格
Character.toUpperCase('a')//转成大写
Character.toLowerCase('a')//转成小写
```

#### Integer面试题
```
    Integer i = new Integer(1);
    Integer j = new Integer(1);
    System.out.println(i == j);// 对象的比较 false

    Integer m = 1;// 底层装箱 Integer.valueOf(1)
    Integer n = 1;
    // 如果范围在-128-127直接返回，否则就new Integer(xx)
    System.out.println(m == n);// T
    
    Integer x = 128;
    Integer y = 128;
    System.out.println(x == y);// F
    /*public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
}   
    */
```
```
    Integer i5 = 127;// 使用底层的Integer.valueOf()
    Integer i6 = 127;
    System.out.println(i5 == i6);
    Integer i7 = 128;
    Integer i8 = 128;
    System.out.println(i7 == i8);
    Integer i9 = 127;
    int i10 = 127;
    // 只要有基本数据类型判断的就是值是否相同
    System.out.println(i9 == i10);
```
## String详解
### 面试题
5、用户自己写一个String类，会发生什么？

6、语句 String s = new String(“aa”) 会创建多少个对象？
### String结构
* String实现了serialize接口，可以串行化（数据可以在网络传输）
* comparable：String对象可以相互比较
* String是final类，不能被其他的类继承
* String有属性private final char value[],用于存放字符串内容
* value是final类型，不可以修改（地址不可以修改）（value不能指向新的地址，但是单个字符内容可以变化 "tom"->"toh"）
* String对象用于保存字符串，也是一组字符序列
* 字符串常量对象是用双引号括起的字符序列
* 字符串的字符使用Unicode编码，一个字符占两个字节
#### String赋值方式
##### 直接赋值
* String s="hsedu";
* 先从常量池查看是否有“hsedu”数据空间，如果有，直接指向，如果没有则创建，然后指向，s最终指向的是常量池的空间地址
##### 调用构造器
* String s2=new String("hsedu");
* 先在堆中创建空间，里面有value属性，指向常量池的hsedu空间；如果常量池里没有“hsedu”，重新创建，如果有，直接通过value指向，最终s2指向的是堆中的空间地址
* 调用intern方法时，如果池已经包含一个等于此String对象的字符串（用equals（Object）确定），则返回池中的字符串。否则，将此String对象添加到池中，并返回此String对象的引用
* b.intern()方法最终返回的是常量池的地址（对象）
* equals()方法重写过，功能是比较内容是否相同
### String对象特性
* String是一个final类，代表不可变的字符序列
* 字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的
```
Stirng s1="hello";
s1="haha";//s1
```
* String c1="ab"+"cd"优化成String c1="abcd"; 判断创建的常量池对象是否有引用指向
* 常量相加，看的是池  String c1=a+b;变量相加，是在堆中
```
String a="hello"; String b="abc";
String c=a+b;//创建了几个对象：一共创建了三个对象
//1、创建一个StringBuilder sb=new StringBuilder();
//sb在堆中，并且append是在原来字符串的基础上追加的
//2、sb.append("hello");sb.append("abc");
//3、String c=sb.toString(); 
//c指向堆中的对象(String)value[],value[]指向池中的“helloabc” 
```

### String常用方法
* String类用于保存字符串常量，每次更新都要开辟新空间，效率低
* equals 区分大小写
* equalsIgnoreCase 忽略大小写的判断内容是否相等 
* indexOf 获取字符在字符串对象中第一次出现的位置，索引从0开始， 如果获取不到返回-1
* lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，找不到返回-1
* substring 截取指定范围的子串 str.substring(6);从索引6开始截取后面所有的字符
* substring(m,n)从索引m开始截取，截取到第n个字符
* concat 拼接字符 str.concat("abc").concat("cde")
* replace 替换字符串中的字符 str.replace("abc","cde");把str中的abc替换成cde
* split(",")以，为标准对字符串进行分割，返回一个数组
* 在对字符产进行分割时，如果字符串内有特殊字符，需要加转义字符
* str.toCharArray(); 转换成字符数组
* compareTo 比较两个字符串的大小，如果前者大，则返回正数。后者大，则返回负数，如果相等，则返回0
* 如果长度相同，并且每个字符都相同返回0；如果长度相同或不相同，但在进行比较时，可以区分大小（前者长度-后者长度）；如果前面的部分都相同，就返回str1.len-str2.len
* String info=Stirng.format("%s",name);%s占位符
* trim 去前后空格
* charAt 获取某索引处的字符,数组专用，数组不可以用str[i]这种方法获取字符


## StringBuffer与StringBuilder
### 面试
6、String、StringBuilder、StringBuffer有什么区别？
### StringBuffer
* 代表可变的字符序列，可以对字符串的内容进行增删，很多方法与Stirng相同，但是StringBuffer类是可变长度的
* StringBuffer类是一个容器
* StringBuffer的直接父类是AbstractStirngBuilder
* StringBuffer实现了Serializable，即StringBuffer的对象可以串行化
* 在父类中AbstractStirngBuilder有属性char value[] ,不是final，该value数组存放字符串内容，因此是存放在堆中的
* StringBuffer是final类，不能被继承
* 因为StringBuffer字符内容是存在char[] value，所有的变化（增加/删除）不用每次都改变地址（即不是每次都创建新对象），所以效率高于String


#### String VS StringBuffer
* String保存的是字符串常量，里面的值不能修改，每次String类的更新实际上就是更改地址，效率较低；String保存的字符串放在常量池里
* private final char[] value;
* StringBuffer保存的是字符串变量（字符内容存在char[] value），里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址（只有在存储空间不够时，才会去扩容），效率高；
* char[] value;这个放在堆

#### StringBuffer构造器
* StringBuffer() 创建一个大小为16的char[] ,用于存放字符内容
* 通过构造器指定 char[] 大小    new StringBuffer(5);
* 通过给一个String 创建StringBuffer  new StringBuffer("hello");//char数组大小就是str.length()+16=21
#### StringBuffer-->Stirng
* 1 toString()
* 2 String构造器
#### String-->StringBuffer
* append()
* 构造器

#### StringBuffer方法
* s.append(str).append(str1); 把s和str和str1等字符串连接起来 
* delete(start,end);  删除索引为[start,end)处的字符
* replace(m,n,str); 用str代替m-n的字符[m,n) 
* indexOf(str) 查找指定子串在字符串第一次出现的索引，如果找不到返回-1
* insert(m,str) 在索引为m的位置插入str，原来索引为m的内容自动后移

### StringBuilder
#### StringBuilder结构分析
* StringBuilder继承AbstractStringBuilder类
* 实现serializable，说明StringBuilder对象可以串行化（对象可以网络传输，可以保存到文件）
* StringBuilder是final类，不能被继承
* StringBuilder对象字符序列仍然是存放在其父类AbstractStringBuilder的char[] value; 因此字符序列在堆中
* StringBuilder的方法，没有做互斥处理，即没有synchronized关键字，因此在单线程情况下选择StringBuilder
#### String、StringBuffer、StringBuilder
* StringBuilder和StringBuffer非常类似，均代表可变的字符序列，而且方法也一样
* String：不可变字符序列，效率低，但是复用率高
* StringBuffer：可变字符序列，效率高，线程安全
* StringBuilder：可变字符序列，效率最高，线程不安全
* 如果我们对String进行大量修改，建议不要使用String
##### 应用场景
* 如果字符串存在大量的修改操作，使用StringBuilder或StringBuffer
* 如果字符串存在大量的修改操作，并在单线程情况下，使用StringBuilder
* 如果字符串存在大量的修改操作，并在多线程的情况下，使用StringBuffer
* 如果我们字符串很少被修改，被多个对象引用，使用String

## 其他常用类
### 关键
日期函数比较重要
### Math
### Math方法
* abs 求绝对值
* pow(m,n) m的n次方
* ceil 向上取整 返回>=该参数的最小整数
* floor 向下取整 返回<=该参数的最大整数
* round 四舍五入 Math.floor(该参数+0.5)
* sqrt 求开方
* random() 返回[0,1)内的整数

### Array
#### 方法
* Arrays.toString(arr) 返回数组的字符串形式 显示数组
* sort排序
* Arrays.binarySearch(arr,n) 通过二分法进行查找，要求必须排好序
* Arrays.sort(arr) 排序，
* sort重载，也可以通过传入一个接口Comparator实现定制排序
* 调用定制排序时，传入两个参数，排序的数组，实现了comparator的匿名内部类，要求实现compare方法
* copyOf(arr,arr.length) 数组元素的复制  从arr中拷贝arr.length个元素到arr中
* 如果拷贝的长度>arr.lenth,就在新数组中加null
* fill(arr,num)  用num去填充arr Arrays.fill(num,99)
* equals(arr,arr2) 比较两个数组元素是否完全一致
* asList 将一组值转换成list
* asList会把(2,3,4,5,6,1)转为List集合
* 返回的asList编译类型 List(接口)
* asList运行类型是Arrays类的静态内部类

### system方法
* exit 退出当前程序
* arraycopy 复制数组元素，比较适合底层调用，一般使用Arrays.copyOf完成复制数组
* int[] src={1,2,3};
* int[] dest =new int[3];
* System.arrayCopy(src,0,dest,0,3);0 source 开始的位置 0目标数组开始的位置，3拷贝的个数
* currentTimeMillens 返回当前时间距离1970-1-1的毫秒数
* gc 运行垃圾回收机制 System.gc()
### BigInteger
* 在BigInteger在进行加减乘除时，需要使用对应的方法，不能直接进行加减乘除
* 可以创建一个要操作的BigInteger然后进行相应操作
### BigDecimal
* 当需要保存精度很高的小数时，可以选择BigDecimal
* 如果对BigDecimal进行运算，需要使用相应方法
* 创建一个需要操作的BigDecimal对象然后调用相应的方法    
* 在进行除法时，如果是无限循环小数，会抛出异常，解决方法是在调用divide方法时，指定精度即可。BigDecimal.ROUND_CEILING
* 如果有无限循环小数，会保留分子的精度 
### Date
#### 第一代日期类
* Date 精确到毫秒
* Date读取当前时间，date类在java.util包，默认输出的日期是国外的方式，需要对格式进行转换，使用SimpleDateFormat类
* 可以使用parse(str)把字符串转成对应的Date，Date在输出时，仍然按照国外的形式

#### 第二代日期类Calendar
* Calender是一个抽象类
* 可以提供getInstance()来获取实例
* 提供大量方法和字段
* 获取日期 Calender c=Calender.getInstance(); c.get(Calender.YEAR)
* 返回月的时候，是按0开始编号
* Calendar没有专门的格式化方法，所以需要程序员自己组合显示
* 如果需要24小时进制 Calendar.HOUR_OF_DAY
### 第三代日期类
* LocalDate日期/年月日 LocalTime时间/时分秒 LocalDateTime日期时间/年月日时分秒 jdk8以后加入
* 使用now得到当前日期时间的对象
* LocalDateTime ldt=LocalDateTime.now()
* DateTimeFormatter格式日期类
* Instant时间戳 提供了一系列和Date类转换的方式
* Instant--Date
* Date date=Date.from(instant);
* Date--Instant
* Instant instant date.toInstant();
* MonthDay类：检查重复事件
* 是否是闰年
* 增加日期的某个部分
* 使用plus方法测试增加时间的某个部分
* 使用minus方法检测查看一年前和一年后的日期


## 集合
* 可以动态保存任意多个对象
### 集合框架体系
* 集合框架图要背下来
* 集合主要是单列集合，双列集合
* Collection接口有两个重要的子接口List Set，他们的实现子类都是单列集合
* Map接口的实现子类是双列集合，存放的K-V
#### 单列集合
                            collection
        List                                    Set
ArrayList LinkList Vector        HashSet        TreeSet

### Collection
#### List
#### Set
### Map
### Collections
## List|ArrayList|Vector
## HashSet与LinkedHashSet
## Hashmap与HashTable
## properties
## 集合选型规则
## TreeSet与TreeMap
## Collections工具类
## 泛型
## 多线程详解
## 文件基本操作
## 文件流
## buffered流
## 对象处理流
## 标准输入输出流与打印流
## 网络编程入门
## 网络编程实战
## 反射
