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

