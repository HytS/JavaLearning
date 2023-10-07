## 什么是数据库、数据库管理系统、数据库系统、数据库管理员
数据库：就是信息的集合，或者说数据库是由数据库管理系统管理的数据的集合
数据库管理系统：是一种操纵和管理数据库的大型软件，通常用于建立、使用和维护数据库
数据库系统：通常由软件、数据库和数据管理员组成
数据库管理员：负责全面管理和控制数据库系统

## 什么是元组、码、候选码、主码、外码、主属性、非主属性


# MYSQL
## 基础
### 什么是关系数据库
是一种建立在关系模型的基础上的数据库，关系模型表明数据库中所存的数据之间的联系

### 什么是mysql
mysql是一种关系型数据库，主要用于持久化存储我们的系统中的一些数据。mysql默认端口号3306

### mysql字段类型
数值类型:整型（TINYINT、SMALLINT、MEDIUMINT、INT 和 BIGINT）、 浮点型（FLOAT 和 DOUBLE）、定点型（DECIMAL）
字符串类型：CHAR、VARCHAR、TINYTEXT、TEXT、MEDIUMTEXT、LONGTEXT、TINYBLOB、BLOB、MEDIUMBLOB 和 LONGBLOB 等，最常用的是 CHAR 和 VARCHAR。
日期时间类型：YEAR、TIME、DATE、DATETIME 和 TIMESTAMP 等。

### 整数类型的unsigned属性有什么用
unsigned属性表示不允许负值的无符号整数。使用unsigned属性可以将正整数的上限提高一倍，因为它不需要存储负值
对于从0开始递增的id列，使用unsigned属性非常适合，因为不允许负值并且可以拥有更大的上限范围，提供了更多的id值可用

### char和varchar的区别是什么
char和varchar是最常用到的字符串类型，区别是char是定长字符串，varchar是变长字符串
char更适合存储长度较短或长度都差不多的字符串，varchar适合存储长度不确定或者差异较大的字符串
char(M)和varchar(M)的M都代表能够保存的字符数的最大值，无论是数字、字母还是中文，都只占一个字符

### varchar(10)和varchar(100)的区别是什么
varchar(100)可以满足更大范围的字符存储需求，varchar(10)存储超过10个字符时，就需要修改表结构
varchar(10)和varchar(100)存储的字符范围不同，但是二者存储相同的字符串，所占用磁盘的存储空间是一样的
varchar(100)会消耗更多的内存，因为varchar类型在内存中操作时，通常会分配固定大小的内存块来保存值，即使用字符类型中定义的长度

### decimal和float/double的区别
decimal与float的区别：decimal是定点数，float/double是浮点数，decimal可以存储精确的小数值，float/double只能存储近似的小数值
decimal用于存储具有精度要求的小数

### 为什么不推荐使用text和blob
text类似于char和varchar，但可以存储更长文本的字符串，例如博客内容；blon类型主要用于存储二进制大对象，例如照片，音视频文件   
缺点：不能有默认值；在使用临时表时无法使用内存临时表，只能在磁盘上创建临时表；检索效率低；不能直接创建索引，需要指定前缀长度；可能会消耗大量网络和io带宽；可能导致表上的dml操作变慢


### datetime和timestamp的区别
datetime类型没有时区信息，timestamp与时区有关
timestamp只需要使用4个字节的存储空间，但是datetime需要耗费8个字节的存储空间，导致timestamp表示的时间范围更小

### null和''的区别
null代币哎一个不确定的值，就算是两个null，他俩也不一定相等，比如select null = null的结果为false，但是当使用distinct、group by、order by时，null又被认为是相等的
''的长度为0，不占用空间，null需要占用空间
null会影响聚合函数，比如sum、avg、min等聚合函数会忽略null值。count的处理方式取决于参数类型。如果参数是*，则会统计所有的记录数，包括null值；如果参数是某个字段名（count(列名)），则会忽略null值，只统计非空值的个数
查询null值时，必须使用is null或is not null来判断，不能使用>、<之类的比较运算符，而''可以使用这些比较运算符

### Boolean类型如何表示
mysql中没有专门的布尔类型，使用tinyint(1)来表示布尔值，tinyint(1)类型可以用来存储0或1，分别对应false或true
