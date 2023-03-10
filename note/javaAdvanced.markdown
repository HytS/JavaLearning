# javaAdvanced
## 类变量和类方法
### 类变量
* 最大的特点就是会被Child类的所有对象实例共享
#### 类变量内存布局
* 类加载时，类方法会放在方法区中
* 静态变量被同一个列的所有对象共享；static类变量在类加载的时候就生成了
* jdk8以前放在方法区中，以后的版本放在堆中类对应的class对象中，通过反射机制加载一个class对象（类加载的时候会生成一个class对象）

#### 细节
* 静态变量的访问修饰符的访问权限范围和普通属性一样
* 类名.静态变量
* 什么时候需要用类变量
* 当我们需要让某个类的所有对象都共享一个变量
* 类变量时该类的所有对象共享的，而实例变量（属性）是每个对象共享的
* 加上static称为类变量或者静态变量
* 实例变量不能通过类名.类变量名访问
* 类变量是在类加载时就初始化了，即使你没有创建对象，只要类加载了，就可以使用类变量了
* 类变量的生命周期随类的加载开始，随着类消亡而销毁

### 类方法
* 访问修饰符 static 数据返回类型 方法名(){}
* 开发自己的工具类时，可以将方法做成静态的，方便调用

#### 注意事项
* 类方法和普通方法都是随着类的加载而加载，将结构信息储存在方法区
* 类方法中无this的参数、普通方法中隐含着this的参数
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
* ；号可以写，也可以忽略
* 相当于另一种形式的构造器，构造器的补充
* 当构造器中有相同的语句，可以把相同的语句放入到一个代码块中
* 不管调用那个构造器，都会先去调用代码块中的内容
* 代码块调用顺序优先于构造器
### 细节
* 静态代码块随着类的加载而执行，并且只会执行一次，普通代码块，每创建一个对象，就执行
* 类什么时候被加载
>> 创建对象实例时 new
>> 创建子类对象实例，父类也会被加载
>> 使用类的静态成员时
* 普通代码块在创建对象实例时，会被隐式的调用，被创建一次就被调用一次
* 如果只是使用类的静态成员时，普通代码块不会被执行

* 创建一个对象时，在一个类调用顺序是：
* Ⅰ、调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用）
* Ⅱ、调用普通代码块和普通属性的初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和多个普通属性初始化，则按定义顺序调用）
* Ⅲ、调用构造器

* 构造方法（构造器）的最前面隐含了super和调用普通代码块，静态相关的代码块、属性初始化在类加载时，就执行完毕了，因此是优先于构造器和普通代码块执行的
* 创建一个子类时（继承关系），他们的静态代码块，静态属性初始化，    普通代码块，普通属性初始化，构造方法调用如下：
* Ⅰ、父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
* Ⅱ、子类的静态代码块和静态属性（优先级一样，按定义顺序执行）
* Ⅲ、父类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
* Ⅳ、父类的构造方法
* Ⅴ、子类的普通代码块和普通属性初始化优先级一样，按定义顺序执行）
* Ⅵ、子类的构造方法

* 静态代码块只能直接调用静态成员（静态属性和静态方法），普通代码块可以调用任意成员


## 单例模式和final
* 采取一定的方法保证在整个软件运行过程中，对某一个类只能存在一个对象实例
### 单例模式饿汉式
#### 步骤
* 构造器私有化防止直接new
* 类的内部创建对象static
* 向外暴露一个静态的公共方法 getInstance
  
### 单例模式懒汉式
### final
#### 基本使用
#### 细节

## 抽象类
## 接口详解
## 四种内部类详解
## 枚举Enum
## 注解
## 异常
## try|catch|throws
## 八大常用类
## Integer类：拆箱与装箱
## String详解
## StringBuffer与StringBuilder
## 集合入门
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
