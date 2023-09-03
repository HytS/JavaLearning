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
* 接口就是给出一些没有实现的方法，封装到一起，到某个类要使用时，再根据具体情况把这些方法写出来
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
* IF if=new Monster()  if=new com.hsedu.Car();
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
* value是final类型，地址不可以修改（字符串的值可以修改）（value不能指向新的地址，但是单个字符内容可以变化 "tom"->"toh"）
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
* 常量相加，看的是池 ； String c1=a+b 变量相加，是在堆中
```
String a="hello"; String b="abc";
String c=a+b;//创建了几个对象：一共创建了三个对象
//1、创建一个StringBuilder sb=new StringBuilder();
//sb在堆中，并且append是在原来字符串的基础上追加的
//2、sb.append("hello");sb.append("abc");
//3、String c=sb.toString(); 
//a,b指向常量池中的字符串
//c指向堆中的对象(String)value[],堆中的value[]指向池中的“helloabc” 
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

### 面试
集合类的顶级接口
### 集合框架体系
* 集合框架图要背下来
* 集合主要是单列集合，双列集合
* Collection接口有两个重要的子接口List Set，他们的实现子类都是单列集合
* Map接口的实现子类是双列集合，存放的K-V
#### 单列集合
                            collection
        List                                    Set
ArrayList LinkList Vector        HashSet        TreeSet

### Collection接口和常用方法
#### Collection接口实现类的特点
* collection实现子类可以存放多个元素，每个元素可以是Object
* 有些Collection的实现类，可以存放重复的元素，有些不可以
* 有些Collection的实现类，有些是有序的(List)，有些不是有序的(Set)
* Collection接口没有直接的实现子类，是通过它的子接口Set和List来实现的

### Collction接口遍历元素方式1-迭代器遍历
* Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
* 所有实现了Collection接口的集合类都有一个Iterator()方法，用于返回一个实现了Iterator接口的对象，即可以返回一个迭代器    
* Iterator的结构
* Iterator仅用于遍历集合，Iterator本身并不存放对象

#### 迭代器的执行原理
```
Iterator iterator=coll.iterator();//得到一个集合的迭代器
while(iterator.hasNext()){}//hasNext() 判断是否还有下一个元素，如果有返回true
//next()作用:1、下移2、将下移以后集合位置的元素返回
System.out.println(iterator.next());
```
* 在调用iterator.next()前必须要调用iterator.hasNext()进行检测，若不调用且下一条记录无效，直接调用iterator.next()会抛出NoSuchElementException异常

## List|ArrayList|Vector
17、ArrayList和LinkedList区别

19、list和set有什么区别 （只说了特性应该扩展说说）
一般会问Array List和Vector的区别，底层数据结构区别，扩容区别，是否线程安全等。
### List接口和常用方法
#### List接口
* List接口时Collection接口的子接口
* List集合类中元素有序（即添加顺序和取出顺序一致），且可重复
* List集合中的每一个元素都有其对应的顺序索引
  
### ArrayList底层结构和源码分析
#### 注意事项
* 允许多个元素，包括空值，ArrayList可以加入null，并且多个
* ArrayList是由数组来实现数据存储的
* ArrayList基本等同于Vector，除了ArrayList是线程不安全（执行效率高），在多线程情况下不建议用ArrayList
#### ArrayList的底层操作机制源码分析
* ArrayList中维护了一个Object类型的数组elementData  transient Object[] elementData;//transient 表示瞬间 表示该属性不会被序列化
* 当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，第一次添加，则扩容elementData为10，如需要再次扩容，则扩容elementData为1.5倍
* 如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容，则直接扩容elementData为1.5倍
##### 分析使用无参构造器创建和使用ArrayList
* 无参构造器  this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;创建了一个空的elementData数组={}
* 执行list.add{ensureCapacityInternal; elementData[size++] = e} 1、先确定是否要扩容2、然后再执行赋值
* ensureCapacityInternal方法确定minCapacity; 1、第一次扩容为10
* ensureExplicitCapacity方法 1、modCount++记录集合被修改的次数 2、如果elementData的大小不够，就调用grow去扩容(minCapacity - elementData.length > 0)
* grow方法 1、扩容功能实现2、使用扩容机制来确定要扩容到多大3、第一次newCapacity=10; 4、第二次及以后都是1.5倍扩容5、扩容使用的是Array.copyOf()//使用copyOf是要确保原有数据不丢失
* elementData = Arrays.copyOf(elementData, newCapacity);
* 注意：使用idea默认情况下，debug显示的数据是简化后的，如果希望看到完整的数据，需要做设置  build--debugger--data view--java--enable alternative view 取消选中

##### 分析使用有参构造器创建和使用ArrayList
* 有参构造器创建一个指定大小elementData数组 this.elementData=new Object[initialCapacity]
* ensureCapacityInternal
* ensureExplicitCapacity
* grow

### Vector
#### 
* Vector底层也是一个对象数组 protected Object[] elementData
* vector是线程同步的，即线程安全，vector类的操作方法带有synchronized
* 在开发中，需要线程同步安全时，考虑使用vector

||底层结构|版本|线程安全效率|扩容倍数|
|---|---|---|---|---|
|ArrayList|可变数组|jdk1.2|不安全，效率高|如果有参构造1.5倍，如果无参，第一次10，第二次按1.5倍扩|
|Vector|可变数组|jdk1.0|安全效率不高|如果是无参默认10，满后按2倍扩容；如果指定大小，每次按2倍扩|

#####
* 如果是无参构造器，默认给10
* add(i)--确定是否需要扩容minCapacity - elementData.length > 0--
```
 int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
