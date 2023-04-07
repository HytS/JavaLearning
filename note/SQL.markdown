# SQL
## DDL 操作数据库、表、列
### 操作数据库

1. 查询
> show databases;
2. 创建数据库 
> create database 数据库名称;
3. 创建数据库（判断，如果不存在就创建） 
> create database if not exists 数据库名称;
4. 删除数据库
> drop database 数据库名称;
5. 删除数据库（判断，如果存在就删除）
> select database 数据库名称;
6. 查询当前使用的数据库
> select database();
7. 使用数据库
> use 数据库名称

### 创造
1. 创建表
> create table 表名(字段名1 数据类型1,字段名2 数据类型2);
### 修改
1. 查询当前数据库下所有表名称
> show tables
1. 查询表结构
> desc 表名称
3. 修改表名
> alter table 表名 rename to 新的表名
4. 添加一列
> alter table 表名 add 列名 数据类型 
5. 修改数据类型
> alter table 表名 modify 列名 新的数据类型
6. 修改列名和数据类型
> alter table 表名 change 列名 新列名 新的数据类型
7. 删除列
> alter table 表名 drop 列名

### 删除
1. 删除表
> drop table 表名
2. 删除表时判断表是否存在
> drop table if exists 表名
### 数据类型
* 数值类型 double(总长度.小数点后保留的位数)
* 日期类型
* 字符串类型


## DML 对表中的数据进行增删改
### 添加
1. 给指定列添加数据
> insert into 表名(列名1,列名2) values (值1,值2)
2. 给全部列添加数据
> insert into 表名 values (值1,值2)
3. 批量添加数据
> insert into 表名(列名1,列名2...) values (值1,值2),(值1,值2).(值1,值2);
> insert into 表名 values (值1,值2),(值1,值2),(值1,值2);
### 修改
1. 修改表数据
> update 表名 set 列名1=值1，列名2=值2 where 条件
### 删除
1. 删除数据（删除语句如果不加条件，则删除所有数据）
> delete from 表名 where 条件


## 查询
### 查询语法
> select 字段列表 from 表名 where 条件列表 group by 分组字段 having 分组后条件 order by 排序字段 limit 分页限定

### 基础查询
1. 查询多个字段
> select 字段列表 from 表名
2. 去除重复记录
> select distinct 字段列表 from 表名
3. 起别名
> as as也可以省略
### 条件查询
1. 条件查询语法
> select 字段列表 from 表名 where 条件列表
2. 不等于<> 或!=
> select 字段列表 from 表名 where 条件列表
3. 包含 between...and
> SELECT * FROM stu where score BETWEEN 70 and 90;
4. 多选一 in(...) 
> SELECT * FROM stu where score in(60,100,55);
5. 模糊查询 like _:单个任意字符 %:多个任意字符
> SELECT * FROM stu where name like "李_";
> SELECT * FROM stu where name like "%林%";
6. 并或非 and或&& or或|| not或!
> SELECT * FROM stu where gender='男' && score>10;
> SELECT * FROM stu where gender='男' || score>10;
> SELECT * FROM stu where not score<10 && not gender='男';

### 排序查询
#### 排序查询语法
> select 字段列表 from 表名 order by 排序字段名1 排序方式1;
> 如果有多个排序条件，当前面的条件值一样时，才会根据第二条件进行排序

### 分组查询
#### 分组查询语法
> select 字段列表 from 表名 where 分组前条件限定 group by 分组字段名 having 分组后条件过滤;
> 注意：分组之后，查询的字段为聚合函数和分组字段，查询其他字段无意义
> null不参与所有聚合函数的运算
> count()统计的列名不能为null;count取值：1.主键2.*
> where和having的区别
> 执行时机不一样：where是分组之前进行限定，不满足where条件，则不参加分组，而having是分组之后对结果进行过滤
> 可判断的条件不一样：where不能对聚合函数进行判断，having可以
> 执行顺序：where>聚合函数>having

### 分页查询
1. 分页查询语法
> select 字段列表 from 表名 limit 起始索引 ,查询条目数 
2. 计算公式
> 起始索引=（当前页码-1）*每页显示的条数 起始索引从0开始
> limit属于mysql专属
  
### 约束
1. 约束的分类
> 非空约束 not null、唯一约束 unique、主键约束 primary key（主键是一行数据的唯一标识，要求非空且唯一）、检查约束 check（保证列中的值满足某一条件）、 默认约束 default（保存数据时，未指定值则采用默认值）、外键约束 foreign key（让两个表的数据之间建立链接，保证数据的一致性）
> 作用于表中列上的规则，用于限制加入表中的数据
> 非空约束 唯一约束 主键约束 检查约束 默认约束 外键约束
> mysql不支持检查约束
> 外键用来让两个表的数据之间建立联系
#### 非空约束
1. 添加约束
> create table 表名(列名 数据类型 not null);//创建表添加约束
> alter table 表名 modify 字段名 数据类型 not null//建完表添加约束
2. 删除约束
> alter table 表名 modify 字段名 数据类型
#### 唯一约束
1. 添加约束
> create table 表名 (列名 数据类型 unique[auto_increment]);
> //创建表时添加唯一约束
2. 删除约束
> alter table 表名 modify 字段名 数据类型 unique;
> //建表后添加唯一约束
#### 主键约束
1. 添加约束
> create table 表名(列名 数据类型 primary key );//创建表添加主键约束
> alter table 表名 add primary key(字段名)
2. 删除约束
> alter table 表名 drop primary key
#### 默认约束
1. 添加约束
> create table 表名(列名 数据类型 default 默认值)
> alter table 表名 alter 列名 set default 默认值
2. 删除约束
> alter 表名 table alter 列名 drop default 
#### 外键约束
1. 添加约束
> create table 表名(列名 数据类型,..constraint 外键名称 foregin key 外键列名 references 主表(主表列名));
> alter table 表名 add constraint 外键名称 foreign key (外键字段名称) reference 主表名称(主表字段名称)
2. 删除约束
> alter table 表名 drop foreign key 外键名称


### 多表查询
> 笛卡尔积：有AB两个集合，取AB所有的组合情况
> 连接查询
#### 内连接
> 相当于查询AB交集数据
1. 内连接查询语法
> select 字段列表 from 表1，表2 where 条件
> select 字段列表 from 表1[inner] join 表2 on 条件
#### 外连接
> 左外连接：相当于查询A表所有数据和交集部分数据
> 右外连接：相当于查询B表所有数据和交集部分数据
1. 外连接查询语法
> select 字段列表 from 表1 left[outer] join 表2 on 条件
> select 字段列表 from 表1 right[outer] join 表2 on 条件
#### 子查询
1. 单行单列
> select 字段列表 from 表 where 字段名 = (子查询)
2. 多行单列
> select 字段列表 from 表 where 字段名 in (子查询)
3. 多行多列 
> select 字段列表 from (子查询) where 条件
### 事务
> mysql事务默认自动提交
