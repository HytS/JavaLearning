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
### 数据类型
* 数值类型
* 日期类型
* 字符串类型