capacityIncrement : oldCapacity);
```
* ensureCapacityHelper确定是否需要扩容
* 

### LinkedList源码
```
LinkedList linkedList=new LinkedList();
/*  public LinkedList() {} linkList属性first=null last=null
     
*/

remove 默认删除第一个元素
```
#### add 执行添加节点
```
void linkLast(E e) {
        final Node<E> l = last;
        //创建一个新节点 null,e,null
        //l的引用付给新节点
        final Node<E> newNode = new Node<>(l, e, null);
        //
        last = newNode;
        if (l == null)
            first = newNode;
        else
            //l指向新节点
            l.next = newNode;
        size++;
        modCount++;
    }
```

#### remove删除
```
public E remove() {
    return removeFirst();
}
public E removeFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
}
//删除功能的核心
private E unlinkFirst(Node<E> f) {
    // assert f == first && f != null;
    //赋值
    final E element = f.item;
    //让新节点指向删除节点的下一个节点
    final Node<E> next = f.next;
    //数值设空
    f.item = null;
    //指针为空
    f.next = null; // help GC
    //first指向下一个节点
    first = next;
    if (next == null)
        last = null;
    else
        next.prev = null;
    size--;
    modCount++;
    return element;
}
```
* set 修改某个节点的对象
* get 得到某个节点的对象

#### ArrayList和LinkedList比较
||底层结构|增删效率|改查效率|
|---|---|---|---|
|ArrayList|可变数组|较低，数组扩容|较高|
|LinkedList|双向链表|较高，通过链表追加|较低|
##### 如何选择
* 如果我们改查的操作多，选择ArrayList
* 如果我们增删操作多，选择LinkList
* 一般来说，程序中选择ArrayList
* 

### Set
#### Set接口
* 无序（添加和取出的顺序不一致），没有索引；取出的顺序不是添加的顺序，但是是固定的
* 不允许重复元素，所以最多包含一个null
* Set接口的常用方法和Collection方法一样
#### Set接口的遍历方式
* Set接口是Collection接口的子接口
* 1、可以使用迭代器
* 2、增强for
* 3、不能使用索引的方式获取

##### Set接口实现类HashSet
* HashSet实现了Set接口
* HashSet实际上是HashMap，看下源码
* 可以存放null值，但是只能有一个null
* HashSet不保证元素是有序的，取决于hash后，再确定索引的结果（即不保证存放元素的顺序和取出顺序一致）
* 不能有重复的元素/对象
##### HashSet的扩容机制
* HashSet底层是HashMap
* 添加一个元素时，先得到hash值会转成索引值
* 找到存储数据表table，看这个索引位置是否已经存放元素；如果没有直接加入
* 如果有，调用equals比较(不能简单理解成比较内容)，如果相同则放弃添加，如果不同则添加到最后
* 在java8，如果一条链表的元素个数到达TREEIFY_THRESHOLD(默认是8)，并且table大小>=MIN_TREEIFY_CAPACITY(默认64)，就会进行树化
##### HashSet底层机制说明
* HashSet底层是HashMap，第一次添加时，table数组扩容到16，临界值是16*（加载因子是0.75）=12
* 如果table数组使用到了临界值12，就会扩容到16*2=32，新的临界值就是32*0.75=24，以此类推
* 在java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD（默认8）并且table大小>=MIN_TREEIFY_CAPACITY(默认64)就会进行树化，否则仍然采用数组扩容机制

注意：HashSet扩容，不只是table里被添加元素到12个会扩容，当链表中的元素总和>12也会扩容
## LinkedHashSet
### 介绍
* LinkedHashSet是HashSet的子类
* LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组table+双向链表
* LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序，这使得元素看起来是以插入顺序保存的
* LinkedHashSet不允许添加重复元素
#### 说明
* 在LinkedHashSet中维护了一个hash表和双向链表
* 每一个节点有pre和next属性，这样可以形成双向链表
* 在添加一个元素时，先求hash值，再求索引，确定该元素在hashtable的位置，然后将添加的元素加入到双向链表（如果已经存在，不添加）
* 这样的话，遍历LinkedHashSet也能确保插入顺序和遍历顺序一致

#### 源码
* 添加第一次时，直接将数组table扩容到16，存放的节点类型是LinkedHashMap$Entry
* 数组是HashSet$Node[]存放的元素是LinkedHashMap$Entry类型
## Hashmap与HashTable
### 面试要求
* HashMap的底层原理
* HashMap底层为什么用红黑树
### Map接口特点
* Map和Collection并列存在，用于保存具有映射关系的数据key-value
* Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
* Map中的key不允许重复，原因和HashSet一样，
* Map中的value可以重复
* Map的key可以为null，value也可以为null，注意key为null，只能有一个，value为null可以多个
* 常用String类作为Map的key
* key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
* Map存放数据的key-value示意图，一对k-v时放在一个Node中的，又因为Node实现了Entry接口，有些书上也说一对k-v就是一个Entry
### Map接口方法
* remove() 根据键删除映射关系
* get 根据键获取值
* size 获取元素个数
* isEmpty 判断个数是否为0
* clear 清除k-v
* congtainsKey 查找键是否存在

### Map遍历
* containsKey:查找键是否存在
* keySet：获取所有的键
* entrySet：获取所有关系
* values:获取所有的值
### HashMap源码
#### HashMap底层机制
* table数组-->HashMap$Node-->Map$Entry
* (k,v)是一个Node实现了Map$Entry<k,v>

##### 扩容机制
* 扩容机制和HashSet相同
* HashMap底层维护了Node类型的数组table，默认为null
* 当创建对象时，将加载因子初始化为0.75
* 当添加key-val时，通过key的哈希值得到在table的索引。然后判断该索引处是否有元素，如果没有元素直接添加。如果该索引处有元素，继续判断该索引处的key和准备添加的key是否相等，如果相等直接替换val，如果不相等还要判断是树结构还是链表结构，做出相应处理，如果添加时发现容量不够，则需要扩容
* 第一次添加时，需要扩容table容量为16，临界值是16*（加载因子是0.75）=12
* 以后再扩容，就会扩容到16*2=32，新的临界值就是32*0.75=24，以此类推
* 在java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD（默认8）并且table大小>=MIN_TREEIFY_CAPACITY(默认64)就会进行树化，否则仍然采用数组扩容机制
##### HashMap源码解析
* 1、执行构造器 new HashMap();  初始化加载因子loadfactor=0.75
* HashMap$Node[] table=null;
* 2、执行put调用hash方法，计算key的hash值
* 3、执行putVal
```
//如果底层table=null或length=0就扩容到16
if((tab=table)==null)
//取出hash值对应的table的索引位置的Node，如果为null，就直接把加入的k-v创建成一个Node，加入该位置即可    
if((p=tab[i=(n-1)&hash])==null)
//如果table的索引位置的key的hash和新的key的hash值相同&&（table现有结点的key和准备添加的key是同一个对象||equals返回真）就不能添加新的key-value

if((p.hash=hash&&((k=p.key)==key||(key!=null&&key.equals(k)))))
```
### HashTable
#### 基本介绍
* 存放的元素是键值对
* hashtable的键值对都不能是null
* hashtable使用方法基本和hashMap一样
* hashtable是线程安全的，hashMap是线程不安全的
* 见HashTable的应用案例

## properties
### 基本介绍
* properties类继承自Hashtable类实现了Map接口，也是一种键值对的形式来保存数据
* 它的使用特点和Hashtable类似
* properties还可以用于从xxx.properties文件中，加载数据到properties类对象并惊醒读取和修改
### 方法
* put()添加数据或修改数据
* remove()删除
* get()查
* getproperty() 
## 集合选型规则
### 如何选择集合实现类
* 1.先判断存储的类型（一组对象[单列]或一组键值对[双列]）
* 2.一组对象：collection接口
* 允许重复：List
* 增删多：LinkedList（底层维护了一个双向链表） 改查多：ArrayList（底层维护Object类型的可变数组）
* 不允许重复：Set
* 无需：HashSet（底层是HashMap，维护了一个hash表） 排序：TreeSet 插入和取出顺序一致：LinkedHashSet，维护数组+双向链表
* 3.一组键值对：Map
* 键无序：HashMap（底层是哈希表，jdk7：数组+链表 jdk8：数组+链表+红黑树）
* 键排序：TreeMap
* 键插入和取出顺序一致：LinkedHashMap
* 读取文件 Properties
## TreeSet与TreeMap
## Collections工具类
### 方法
* reverse(List)反转List中元素的顺序
* shuffle(List)对List元素进行随机排序
* sort(List)根据元素的自然顺序对指定List集合元素按升序排序
* sort(List,Comparator)根据指定的Comparator产生的顺序对List集合元素进行排序
* swap(List,int,int)将指定的i和j两处元素交换 
* Object max(Collection)根据元素的自然顺序，返回给定集合中最大的元素
* Object max(Collection,Comparator)根据Comparator指定顺序，返回给定集合中最大的元素
* Object min(Collection)
* Object min(Collection,Comparator)
* int frequency(Collection,Object)返回给定集合中指定的元素出现次数
* void copy(List dest,List src)将src的内容复制到dest中去；赋值前，要先给dest赋值，因为源码会先检测dest和src的size大小关系，如果src.size>dest.size 会抛出异常
* boolean replaceAll(List list,Object oldVal,Object newVal)使用新值替换List对象的所有旧值
## 泛型
### 泛型的理解和好处
* 编译时，检查添加元素的类型，提高了安全性
* 减少了类型转换的次数，提高效率
* 不再提示编译警告
### 泛型介绍
* 泛型又称参数化类型，
* 在类声明或实例化时只要指定好需要的具体的类型即可
* java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生classCastException
* 泛型的作用是可以在类声明时通过一个标识表示类中某个属性的类型，或是某个方法返回值的类型，或是参数类型
### 泛型的语法
* interface<T>{} class A<K,V>{}
* 其中TKV都是代表类型，任意字母都可以
### 泛型细节
* 1、interface List<T>{},public class HashSet<E>{}
* TE只能是引用类型
* 2、在指定泛型具体类型后，可以传入该类型或者其子类类型
* 3、泛型使用形式
```
List<Integer> list1=new ArrayList<Integer>();
List<Integer> list2=new ArrayList<>();
List list3 = new ArrayList();默认给它的泛型是<E> E是Object
```
### 自定义泛型
#### 自定义泛型类
##### 基本语法
* class 类名 <T,R>{}
##### 注意细节
* 普通成员可以使用泛型（属性、方法）
* 使用泛型的数组，不能初始化
* 静态方法中不能使用类的泛型
* 泛型类的类型，是在创建对象时确定的（因为创建对象时，需要指定确定类型）
* 如果在创建对象时，没有指定类型，默认Object

#### 自定义泛型接口
##### 基本语法
* interface 接口名<T,R>{}
##### 注意细节
* 接口中，静态成员也不能使用泛型（这个和泛型类规定一样）
* 泛型接口的类型，在继承接口或者实现接口时确定
* 没有指定类型，默认为Object
#### 自定义泛型方法
##### 基本语法
* 修饰符 <T,R> 返回类型 方法名（参数列表）{}
##### 注意细节
* 泛型方法，可以定义在普通类中，也可以定义在泛型类中
* 当泛型方法被调用时，类型会确定
* public void eat(E e){},修饰符后没有<L,R> eat方法不是泛型方法，而是使用泛型
### 泛型的继承和通配符
* 泛型不具备继承性
* <?> 支持任意泛型类型
* <?extends A>支持A类和A的子类
* <? super A>支持A类和A的父类，不限于直接父类，规定了泛型的下限
## 多线程详解
### 线程
* 进程时运行中的程序
* 进程时程序的一次执行过程或是正在运行的程序是一个动态过程
* 线程由进程创建，是进程的一个实体
* 一个进程可以拥有多个线程
* 单线程：同一个时刻，只允许执行一个线程
* 多线程：同一个时刻，可以执行多个线程
* 并发：同一个时刻，多个任务交替执行，单核CPU实现的多任务就是并发
* 并行：同一时刻，多个任务同时执行，多核CPU可以实现并行
#### 线程的基本使用
* java是单继承的，在某些情况下一个类可能已经继承了父类，这时再用继承Thread类方法来创建线程显然不可能了
* java设计者提供了另一个方式创建线程，就是通过实现Runnable接口来创建线程（底层使用了代理模式）
##### 继承Thread和实现Runnable的区别
* 从java设计上来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别
* 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制
### 线程终止
* 当线程完成任务后，会自动退出
* 还可以通过使用遍量来控制run方法退出的方式停止线程，即通知方式

### 线程常用方法
* setName 设置线程名称使之与参数name相同
* getName 返回该线程名称
* start 使该线程开始执行
* run 调用线程对象run方法
* setPriority 更改线程优先级
* getPriority 获取线程优先级
* sleep 使线程休眠
* interrupt 中断线程
#### 注意事项
* start底层会创建新的线程，调用run，run就是一个简单的方法调用，不会启动新的线程
* 线程优先级的范围
* interrupt，中断线程，但并没有真正的结束线程，所以一般用于中断正在休眠线程
* sleep 线程的静态方法，使当前线程休眠
* yield：线程的礼让，让出cpu，让其他线程执行，但是礼让的时间不确定，所以也不一定礼让成功
* join：线程的插队，插队的线程一旦插队成功，则肯定先执行完插如的线程所有的任务
##### 用户线程和守护线程
* 用户线程：也叫工作线程，当线程的任务执行完或通知方式结束
* 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
* 常见的守护线程：垃圾回收机制
### Synchronized
* 在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何时刻，最多由一个线程访问，以保证数据的完整性
* 线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作
#### 同步具体方法
* 同步代码块
```
synchronized(对象){//得到对象的锁，才能操作同步代码
//需要被同步代码
}
```
* synchronized话可以放在方法声明中，表示整个方法为同步方法
public synchronized void m(String name){
    //需要被同步的代码
}
##### 理解
* 就好像上洗手间先把门关上（上锁），结束后出来（解锁），其他人就可以使用厕所了
#### 互斥锁
##### 基本介绍
* java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性
* 每个对象都对应于一个可称为"互斥锁"的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象
* 关键字synchronized来与对象的互斥锁联系，当某个对象用synchronized修饰时，表面该对象在任一时刻只能由一个线程访问
* 同步的局限性：导致程序的执行效率要降低
* 同步方法（非静态）的锁可以是this，也可以是其他对象（要求是同一个对象）
* 同步方法（静态的）的锁为当前类本身
* public synchronzied void sell(){} 就是一个同步方法
* 这是锁在this对象
* 也可以在代码块上锁
##### 注意事项
* 同步方法如果没有使用static修饰，默认锁对象是this
* 如果方法使用static修饰，默认锁对象是当前类.class
* 实现的落地步骤：
* 需要先分析上锁的代码
* 选择同步代码块或同步方法
* 要求多个线程的锁对象为同一个即可
### 线程的死锁
#### 基本介绍
* 多个线程都占用了对方的锁资源，但不肯相让，导致了死锁，在编程时要规避死锁的发生

### 释放锁
#### 释放锁操作
* 当前线程的同步方法，同步代码块执行结束
* 当前线程在同步代码块，同步方法中遇到break，return
* 当前线程在同步代码块，同步方法中出现了未处理的Error或Exception，导致异常结束
* 当前线程在同步代码块，同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁
#### 不会释放锁操作
* 线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行，不会释放锁
* 线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁；不推荐
## 文件基本操作
### 文件
* 文件就是保存数据的地方
### 文件流
* 文件在程序中是以流的形式来操作的
* 流：数据子啊数据源（文件）和程序（内存）之间经历的路径
* 输入流：数据从数据源（文件）到程序（文件）的路径
* 输出流：数据从程序（内存）到数据源（文件）的路径
### 常见的文件操作
* 创建文件对象相关构造器和方法
* new File(String pathname)//根据路径构建一个File对象
* new File(File parent,String child)//根据父目录文件+子路径构建
* new File(String parent,String child)//根据父目录+子路径构建
* createNewFile 创建新文件
#### 获取文件相关信息
* getName
* getAbsolutePath 获得绝对路径
* getParent 获取父级目录
* length 获取长度
* exists 是否存在
* isFile 是否是文件
* isDirectory 是否是目录
* mkdir 创建一级目录
* mkdirs创建多级目录
* delete 删除空目录或文件
* java编程中，目录也被当作文件
## IO流
### 流的分类
* 按操作数据单位分为字节流（二进制文件）字符流（文本文件）
* 按数据流的流向分为输入流、输出流
* 按流的角色分为节点流、处理流/包装流
|抽象基类|字节流|字符流|aa|
|----|----|----|----|
|输入流|InputStream|Reader||
|输出流|OutputStream|Writter||
* java的IO流都是从上述4个抽象基类中派生的
* 由这四个类派生出的子类名称都是以其父类名作为子类名后缀
#### InputStream常用子类
* FileInputStream 文件输入流
* BufferedInputStream 缓冲字节输入流
* ObjectInputStream 对象字节输入流
#### OutputStream常用子类
* new FileOutputStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
* new FileOutputStream(filePath,true) 当写入内容时，是追加到文件的后面
#### FileReader和FileWriter
* new FileReader(File/String)
* read:每次读取单个字符，返回该字符，如果到文件末尾返回-1
* read(char[])批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾就返回-1
* new String(char[]) 将char[]转换成String
* new String(char[],off,len) 将char[]的指定部分转换成String
  
* new FileWriter(File/String)覆盖模式相当于流的指针在首端
* new FileWriter(File/String,true)追加模式，相当于流的指针在尾端
* Writer(int):写入单个字符
* Writer(char[])写入指定数组
* Writer(char[],off,len)写入指定数组的指定部分
* Writer(String)写入整个字符串
* Writer(String,off,len)写入字符串的指定部分
* String类：toCharArray 将String转换成char[]
* FileWriter使用后,必须要close或flush，否则写入不到指定的文件
### 节点流和处理流
* 节点流可以从一个特定的数据源读写数据 egFileReader
* 处理流（包装流）是"连接"在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能 egBufferedReader
* BufferedReader类中，有属性Reader，即可以封装一个节点流，只要是Reader子类
#### 区别
* 节点流是底层流/低级流，直接跟数据源相接
* 处理流包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出
* 处理流对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连
#### 处理流的功能
* 性能提高：主要以增加缓冲的方式来提高输入输出的效率
* 处理流可能提供一系列便捷的方法来一次输入输出大批量的数据，使用更方便

* BufferedReader和BufferedWriter属于字符流，是按照字符来读取数据的，关闭时，只需要关闭外层流即可
* BufferedReader和BufferedWriter不能操作二进制文件
#### BufferedInputStream
* BufferInputStream是字节流，在创建BufferedInputStream时，会创建一个内部缓冲区数组
* BufferedOutputStream是字节流，实现缓冲的输出流，可以将多个字节写入底层输出流中，而不必对每次字节写入调用底层系统
#### ObjectInputStream/ObjectOutputStream（都是处理流）
* 保存值和数据类型称为序列化
* 想要序列化，需要类实现serializable(标记接口，没有方法)或Externalizable(有方法需要实现，不推荐) 
##### 注意事项
* 读写顺序要一致
* 要求实现序列化或反序列化对象需要实现Serializable
* 序列化的类中建议添加SerialVersionUID，为了提高版本的兼容性
* 序列化对象时，默认将里面所有属性都及逆行序列化，但除了static或transient修饰的成员
* 序列化对象时，要求里面属性的类型也需要实现序列化接口
* 序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化
### 转换流InputStreamReader
* InputStreamReader:Reader的子类，可以把InputStream（字节流）包装成Reader(字符流)
* 当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转成字符流
* 可以在使用时指定编码格式
### properties类
#### 常用方法
* load 加载配置文件的键值对到Properties对象
* list 将数据显示到指定设备
* getProperty(key) 根据键获取值
* setProperty(key,value) 设置键值对到Properties对象
* store 将properties中的键值对存储到配置文件中，idea中，保存信息到配置文件，如果含有中文，会存储为unicode码

## 网络编程入门
### IP地址
* ipv4 4个字节32位
* ipv6 128位
* A 0 网络号（7）主机号（24）
* B 10 网络号（14）主机号（16）
* C 110 网络号（21）主机号（8）
* D 1110 多播组号（28）

### 域名和端口
* 端口：用于标识计算机上某个特定的网络程序

### 协议
* 协议：数据的组织形式
### TCP UDP 
* TCP协议：传输控制协议
* 使用TCP协议前，须建立TCP连接，形成传输数据通道
* 传输前采用三次握手方式，是可靠的
* TCP协议进行通信的两个应用进程：客户端、服务端
* 在连接中可进行大数据量的传输
* 传输完毕，需释放已建立的连接，效率低
* UDP
* 将数据、源、目的封装成数据包，不需要建立连接
* 每个数据报的大小限制在64k内
* 因无需连接，故是不可靠的
* 发送数据结束时无需释放资源（因为不是面向连接的），速度快 

### socket
* 套接字
* 客户端和服务端通常情况下，是在不同主机的
### netstat指令
* netstat -an可以查看当前主机网络情况
* netstat -an|more 可以分页显示
* 要求在dos控制台下执行
* 如果有一个外部程序连接到该端口，就会显示一条连接信息
### TCP网络编程
* 当客户端连接到服务端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是TCP/IP来分配的
### UDP
* 类DatagramSocket和DatagramPacket[数据包/数据报]实现基于UDP协议网络程序
* UDP数据报通过数据报套接字DatagramPacket发送和接受，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达
* DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接受端的IP地址和端口号
* UDP协议中每个数据报都给出了完整的地址信息，因此无需建立发送方和接收方的连接
#### 说明
* 没有明确的服务端和客户端，演变成数据的发送端和接收端
* 接受数据和发送数据是通过DatagramSocket对象完成
* 将数据封装到DatagramPacket对象/装包
* 当接收到DatagramPacket对象，需要进行拆包，取出数据
* DatagramSocket可以指定在哪个端口接收数据
#### 基本流程
* 建立发送端，接收端
* 发送数据前，建立数据报 DatagramPacket对象
* 调用DatagramSocket的发送、接收方法
* 关闭DatagramSocket
## 网络编程实战
多用户通信系统--通信系统梳理
## 反射
### 反射机制
* 反射机制允许程序在执行期借助于ReflectionAPI取得任何类的内部信息，并能操作对象的属性及方法
* 加载完类后，在堆中产生了一个class类型的对象（一个类只有一个Class对象），这个对象包含了类的完整结构信息，通过这个对象得到类的结构，称之为反射
#### 可以完成
* 1.在运行时判断任意一个对象所属的类
* 2.在运行时构造任意一个类的对象
* 3.在运行时得到任意一个类所具有的成员变量和方法
* 4.在运行时调用任意一个对象的成员变量和方法
* 5.生成动态代理

### 反射优缺点
* 优点：可以动态的创建和使用对象，使用灵活
* 缺点：使用反射是解释执行，对执行速度有影响
* 反射优化
* setAccessible作用是启动和禁用访问安全检查
* 参数值为true表示反射的对象在使用时取消访问检查，参数值为false表示反射的对象执行访问检查
### java程序在计算机的三个阶段
* 代码阶段 java字节码通过类加载器（classLoader）加载成Class类对象
* class类阶段/加载阶段 class对象表示某个类加载后在堆中的对象
* Runtime运行阶段

### class类
* Class也是类，也继承Object
* CLass类对象不是new出来的，是系统创建的
* 对于某个类的Class对象，在内存中只有一份，因此类只加载一次
* 每个类的实例都会记得自己是由那个Class实例所生成
* 通过Class可以完整地得到一个类的完整结构，通过一系列API
* Class对象是存放在堆的
* 类的字节码二进制数据，是放在方法区的

#### 获取Class类对象
* Class.forName()  编译阶段
* 类.class 加载阶段
* 对象.getClass() 运行阶段
### 类加载
* Dog dog=new Dog() 是静态加载
* 反射是动态加载 只有动态加载该类时，才会报错
* 静态加载：编译时加载相关的类，如果没有则报错
* 动态加载：运行时加载需要的类，如果运行时不用该类，则不报错
#### 类加载的时机
* 被new时//静态加载
* 当子类被加载时，父类也加载//静态加载
* 调用类中的静态成员时//静态加载
* 通过反射//动态加载
  
#### 加载过程
* 源码--编译-->字节码文件（com.Cat.class）--java运行-->加载Loading-->连接（验证、准备、解析）-->初始化（加载和连接由jvm控制）
* 类加载后内存布局
* 方法区（类的字节码二进制数据）       堆区（类的Class对象）  二进制数据和Class对象存在引用
* 加载（将类的class文件读入内存，并创建一个java.lang.Class对象,此过程由类加载器完成）
* 连接（将类的二进制数据合并到JRE中）
* 初始化（JVm负责对类进行初始化 ，这里主要指静态成员）

##### 加载阶段
* jvm在该阶段的主要目的是将字节码从不同的数据源（可能是class文件也可能是jar包）转化为二进制字节流加载到内存中，并生成一个代表该类的java.lang.Class对象
##### 连接阶段
* 1.目的是为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全
* 2.包括：文件格式验证（是否以0xcafebabe开头）元数据验证，字节码验证和符号引用验证
* 可以考虑使用-Xverify:none参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间
```
class A{
    public int n1=10;//是实例属性，在准备阶段不会分配内存
    public static int n1=10;//是静态变量，分配内存，默认初始化是0
    public static final int n1=10;//是常量，一旦赋值就不会改变
}
```
###### 连接阶段-准备
* jvm会在该阶段对静态变量，分配内存并默认初始化（对应数据类型的默认初始值，0、0L、null、false），这些变量所使用的内存都将在方法区中进行分配

###### 连接阶段-解析
* 虚拟机将常量池内的符号引用替换为直接引用的过程

##### 初始化
* 1.到初始化阶段，才开始执行类中定义的java程序代码，此阶段是执行<clinit>()方法的过程
* 2.<clinit>()方法由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，并进行合并
* 3.虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要被阻塞等待，直到活动线程执行<clinit>()完毕（正因为有这个机制，才能保证某个类在内存中，只有一份Class对象）
* 如果直接使用类的静态属性，也会导致类的加载

##### 获取类的结构
* getModifiers:以int形式返回修饰符[默认修饰符是0，public是1，private是2，protected是4，static是8 final是16]，public+static=9
* getType 以Class形式返回类型
* getName 返回属性名
* getReturnType:以Class形式获取返回类型
* getParameterTypes 以Class[]返回参数类型数组

#### 通过反射创建对象
* 方式一：调用类中的public修饰的无参构造器
* 方式二：调用类中的指定构造器
* Class类相关方法
* newInstance 调用类中的无参构造器，获取对应类的对象
* getConstructor(Class clazz)根据参数列表 获取对应的public构造器对象
* getDecalaredConstructor(Class clazz) 根据参数列表获取对应的所有构造器对象

* Constructor类相关方法
* setAccessible 暴破
* newInstance(Object obj) 调用构造器
##### 通过反射访问类中的成员
* 根据方法名和参数列表获取方法对象
* Method m=class.getDeclaredMethod(方法名,XX.class);
* 获取对象： Object o=class.newInstance();
* 暴破 m.setAccessible(true);
* 访问 Object returnValue=m.invoke(o,实参列表)
* 如果是静态方法，则invoke的参数o可以写成null