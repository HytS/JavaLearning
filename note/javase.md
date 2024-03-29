## java并发
### 并发和并行的区别
并行：多个线程任务在不同cpu上同时进行；并发：多个线程任务在同一个cpu上轮换执行，因为切换的速度快，给人的感觉是同时进行的
并行是指两个或多个事件在同一时刻发生；并发是指两个或多个事件在同一时间间隔发生；
并行是在不同实体上的多个事件；并发是同一实体上的不同事件
并发编程的目标是充分利用处理器的每一个核，以达到最高的处理性能

### 线程和进程的区别
进程：是程序调度和资源分配的基本单位。进程在执行过程中拥有独立的内存单元，而多个线程共享内存资源，减少切换次数，从而效率更高
线程：是进程的一个实体，是cpu调度和分配的基本单位，是比程序更小的能独立运行的基本单位，同一进程中多个线程之间可以并发执行

### 守护线程是什么
守护线程：运行在后台，为其他前台线程服务。一旦所有用户线程都结束运行，守护线程会和jvm一起结束工作

### 创建线程的方式
继承Thread类、实现Runnable接口、通过Callable和Future、通过线程池创建线程
通过Callable来实现的方法是因为Future task实现了Runnable接口，Future task可以接收一个Callable参数，然后把这个Future task传入到Thread中，Future task调用run()时，run会调用Callable的call()然后把call()的返回值赋给outcome属性


### Runnable和Callable区别
Runnable接口中的run()的返回值时void，功能时执行run()
Callable接口中的call()有返回值，是一个泛型，和Future、Future task配合可以获取异步执行的结果

### 线程状态与转换
Thread中定义了6种状态：new、runnable、blocked、waiting、time waiting定时等待、terminated终止
new 初始状态，线程被构建，还没有调用start();runnable 运行状态，java线程将os种就绪和运行两种状态笼统的称为'运行中'；blocked 表示线程阻塞与锁 ；time waiting 可以在指定的时间自动返回；waiting 表示线程进入等待状态，进入该状态表示当前线程需要等待其他线程做出一些特定动作

### sleep和wait的区别
sleep()正在执行的线程主动让出cpu（然后cpu去执行其他任务），在sleep指定时间后cpu再回到该线程继续往下执行（注意：sleep只让出了cpu，并不会释放同步资源锁）；wait()指当前线程让自己暂时让出资源锁，让其他正在等待该资源的线程得到该资源进而运行，只有调用了notify()，之前调用wait()的线程才会解除wait抓鬼太，可以参与竞争同步资源锁，进而得到执行（注意：notify的作用相当于叫醒睡着的人，并不会给他分配任务，即notify只是让之前调用wait的线程有权力重新参与线程的调度）
sleep可以在任何地方使用，而wait只能在同步方法或同步块中使用
wait如果不加具体时间需要手动唤醒
sleep是线程类Thread的静态方法，调用回暂停此线程指定的时间，但监控依然保持，不会释放对象锁，到时间自动恢复；wait是Object方法，调用会放弃对象锁，进入等待队列，待调用notify/notifyAll唤醒指定线程或全部线程，才会进入锁池，再次获得对象锁才会进入运行状态

### start和run区别
每个线程都是通过某个特定Thread对象所对应的run方法来完成操作，run()称为线程体，通过调用Thread类的start()来启动一个线程
start()来启动一个线程，真正实现了多线程运行，这时无需等待run()代码执行完毕，可以直接执行下面代码，这时线程处于就绪状态，并没有运行，然后通过此Thread类调用run()来完成其运行状态，run()称为线程体，线程体包含了要执行的这个线程的内容，run()运行结束，此线程终止，然后cpu再调度其他线程
run()是在本线程中的，只是线程里的一个函数，而不是多线程的。如果直接调用run()，就像与调用一个普通函数，直接调用run()必须等待run()执行完毕才能执行下面的代码，所以执行路径还是只有一条，根本没有线程的特征，所以在多线程执行时要使用start()而不是run()

new一个Thread对象，线程进入了新建状态，调用start()，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。start()会执行线程的相应准备工作，然后自动执行run()的内容，这就是真正的多线程工作
直接执行run()，会把run当成main线程下的普通方法去执行，并不会在某个线程中执行它，所以不算多线程工作

当程序调用start()，将会创建一个新线程去执行run()的代码，但是如果直接调用run()，会直接在当前线程中执行run()的代码，注意：这里不会创建新线程，这样run()就像一个普通方法一样
当一个线程启动后，不能重复调用start()，否则会报异常，但是可以重复调用run()，即run()就是一个普通方法，start()会创建一个新线程去执行run()代码

### 在java程序中怎么保证多线程的运行安全
原子性：提供互斥访问，同一时刻只能有一个线程对数据进行操作（atomic，synchronized）
可见性：一个线程对主内存的修改可以及时的被其他线程看到（synchronized，volatile）
有序性：一个线程观察其他线程中指令执行顺序，由于指令重排序，该观察结果一般杂乱无序（happens-before原则）
happens-before原则：程序次序规则：在一个线程内，按照程序控制流顺序，书写在前面的操作先行发生于书写在后面的操作

