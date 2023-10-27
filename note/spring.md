## Mybatis 3
### java Api
sqlSession
ʹ��mybatis����Ҫjava�ӿ�


## spring

### ������ʲô�� AOP
AOP��Aspect-Oriented Programming���������̣�������˵�� OOP��Object-Oriented Programing����������̣��Ĳ�������ơ�OOP �����װ���̳кͶ�̬�Եȸ���������һ�ֶ����νṹ������ģ�⹫����Ϊ��һ�����ϡ���������ҪΪ��ɢ�Ķ������빫����Ϊ��ʱ��OOP ���Ե�����Ϊ����Ҳ����˵��OOP �����㶨����ϵ��µĹ�ϵ���������ʺ϶�������ҵĹ�ϵ��������־���ܡ���־��������ˮƽ��ɢ�������ж������У���������ɢ�����Ķ���ĺ��Ĺ��ܺ��޹�ϵ�������������͵Ĵ��룬�磺��ȫ�ԡ��쳣�����͸���ĳ�����Ҳ����ˡ�����ɢ���ڸ������޹صĴ��뱻��Ϊ���У�cross-cutting�����룬�� OOP ����У��������˴���������ظ����������ڸ���ģ������á�

AOP����һ�֡����С��������ʽ⿪��װ�Ķ����ڲ���������ЩӰ���˶����Ĺ�����Ϊ��װ��һ��������ģ�飬��������Ϊ��Aspect�����򵥵�˵�����ǽ���Щ��ҵ���޹أ�ȴΪҵ��ģ������ͬ���õ��߼������η�װ���������ڼ���ϵͳ���ظ����룬����ģ������϶ȣ���������δ���Ŀɲ����ԺͿ�ά���ԡ�AOP �������һ������Ĺ�ϵ�����˵��������һ�����ĵ�Բ���壬���з�װ���Ƕ�������Ժ���Ϊ����ô�������̵ķ������ͷ·�һ�����У�����Щ����Բ�����ʿ����Ի�����ڲ�����Ϣ�����ʿ������棬Ҳ������ν�ġ����桱�ˡ�Ȼ���������ɶ��칦�����ֽ���Щ�ʿ������渴ԭ�������ۼ���

ʹ�ú��м�����AOP�����ϵͳ��Ϊ���Ĺ�ע��ͺ��й�ע�㡣ҵ�������Ҫ�����Ǻ��Ĺ�ע�㣬��֮��ϵ����Ĳ����Ǻ��й�ע�㡣���й�ע���һ���ص��ǣ����Ǿ��������ں��Ĺ�ע��Ķദ�����������������ơ����磺Ȩ����֤����־��������AOP ���������ڷ���ϵͳ�еĸ��ֹ�ע�㣬�����Ĺ�ע��ͺ��й�ע����뿪����
### ioc�����
ioc��inversion of control����д��һ�㷭��ɿ��Ʒ�ת������˵���ǰѸ���ϵͳ�ֽ���໥�����Ķ�����Щ������ͨ����װ���ڲ�ʵ�ֶ��ⲿ��͸���ģ��Ӷ������˽������ĸ��Ӷȡ�ioc��������Ĺ۵㣺�����ڡ���������ʵ�־���������ϵ�Ķ���֮��Ľ��ioc�������ǵ��������������������м�λ�õĵ�������ʹ��abcd��4������û������Ϲ�ϵ��ȫ������Ŀ�����ȫ���Ͻɸ�ioc����������ioc������������ϵͳ�Ĺؼ����ģ������ж���ճ����һ�������ã����û��ioc����������Ͷ���֮���˴�ʧȥ��ϵ

Ϊʲôioc�ǿ��Ʒ�ת
�����û������ioc����ǰ������a�����ڶ���b������a�ڳ�ʼ�������е�ĳһ���ʱ���Լ�����������ȥ������ʹ���Ѵ����Ķ���b������ʹ�û��Ǵ��������������Լ�����
�������ioc�����󣬶���a�Ͷ���bʧȥ��ֱ����ϵ�����Ե�����a���е���Ҫʹ�ö���bʱ��ioc��������������һ������bע�뵽a��Ҫ�ĵط������Կ������������������������ߵ���


## spring����
### ʲô��spring���
spring��һ�Դ��������java������ܣ�һ��˵��spring���ָ����spring framework�����Ǻܶ�ģ��ļ��ϣ�ʹ����Щģ����԰�������������spring֧��ioc�����Ʒ�ת����aop��������Ƭ��̣������ԺܺõĶ����ݿ���з���
### spring������ģ������Щ
#### Core container
spring��ܵĺ���ģ�飬��Ҫ�ṩioc����ע�빦��֧�֡�spring�������ܶ�������ģ�飬
* spring-core:spring��ܻ����ĺ��Ĺ�����
* spring-beans���ṩ��bean�Ĵ��������ú͹���ȹ��ܵ�֧��
* spring-context���ṩ�Թ��ʻ����¼���������Դ���صȹ��ܵ�֧��
* spring-expression���ṩ�Ա��ʽ���Ե�֧�֣�ֻ����coreģ�飬����������ģ�飬���Ե���ʹ��

#### AOP
* spring-aspects����ģ��Ϊ��AspcetJ�ļ����ṩ֧��
* spring-aop���ṩ����������ı��ʵ��
* spring-instrument���ṩ��Ϊjvm��Ӵ���Ĺ��ܣ���Ϊtomcat�ṩ��һ��֯������ܹ�Ϊtomcat�������ļ���������Щ�ļ��������������һ��
#### data Access
* spring-jdbc���ṩ�˶����ݿ���ʵĳ���jdbc����ͬ�����ݿⶼ���Լ�������api���ڲ������ݿ⣬��java����ֻ��Ҫ��jdbc api���������������������ݿ��Ӱ��
* spring-tx���ṩ�������֧��
* spring-orm���ṩ��Hibernate��JPA��iBatis��orm��ܵ�֧��
* spring-oxm���ṩһ�������oxm��Object-to-xml-Mapping��
* spring-jms:��Ϣ����

#### spring web
* spring-web����web����ʵ���ṩһЩ�������֧��
* spring-webmvc���ṩ��spring mvc��ʵ��
* spring-websocket���ṩ�˶�webSocket��֧�֣�webSocket�����ÿͻ��˺ͷ���˽���˫��ͨ��
* spring-webflux���ṩ��webflux��֧�֡�webflux��spring framework 5.0������µ���Ӧʽ��ܣ���spring mvc��ͬ��������Ҫservlet api������ȫ�첽���첽��ָ�������������ϵĶ�����¼���ͬʱ���ڻ����������������ķ�������ȴ���ǰһ�������ɣ�
#### messaging
* spring-messaging����Ҫ����spring��ܼ��ɵĻ����ı��Ĵ���Ӧ��
#### spring test
spring�Ŷ��ᳫ��������������tdd��������ioc�İ�������Ԫ���Ժͼ��ɲ��Ա�ø��򵥣�spring�Ĳ���ģ���JUnit����Ԫ���Կ�ܣ���TestNG�ȳ��ò��Կ��֧�ֵĶ��ȽϺ�


### spring��spring mvc��spring boot֮����ʲô��ϵ
spring�����˶������ģ�飬spring-core������Ҫ��ģ�飬spring�е�����ģ�飨spring mvc���Ĺ���ʵ�ֻ�������Ҫ������ģ��

spring mvc��spring�е�һ����Ҫģ�飬��Ҫ����spring ���ٹ���mvc�ܹ���web����������mvc��ģ�͡���ͼ���������ļ�д������˼���ǽ�ҵ���߼������ݡ���ʾ��������֯����

ʹ��spring���п����������ù����鷳���翪��ĳЩspring����ʱ����Ҫxml��java������ʽ���á�����spring-boot������
springּ�ڼ�j2ee��ҵӦ�ó��򿪷���spring-bootּ�ڼ�spring���������������ļ���
spring bootֻ�Ǽ������ã������Ҫ����mvc�ܹ���web���򣬻�����Ҫspring mvc��ܣ�ֻ��˵spring boot����spring mvc�ĺܶ�����

## spring ioc
### ��spring ioc�����
ioc�����Ʒ�ת����һ�����˼�룬������һ�־���ļ���ʵ�֡�ioc��˼����ǽ�ԭ���ڳ������ֶ���������Ŀ���Ȩ������spring���������
#### Ϊʲô�п��Ʒ�ת
* ���ƣ�ָ���Ƕ��󴴽���ʵ������������Ȩ��
* ��ת�������������ⲿ������spring��ܡ�ioc������

������֮��Ļ���������ϵ����ioc������������ioc������ɶ����ע�롣�������Ժܴ�̶��ϼ�Ӧ�õĿ�������Ӧ�ôӸ��ӵ�������ϵ�н�ų�����ioc��������һ������һ������������Ҫ����һ�������ʱ��ֻ��Ҫ���ú������ļ�/ע�⼴�ɣ���ȫ���ÿ��Ƕ�������δ���������

��ʵ����Ŀ��һ��Service����������˺ܶ��������࣬��������Ҫʵ�������Service������ÿ�ζ�Ҫ�������Service���еײ���Ĺ��캯��������鷳���������ioc�Ļ���ֻ��Ҫ���úã�Ȼ������Ҫ�ĵط����þ����ˡ�

spring�У�ioc������spring����ʵ��ioc�����壬ioc����ʵ������Map��key��value����Map�д�ŵ��Ǹ��ֶ���
springʱ��һ��ͨ��xml�ļ�����bean������������Ա��Ϊxml�ļ����ò�̫�ã����Ǹ���springbootע������


### ʲô��spring bean
bean��ָ��Щ��ioc����������Ķ���������Ҫ����ioc�����������ǹ�����Щ���������ͨ������Ԫ����������ġ�����Ԫ���ݿ�����xml�ļ���ע���java������
### ��һ��������Ϊbean��ע������Щ
* @Component��ͨ�õ�ע�⣬�ɱ�ע������Ϊspring��������һ��bean��֪��������һ�㣬������@Componentע���ע
* @Repository����Ӧ�־ò㼴DAO�㣬��Ҫ�������ݿ���ز���
* @Service����Ӧ����㣬��Ҫ�漰һЩ���ӵ��߼�����Ҫ�õ�DAO��
* @Controller����ӦSpring mvc���Ʋ㣬��Ҫ���ڽ����û����󲢵���Service�㷵�����ݸ�ǰ��ҳ��

### @Component��@Bean��������ʲô
* @Componentע���������࣬��@Beanע�������ڷ���
* @Componentͨ����ͨ����·��ɨ�����Զ�����Լ��Զ�װ�䵽spring�����У����ǿ���ʹ��@ComponentScanע�ⶨ��Ҫɨ���·�������ҳ���ʶ����Ҫװ������Զ�װ�䵽spring��bean�����У���@beanע��ͨ�������Ǳ��и�ע��ķ����ж���������bean��@bean������spring����ĳ�����ʵ����������Ҫ������ʱ�򻹸���
* @beanע���@Componentע����Զ����Ը�ǿ�����Һܶ�ʱ������ֻ��ͨ��@beanע��ע��bean�����統�������õ��������е�����Ҫװ�䵽spring����ʱ����ֻ��ͨ��@bean��ʵ��

```
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl();
    }
}
����Ĵ����൱�������xml����
<beans>
    <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

### ע��bean��ע������Щ
spring���õ�@Autowired�Լ�jdk���õ�@Resource��@Inject����������ע��bean
@Autowired��@Resourceʹ�õıȽ϶�һЩ


### @Autowired��@Resource��������ʲô
Autowired����spring���õ�ע�⣬Ĭ�ϵ�ע�뷽ʽΪbyType���������ͽ���ƥ�䣩��Ҳ����˵���ȸ��ݽӿ�����ȥƥ�䲢ע��bean���ӿڵ�ʵ���ࣩ

��һ���ӿڴ��ڶ��ʵ����������byType���ַ�ʽ���޷���ȷע������ˣ���Ϊ���ʱ��spring��ͬʱ�ҵ��������������ѡ��Ĭ����������Լ���֪��ѡ����һ��
����ʱ��ע�뷽ʽ����byName���������ƽ���ƥ�䣩���������ͨ��������������ĸСд����������������е�smsService�������������
```
@Autowired
private SmsService smsService
```
�ٸ����ӣ�SmsService������ʵ���ࣺSmsServiceImpl1��SmsServiceImpl2�������Ƕ���spring����������
```
//����byName��byType�޷�ƥ�䵽bean
@Autowired
private SmsService smsService;
//��ȷע��smsServiceImpl1�����Ӧ��bean
@Autowired
private SmsService smsServiceImpl1;
//��ȷע�� SmsServiceImpl1 �����Ӧ��bean��smsServiceImpl1��������˵������
@Autowired
@Qualifier(value="smsServiceImpl1")
private SmsService smsService;
```
һ�㽨��ͨ��@Qualifierע������ʽָ�����ƶ������������������ƣ�@Resource����jdk�ṩ��ע�⣬Ĭ��ע�뷽ʽΪbyName������޷�ͨ������ƥ�䵽bean�Ļ���ע�뷽ʽ����byType
@Resource�������Ƚ���Ҫ�����ԣ�name��type
�����ָ��name������ע�뷽ʽΪbyName���������ָ��type������ע�뷽ʽΪbyType�����ͬʱָ��name+type���ԣ������飩����ע�뷽ʽΪbyType+byName


�ܽ᣺
* ��һ���ӿڴ��ڶ��ʵ���࣬@Autowired��@Resource����Ҫͨ�����Ʋ�����ȷƥ�䵽bean��Autowired����ͨ��@Qualifierע������ʽָ�����ƣ�Resource����ͨ��name��������ʽָ������
* @Autowired֧���ڹ��캯�����������ֶκͲ�����ʹ�á�@Resource��Ҫ�����ֶκͷ�����ע�룬��֧���ڹ��캯���������ʹ��


### bean������������Щ
spring�е�bean�������������¼���
* singleton��ioc������ֻ��Ψһ��beanʵ����spring�е�beanĬ�϶��ǵ����ģ��ǶԵ������ģʽ��Ӧ��
* prototype��ÿ�λ�ȡ���ᴴ��һ���µ�beanʵ����Ҳ����˵������getBean()���Σ��õ�����������ͬ��Beanʵ��
* request����webӦ�ÿ��ã���ÿһ��http���󶼻����һ���µ�bean������bean������bean���ڵ�ǰhttp request����Ч
* session����webӦ�ÿ��ã�:ÿһ��������session��http���󶼻�����µ�bean���Ựbean������bean���ڵ�ǰhttp session����Ч
* application/global-session����webӦ�ÿ��ã���ÿ��webӦ��������ʱ����һ��bean��Ӧ��bean������bean���ڵ�ǰӦ������ʱ������Ч
* websocket����webӦ�ÿ��ã���ÿһ��websocket�Ự����һ���µ�bean

#### �������bean��������
xml��ʽ
<bean id="" class="" scope="singleton"></bean>

ע�ⷽʽ��
@Bean
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public Person PersonPrototype(){
    return new Person();
}


### Bean���̰߳�ȫ����
spring����е�bean�Ƿ��̰߳�ȫ��ȡ�������������״̬
��õ�����������prototype��singletonΪ�����������г�����bean��������ʹ��Ĭ�ϵ�singleton��
prototype�������£�ÿ�λ�ȡ���ᴴ��һ���µ�beanʵ������������Դ�������⣬���� �������̰߳�ȫ���⡣singleton�������£�ioc������ֻ��Ψһ��beanʵ�������ܴ�����Դ�������⣨ȡ����bean�Ƿ���״̬����������bean����״̬�Ļ����Ǿʹ����̰߳�ȫ���⣨��״̬bean��ָ�����ɱ�ĳ�Ա�����Ķ���
�����󲿷�beanʵ��������״̬��û�ж���ɱ�ĳ�Ա�������ģ�����DAO��Service������������£�bean�ǰ�ȫ��

������״̬����bean���̰߳�ȫ���⣬������������֣�
1����bean�о������ⶨ��ɱ�ĳ�Ա����
2�������ж���һ��ThreadLocal��Ա����������Ҫ�Ŀɱ��Ա����������ThreadLocal��


### bean����������
* bean�����ҵ������ļ���spring bean�Ķ���
* bean��������java reflection api����һ��beanʵ��
* ����漰��һЩ����ֵ����set()����һЩ����ֵ
* ���beanʵ��BeanNameAware�ӿڣ�����setBeanName����������bean������
* ���beanʵ����BeanClassLoaderAware�ӿڣ�����setBeanClassLoader(),����ClassLoader�����ʵ��
* ���beanʵ��BeanFactoryAware�ӿڣ�����setBeanFactory����������BeanFactory�����ʵ��
* ���������ƣ����ʵ��������*.aware�ӿڣ��͵�����Ӧ�ķ���
* ����кͼ������bean��spring������ص�BeanPostProcessor����ִ��postProcessBeforeInitialization()
* ���beanʵ����InitializaingBean�ӿڣ�ִ��afterPropertiesSet����
* ���bean�����ļ��еĶ������init-method���ԣ�ִ��ָ���ķ���
* ����кͼ������bean��spring������ص�BeanPostProcessor����ִ��postProcessAfterInitialization()
* ��Ҫ����bean��ʱ�����beanʵ����DisposableBean�ӿڣ�ִ��destory����
* ��Ҫ����bean��ʱ�����bean�������ļ��еĶ������destroy-method���ԣ�ִ��ָ���ķ���

![ͼƬ](https://images.xiaozhuanlan.com/photo/2019/b5d264565657a5395c2781081a7483e1.jpg)

### spring aop
#### ��aop�����
aop�ܹ�����Щ��ҵ���޹أ�ȴΪҵ��ģ������ͬ���õ��߼������η�װ���������ڼ���ϵͳ���ظ����룬����ģ��֮�����϶�
spring aop���ǻ��ڶ�̬����ģ����Ҫ����Ķ���ʵ����ĳ���ӿڣ���ôspring aop�ͻ�ʹ��jdk proxy��ȥ����������󣬶�����û��ʵ�ֽӿڵĶ��󣬾��޷�ʹ��jdk proxy���д�����ʱspring aop��ʹ��Cglib����һ������������������Ϊ����
![ͼƬ](https://oss.javaguide.cn/github/javaguide/system-design/framework/spring/230ae587a322d6e4d09510161987d346.jpeg)

��ȻҲ����ʹ��AspectJ��spring aop�Ѿ�����AspectJ
Target����֪ͨ�Ķ���
Proxy����Ŀ�����Ӧ��֪֮ͨ�󴴽��Ĵ������
���ӵ�/JoinPoint��Ŀ�������������У�����ķ�����Ϊ���ӵ�
�����/Pointcut������������/��ǿ�����ӵ㣨�����һ�������ӵ㣬���ӵ㲻һ��������㣩
֪ͨ/Advice����ǿ���߼�/���룬�����ص�Ŀ���������ӵ�֮��Ҫ������
Aspect�������+֪ͨ
Weaving����֪ͨӦ�õ�Ŀ����󣬽������ɴ������Ĺ��̶���
