# SQL
## DDL �������ݿ⡢����
### �������ݿ�

1. ��ѯ
> show databases;
2. �������ݿ� 
> create database ���ݿ�����;
3. �������ݿ⣨�жϣ���������ھʹ����� 
> create database if not exists ���ݿ�����;
4. ɾ�����ݿ�
> drop database ���ݿ�����;
5. ɾ�����ݿ⣨�жϣ�������ھ�ɾ����
> select database ���ݿ�����;
6. ��ѯ��ǰʹ�õ����ݿ�
> select database();
7. ʹ�����ݿ�
> use ���ݿ�����

### ����
1. ������
> create table ����(�ֶ���1 ��������1,�ֶ���2 ��������2);
### �޸�
1. ��ѯ��ǰ���ݿ������б�����
> show tables
1. ��ѯ��ṹ
> desc ������
3. �޸ı���
> alter table ���� rename to �µı���
4. ���һ��
> alter table ���� add ���� �������� 
5. �޸���������
> alter table ���� modify ���� �µ���������
6. �޸���������������
> alter table ���� change ���� ������ �µ���������
7. ɾ����
> alter table ���� drop ����

### ɾ��
1. ɾ����
> drop table ����
2. ɾ����ʱ�жϱ��Ƿ����
> drop table if exists ����
### ��������
* ��ֵ���� double(�ܳ���.С���������λ��)
* ��������
* �ַ�������


## DML �Ա��е����ݽ�����ɾ��
### ���
1. ��ָ�����������
> insert into ����(����1,����2) values (ֵ1,ֵ2)
2. ��ȫ�����������
> insert into ���� values (ֵ1,ֵ2)
3. �����������
> insert into ����(����1,����2...) values (ֵ1,ֵ2),(ֵ1,ֵ2).(ֵ1,ֵ2);
> insert into ���� values (ֵ1,ֵ2),(ֵ1,ֵ2),(ֵ1,ֵ2);
### �޸�
1. �޸ı�����
> update ���� set ����1=ֵ1������2=ֵ2 where ����
### ɾ��
1. ɾ�����ݣ�ɾ��������������������ɾ���������ݣ�
> delete from ���� where ����


## ��ѯ
### ��ѯ�﷨
> select �ֶ��б� from ���� where �����б� group by �����ֶ� having ��������� order by �����ֶ� limit ��ҳ�޶�

### ������ѯ
1. ��ѯ����ֶ�
> select �ֶ��б� from ����
2. ȥ���ظ���¼
> select distinct �ֶ��б� from ����
3. �����
> as asҲ����ʡ��
### ������ѯ
1. ������ѯ�﷨
> select �ֶ��б� from ���� where �����б�
2. ������<> ��!=
> select �ֶ��б� from ���� where �����б�
3. ���� between...and
> SELECT * FROM stu where score BETWEEN 70 and 90;
4. ��ѡһ in(...) 
> SELECT * FROM stu where score in(60,100,55);
5. ģ����ѯ like _:���������ַ� %:��������ַ�
> SELECT * FROM stu where name like "��_";
> SELECT * FROM stu where name like "%��%";
6. ����� and��&& or��|| not��!
> SELECT * FROM stu where gender='��' && score>10;
> SELECT * FROM stu where gender='��' || score>10;
> SELECT * FROM stu where not score<10 && not gender='��';

### �����ѯ
#### �����ѯ�﷨
> select �ֶ��б� from ���� order by �����ֶ���1 ����ʽ1;
> ����ж��������������ǰ�������ֵһ��ʱ���Ż���ݵڶ�������������

### �����ѯ
#### �����ѯ�﷨
> select �ֶ��б� from ���� where ����ǰ�����޶� group by �����ֶ��� having �������������;
> ע�⣺����֮�󣬲�ѯ���ֶ�Ϊ�ۺϺ����ͷ����ֶΣ���ѯ�����ֶ�������
> null���������оۺϺ���������
> count()ͳ�Ƶ���������Ϊnull;countȡֵ��1.����2.*
> where��having������
> ִ��ʱ����һ����where�Ƿ���֮ǰ�����޶���������where�������򲻲μӷ��飬��having�Ƿ���֮��Խ�����й���
> ���жϵ�������һ����where���ܶԾۺϺ��������жϣ�having����
> ִ��˳��where>�ۺϺ���>having

### ��ҳ��ѯ
1. ��ҳ��ѯ�﷨
> select �ֶ��б� from ���� limit ��ʼ���� ,��ѯ��Ŀ�� 
2. ���㹫ʽ
> ��ʼ����=����ǰҳ��-1��*ÿҳ��ʾ������ ��ʼ������0��ʼ
> limit����mysqlר��
  
### Լ��
1. Լ���ķ���
> �ǿ�Լ�� not null��ΨһԼ�� unique������Լ�� primary key��������һ�����ݵ�Ψһ��ʶ��Ҫ��ǿ���Ψһ�������Լ�� check����֤���е�ֵ����ĳһ�������� Ĭ��Լ�� default����������ʱ��δָ��ֵ�����Ĭ��ֵ�������Լ�� foreign key���������������֮�佨�����ӣ���֤���ݵ�һ���ԣ�
> �����ڱ������ϵĹ����������Ƽ�����е�����
> �ǿ�Լ�� ΨһԼ�� ����Լ�� ���Լ�� Ĭ��Լ�� ���Լ��
> mysql��֧�ּ��Լ��
> ��������������������֮�佨����ϵ
#### �ǿ�Լ��
1. ���Լ��
> create table ����(���� �������� not null);//���������Լ��
> alter table ���� modify �ֶ��� �������� not null//��������Լ��
2. ɾ��Լ��
> alter table ���� modify �ֶ��� ��������
#### ΨһԼ��
1. ���Լ��
> create table ���� (���� �������� unique[auto_increment]);
> //������ʱ���ΨһԼ��
2. ɾ��Լ��
> alter table ���� modify �ֶ��� �������� unique;
> //��������ΨһԼ��
#### ����Լ��
1. ���Լ��
> create table ����(���� �������� primary key );//�������������Լ��
> alter table ���� add primary key(�ֶ���)
2. ɾ��Լ��
> alter table ���� drop primary key
#### Ĭ��Լ��
1. ���Լ��
> create table ����(���� �������� default Ĭ��ֵ)
> alter table ���� alter ���� set default Ĭ��ֵ
2. ɾ��Լ��
> alter ���� table alter ���� drop default 
#### ���Լ��
1. ���Լ��
> create table ����(���� ��������,..constraint ������� foregin key ������� references ����(��������));
> alter table ���� add constraint ������� foreign key (����ֶ�����) reference ��������(�����ֶ�����)
2. ɾ��Լ��
> alter table ���� drop foreign key �������


### ����ѯ
> �ѿ���������AB�������ϣ�ȡAB���е�������
> ���Ӳ�ѯ
#### ������
> �൱�ڲ�ѯAB��������
1. �����Ӳ�ѯ�﷨
> select �ֶ��б� from ��1����2 where ����
> select �ֶ��б� from ��1[inner] join ��2 on ����
#### ������
> �������ӣ��൱�ڲ�ѯA���������ݺͽ�����������
> �������ӣ��൱�ڲ�ѯB���������ݺͽ�����������
1. �����Ӳ�ѯ�﷨
> select �ֶ��б� from ��1 left[outer] join ��2 on ����
> select �ֶ��б� from ��1 right[outer] join ��2 on ����
#### �Ӳ�ѯ
1. ���е���
> select �ֶ��б� from �� where �ֶ��� = (�Ӳ�ѯ)
2. ���е���
> select �ֶ��б� from �� where �ֶ��� in (�Ӳ�ѯ)
3. ���ж��� 
> select �ֶ��б� from (�Ӳ�ѯ) where ����
### ����
> mysql����Ĭ���Զ��ύ