### java线程同步的集中方法
使用synchronized（synchronized实现的同步代码块或同步方法）；wait和notify；使用特殊域变量volatile实现线程同步；使用可重入锁实现线程同步（ReentrantLock实现了Lock接口的可重入锁）；使用阻塞队列实现线程同步；使用信号量semaphore

ThreadLocal人手一份线程私有变量，保证了线程安全
原子变量内部的CAS自旋操作实现了多线程下的同步


### Thread.interrupt()的工作原理
在java中，线程的中断interrupt只是改变了线程的中断状态，至于这个中断状态改变后带来的结果，是无法确定的，有时更是让停止中的线程继续执行的唯一手段，不但不是让线程停止运行，反而是继续执行线程的手段

在一个线程对象上调用interrupt，真正有影响的是wait、join、sleep，这三个方法包括他们的重载方法；注意：上面这三个方法会抛出异常

对于wait中的等待notify、notifyAll唤醒的线程，其实这个线程已经'暂停'执行，因为它正在某一对象的休息室中，这时如果它的中断状态被改变，那么他就会抛出异常，这个interruptException不是线程抛出的，是wait抛出的，也就是对象的wait方法内部会不断检查在此对象上休息的线程的状态，如果发现哪个线程的状态被置为已中断，则会抛出interruptException，意思是这个线程不能再等待了，其意义就等同于唤醒它了，然后执行catch中的代码

对于sleep中的线程，如果调用了Thread.sleep(一年)，现在后悔了，想让它早点醒过来，调用interrupt()是唯一的手段，只有改变它的中断状态，让它从sleep中将控制权转到处理异常的catch语句中，然后再由catch中的处理转到正常的逻辑，同样，对于join中的线程也可以这样处理、


### ThreadLocal的理解
javaweb项目大部分都是基于Tomcat，每次访问都是一个新的线程，每一个线程都独享一个ThreadLocal，我们可以在接收请求的时候set特定内容，在需要的时候get这个值
ThreadLocal提供set和get方法，为每一个使用这个变量的线程都保存一份独立的副本
get()用来获取ThreadLocal在当前线程中保存的变量副本 set()用来设置当前线程中变量的副本
remove()用来移除当前线程中变量的副本 initialValue()是一个protected方法，一般用来在使用时进行重写的，如果在没有set的时候调用get，会调用initialValue方法初始化内容

ThreadLocal，线程本地变量，只属于当前线程，其他线程无法获取这个变量，是隔离的；每个线程Thread对象具有一个自己的ThreadLocalMap对象，把线程信息放入到ThreadLocalMap对象中，同一个线程Thread在任何地方都可以拿出来
ThreadLocalMap对象的元素entry的key是ThreadLoca对象，value是需要存储的数据，可以具有多个Threadlocal对象及对应的value数据

### 使用ThreadLocal的场景
在调用api接口的时候传递了一些公共参数，这些公共参数携带了一些设备信息（安卓/ios），服务端接口根据不同的信息组装不同的格式返回给客户端。假定服务器端需要通过设备类型（device）来下发下载地址，当然接口也有同样的其他逻辑，我们只要在返回数据的时候判断好是什么类型的客户端就好，上面着中国场景可以将传进来的参数device设置到ThreadLocal中，用的时候取出来就行。避免参数的层层传递

### 对synchronized的了解
synchronized解决的是多个线程之间访问资源的同步性，synchronized可以保证被它修饰的方法或代码块在任意时刻只能有一个线程执行
在java早期版本，synchronized属于重量级锁，效率低，因为监视器锁是依赖于底层的操作系统的Mutex Lock实现的，java的线程是映射到操作系统的原生线程之上的。如果要挂起或唤醒一个线程，都需要os帮忙完成，而os实现线程之间的切换时需要从用户态切换到内核态，这个状态之间的转换需要相对比较长的时间，这也是早期的synchronized低效的原因


### 如何在项目中使用synchronized
最主要的三种使用方式：1、修饰实例方法：作用于当前对象实例加锁，进入同步代码前要获得当前对象实例的锁；
2、修饰静态方法：作用于当前类对象加锁，进入同步代码前要获得当前类对象的锁。也就是给当前类加锁，会作用于类的所有对象实例，因为静态成员不属于任何一个实例对象，是类成员（static表示不管new了多少个对象，只有一份，所以对该类的所有对象都加了锁）。所以如果一个线程a调用一个实例对象的非静态synchronized方法，而线程b需要调用这个实例对象所属类的静态synchronized方法，是允许的，不会发生互斥现象，因为访问静态synchronized方法占用的锁是当前类的锁，而访问非静态synchronized方法占用的锁是当前实例对象锁；
3、修饰代码块：指定加锁对象，对给定对象，进入同步代码库前要获得给定对象的锁。和synchronized方法一样，synchronized(this)代码块也是锁定当前对象的，synchronized加到static静态方法和synchronized(class)代码块都是给Class类上锁。注意：synchronized加到非static静态方法上是给对象实例上锁，尽量不要使用synchronized(String a)因为jvm中，字符串常量池具有缓冲功能

使用synchronized双重校验所的方法实现单例模式
