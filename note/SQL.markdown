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
* ����ж��������������ǰ�������ֵһ��ʱ���Ż���ݵڶ�������������

### �����ѯ
* null���������оۺϺ���������
* count()ͳ�Ƶ���������Ϊnull;countȡֵ��1.����2.*
* ����֮�󣬲�ѯ���ֶ�Ϊ�ۺϺ����ͷ����ֶΣ���ѯ�����ֶ�������
* where��having������
* ִ��ʱ����һ����where�Ƿ���֮ǰ�����޶���������where�������򲻲μӷ��飬��having�Ƿ���֮��Խ�����й���
* ���жϵ�������һ����where���ܶԾۺϺ��������жϣ�having����
* ִ��˳��where>�ۺϺ���>having
### �����ѯ
### ��ҳ��ѯ
* ��ʼ����=����ǰҳ��-1��*ÿҳ��ʾ������
* limit����mysqlר��
  
### Լ��
* �����ڱ������ϵĹ����������Ƽ�����е�����
* �ǿ�Լ�� ΨһԼ�� ����Լ�� ���Լ�� Ĭ��Լ�� ���Լ��
* mysql��֧�ּ��Լ��
* ��������������������֮�佨����ϵ
### ���ݿ����
### ����ѯ
* �ѿ���������AB�������ϣ�ȡAB���е�������
* ���Ӳ�ѯ
### ����
* mysql����Ĭ���Զ��ύ
