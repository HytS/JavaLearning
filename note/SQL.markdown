#
## DDL 操作数据库
* 查询
* show databases;
* 创建数据库 
> create database 数据库名称;
* 创建数据库（判断，如果不存在就创建） 
>create database if not exists 数据库名称;
* 删除数据库
> drop database 数据库名称;
* 删除数据库（判断，如果存在就删除）
> select database 数据库名称;
* 查询当前使用的数据库
> select database();
* 使用数据库
> use 数据库名称
## 操作表
* 查询档期那数据库下所有表名称
> show tables;
* 查询表结构
>desc 表名称;
* 创建表
> create table 表名(字段名 数据类型,字段名 数据类型,字段名 数据类型);
> drop table 表名
> drop  表名
### 数据类型
* 数值类型
* 日期类型
* 字符串类型


## 查询
* and && 与
* =
* != <> 都是不等于
* || or in(a,b) 或
* null的比较不能使用=，!=。要使用is is not进行比较
* 模糊查询 like 通配符 1._:代表单个任意字符 2.%:代表任意个数字符  
### 排序查询
* 如果有多个排序条件，当前面的条件值一样时，才会根据第二条件进行排序

### 分组查询
* null不参与所有聚合函数的运算
* count()统计的列名不能为null;count取值：1.主键2.*
* 分组之后，查询的字段为聚合函数和分组字段，查询其他字段无意义
* where和having的区别
* 执行时机不一样：where是分组之前进行限定，不满足where条件，则不参加分组，而having是分组之后对结果进行过滤
* 可判断的条件不一样：where不能对聚合函数进行判断，having可以
* 执行顺序：where>聚合函数>having
### 排序查询
### 分页查询
* 起始索引=（当前页码-1）*每页显示的条数
* limit属于mysql专属

