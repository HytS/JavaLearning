## ʲô�����ݿ⡢���ݿ����ϵͳ�����ݿ�ϵͳ�����ݿ����Ա
���ݿ⣺������Ϣ�ļ��ϣ�����˵���ݿ��������ݿ����ϵͳ���������ݵļ���
���ݿ����ϵͳ����һ�ֲ��ݺ͹������ݿ�Ĵ���������ͨ�����ڽ�����ʹ�ú�ά�����ݿ�
���ݿ�ϵͳ��ͨ�������������ݿ�����ݹ���Ա���
���ݿ����Ա������ȫ������Ϳ������ݿ�ϵͳ

## ʲô��Ԫ�顢�롢��ѡ�롢���롢���롢�����ԡ���������


# MYSQL
## ����
### ʲô�ǹ�ϵ���ݿ�
��һ�ֽ����ڹ�ϵģ�͵Ļ����ϵ����ݿ⣬��ϵģ�ͱ������ݿ������������֮�����ϵ

### ʲô��mysql
mysql��һ�ֹ�ϵ�����ݿ⣬��Ҫ���ڳ־û��洢���ǵ�ϵͳ�е�һЩ���ݡ�mysqlĬ�϶˿ں�3306

### mysql�ֶ�����
��ֵ����:���ͣ�TINYINT��SMALLINT��MEDIUMINT��INT �� BIGINT���� �����ͣ�FLOAT �� DOUBLE���������ͣ�DECIMAL��
�ַ������ͣ�CHAR��VARCHAR��TINYTEXT��TEXT��MEDIUMTEXT��LONGTEXT��TINYBLOB��BLOB��MEDIUMBLOB �� LONGBLOB �ȣ���õ��� CHAR �� VARCHAR��
����ʱ�����ͣ�YEAR��TIME��DATE��DATETIME �� TIMESTAMP �ȡ�

### �������͵�unsigned������ʲô��
unsigned���Ա�ʾ��������ֵ���޷���������ʹ��unsigned���Կ��Խ����������������һ������Ϊ������Ҫ�洢��ֵ
���ڴ�0��ʼ������id�У�ʹ��unsigned���Էǳ��ʺϣ���Ϊ��������ֵ���ҿ���ӵ�и�������޷�Χ���ṩ�˸����idֵ����

### char��varchar��������ʲô
char��varchar����õ����ַ������ͣ�������char�Ƕ����ַ�����varchar�Ǳ䳤�ַ���
char���ʺϴ洢���Ƚ϶̻򳤶ȶ������ַ�����varchar�ʺϴ洢���Ȳ�ȷ�����߲���ϴ���ַ���
char(M)��varchar(M)��M�������ܹ�������ַ��������ֵ�����������֡���ĸ�������ģ���ֻռһ���ַ�

### varchar(10)��varchar(100)��������ʲô
varchar(100)�����������Χ���ַ��洢����varchar(10)�洢����10���ַ�ʱ������Ҫ�޸ı��ṹ
varchar(10)��varchar(100)�洢���ַ���Χ��ͬ�����Ƕ��ߴ洢��ͬ���ַ�������ռ�ô��̵Ĵ洢�ռ���һ����
varchar(100)�����ĸ�����ڴ棬��Ϊvarchar�������ڴ��в���ʱ��ͨ�������̶���С���ڴ��������ֵ����ʹ���ַ������ж���ĳ���

### decimal��float/double������
decimal��float������decimal�Ƕ�������float/double�Ǹ�������decimal���Դ洢��ȷ��С��ֵ��float/doubleֻ�ܴ洢���Ƶ�С��ֵ
decimal���ڴ洢���о���Ҫ���С��

### Ϊʲô���Ƽ�ʹ��text��blob
text������char��varchar�������Դ洢�����ı����ַ��������粩�����ݣ�blon������Ҫ���ڴ洢�����ƴ����������Ƭ������Ƶ�ļ�   
ȱ�㣺������Ĭ��ֵ����ʹ����ʱ��ʱ�޷�ʹ���ڴ���ʱ����ֻ���ڴ����ϴ�����ʱ��������Ч�ʵͣ�����ֱ�Ӵ�����������Ҫָ��ǰ׺���ȣ����ܻ����Ĵ��������io���������ܵ��±��ϵ�dml��������


### datetime��timestamp������
datetime����û��ʱ����Ϣ��timestamp��ʱ���й�
timestampֻ��Ҫʹ��4���ֽڵĴ洢�ռ䣬����datetime��Ҫ�ķ�8���ֽڵĴ洢�ռ䣬����timestamp��ʾ��ʱ�䷶Χ��С

### null��''������
null���Ұ�һ����ȷ����ֵ������������null������Ҳ��һ����ȣ�����select null = null�Ľ��Ϊfalse�����ǵ�ʹ��distinct��group by��order byʱ��null�ֱ���Ϊ����ȵ�
''�ĳ���Ϊ0����ռ�ÿռ䣬null��Ҫռ�ÿռ�
null��Ӱ��ۺϺ���������sum��avg��min�ȾۺϺ��������nullֵ��count�Ĵ�����ʽȡ���ڲ������͡����������*�����ͳ�����еļ�¼��������nullֵ�����������ĳ���ֶ�����count(����)����������nullֵ��ֻͳ�Ʒǿ�ֵ�ĸ���
��ѯnullֵʱ������ʹ��is null��is not null���жϣ�����ʹ��>��<֮��ıȽ����������''����ʹ����Щ�Ƚ������

### Boolean������α�ʾ
mysql��û��ר�ŵĲ������ͣ�ʹ��tinyint(1)����ʾ����ֵ��tinyint(1)���Ϳ��������洢0��1���ֱ��Ӧfalse��true


## SQL��mysql�е�ִ�й���
### mysql�����ܹ�����
��������������֤��Ȩ����أ���½mysql��ʱ��
��ѯ����:ִ�в�ѯ����ʱ�򣬻��Ȳ�ѯ���棨8.0֮���Ƴ���
��������û�����л���Ļ���sql���ͻᾭ������������������Ҫ�ȿ�sql���Ҫ��ʲô���ټ�����sql����﷨�Ƿ���ȷ
�Ż���������mysql��Ϊ���ŵķ���ȥִ��
ִ������ִ����䣬Ȼ��Ӵ洢���淵�����ݡ�ִ�����ǰ�����ж��Ƿ���Ȩ�ޣ������ӴȨ�޾ͻᱨ��
���ʽ�洢���棺��Ҫ�������ݵĴ洢���ȡ�����õ��ǲ��ʽ�ܹ���֧��InnoDB��MyISAM��Memory �ȶ��ִ洢����
![ͼƬ](https://oss.javaguide.cn/javaguide/13526879-3037b144ed09eb88.png)

mysql��Ҫ��Ϊserver��ʹ洢����㣺
server�㣺��Ҫ��������������ѯ���桢���������Ż�����ִ���������п�洢����Ĺ��ܶ�����һ��ʵ�֣�����洢���̣�����������ͼ��������
�洢���棺��Ҫ�������ݵĴ洢�Ͷ�ȡ�����ÿ����滻�Ĳ��ʽ�ܹ���֧��innoDB��MyISAM��Memory�ȶ���洢���棬����InnoDB���������е���־ģ��redologģ�飬������õĴ洢������InnoDB������5.5��ʼ�ͱ�����Ĭ�ϴ洢������

#### Server������������
1)������
��������Ҫ��������֤��Ȩ����صĹ�����أ���Ҫ�����û���½���ݿ⣬�����û���������֤������У���û����룬Ȩ�޵Ȳ���������û��˻�����У��ͨ�����������ᵽȨ�ޱ��в�ѯ���û�������Ȩ�ޣ�֮��������������Ȩ���߼��ж϶�����������ʱ������Ȩ�����ݣ�Ҳ����˵������ֻҪ������Ӳ��Ͽ�����ʹ����Ա�޸��˸��û���Ȩ�ޣ����û�Ҳ����Ӱ��
2)��ѯ���棨8.0�Ժ��Ƴ���
��ѯ������Ҫ������������ִ�е�select����Լ������Ľ������
���ӽ�����ִ�в�ѯ���ʱ�����Ȳ�ѯ���棬mysql����У�����sql����Ƿ�ִ�й�����k-v����ʽ�������ڴ��У�k�ǲ�ѯ��䣬v�ǽ�������������k�����У��ͻ�ֱ�ӷ��ظ��ͻ��ˣ����û�����У��ͻ�ִ�к����Ĳ�������ɺ�Ҳ��ѽ�����������������´ε��á���Ȼ������ִ�л����ѯ��ʱ���ǻ�У���û���Ȩ�ޣ��Ƿ��иñ��Ĳ�ѯ����

mysql��ѯ������ʹ�û��棬��Ϊ��ѯ����ʧЧ��ʵ��ҵ�񳡾��п��ܻ��Ƶ���������һ�������µĻ���������ϵ����в�ѯ���涼�ᱻ��գ����Դ��������£����Ƽ�ʹ�ò�ѯ����
3)������
mysqlû�����л��棬�ͻ�������������������Ҫ����sql��������
��һ�����ʷ�������������ȡ�ؼ��֣����� select�������ѯ�ı�������ֶ����������ѯ�����ȵȡ�������Щ�����󣬾ͻ����ڶ�����
�ڶ������﷨��������Ҫ�����ж�������� SQL �Ƿ���ȷ���Ƿ���� MySQL ���﷨��
4)�Ż���
�Ż��������þ�������Ϊ�����ŵ�ִ�з���ȥִ��(��ʱ����ܲ�����ѷ���)������������ʱ���ѡ�������������ѯʱ���ѡ�����˳�򣻾����Ż���֮��֮������������ִ�о��Ѿ���������
5)ִ����
��ѡ����ִ�з�����mysql��׼����ʼִ���ˣ�����ִ��ǰ��У����û���û��Ȩ�ޣ����û��Ȩ�޾ͻ᷵�ش�����Ϣ�������Ȩ�ޣ��ͻ��������Ľӿڣ����ؽӿ�ִ�еĽ��

### ������
#### ��ѯ���
sql���ִ������
select * from tb_student  A where A.age='18' and A.name=' ���� ';
* �ȼ�������Ƿ���Ȩ�ޣ����û��Ȩ��ֱ�ӷ��ش�����Ϣ�������Ȩ�ޣ���8.0֮ǰ�����Ȳ�ѯ���棬������sql���Ϊkey���ڴ��в�ѯ�Ƿ��н���������ֱ�ӻ��棬���û��ִ����һ��
* ͨ�����������дʷ���������ȡsql���ؼ�Ԫ�أ�Ȼ���ж����sql����Ƿ����﷨����������û����ͽ�����һ��
* �Ż��������Լ����Ż��㷨����ѡ��ִ��Ч����õ�һ������
* ����Ȩ��У�飬���û��Ȩ�޾ͻ᷵�ش�����Ϣ�������Ȩ�޾ͻ�������ݿ�����ӿڣ����������ִ�н��

#### �������
update tb_student A set A.age='19' where A.name=' ���� ';
�������������޸������䣬��ʵ�����ݿ�϶�����������������ֶεģ���ȻҪ�����������˴�ġ���ʵ�������Ҳ�����ϻ�������һ����ѯ�������ߣ�ֻ����ִ�и��µ�ʱ��϶�Ҫ��¼��־������ͻ�������־ģ���ˣ�MySQL �Դ�����־ģ���� binlog���鵵��־�� �����еĴ洢���涼����ʹ�ã����ǳ��õ� InnoDB ���滹�Դ���һ����־ģ�� redo log��������־�������Ǿ��� InnoDB ģʽ����̽���������ִ�����̡��������£�

* �Ȳ�ѯ��������һ�����ݣ�����л��棬Ҳ���õ�����
* Ȼ���õ���ѯ��䣬��age��Ϊ19��Ȼ���������api�ӿڣ�д����һ�����ݣ�innoDB��������ݱ��浽�ڴ��У�ͬʱ��¼redo log����ʱredo log����prepare״̬��Ȼ�����ִ������ִ����ɣ���ʱ�����ύ
* ִ�����յ�֪ͨ���¼binlog��Ȼ���������ӿڣ��ύredo logΪ�ύ״̬
* �������

> ����϶���ͬѧ���ʣ�ΪʲôҪ��������־ģ�飬��һ����־ģ�鲻����?

������Ϊ�ʼ MySQL ��û�� InnoDB ���棨InnoDB ������������˾�Բ����ʽ���� MySQL �ģ���MySQL �Դ��������� MyISAM����������֪�� redo log �� InnoDB �������еģ������洢���涼û�У���͵��»�û�� crash-safe ������(crash-safe ��������ʹ���ݿⷢ���쳣������֮ǰ�ύ�ļ�¼�����ᶪʧ)��binlog ��־ֻ�������鵵��

������˵ֻ��һ����־ģ�鲻���ԣ�ֻ�� InnoDB �������ͨ�� redo log ��֧������ġ���ô���ֻ���ͬѧ�ʣ�����������־ģ�飬���ǲ�Ҫ��ô�����в��У�Ϊʲô redo log Ҫ���� prepare Ԥ�ύ״̬�����������÷�֤����˵����ΪʲôҪ��ô����
* ��дredo logֱ���ύ��Ȼ��дbinlog������д��redo log�󣬻������ˣ�binlog��־û��д�룬��ô���������󣬻�ͨ��redo log�ָ����ݣ��������ʱ���binlog��û�м�¼�����ݣ��������������ݵ�ʱ�򣬾ͻᶪʧ�������ݣ�ͬʱ����ͬ��Ҳ�ᶪʧ��һ������
* ��дbinlog��Ȼ��дredo log������д��binlog�������쳣�����ˣ�����û��redo log�������޷��ָ����ݣ�����binlog���м�¼����ô������ͬ���ĵ������ͻ�������ݲ�һ�µ����

�������redo log���׶��ύ�ķ�ʽ�Ͳ�һ���ˣ�д��binlog��Ȼ�����ύredo log�ͻ��ֹ���������⣬�Ӷ���֤���ݵ�һ���ԡ�

���redo log����Ԥ�ύ״̬��binlogҲд���ˣ���ʱ�����쳣��������ô����
���Ҫ����mysql�Ĵ��������ˣ������������£�
* �ж�redo log�Ƿ�����������ж��������ģ��������ύ
* ���redo logֻ��Ԥ�ύ������commit״̬�����ʱ��ͻ�ȥ�ж�binlog�Ƿ�����������������ύredo log���������ͻع�����

��ѯ����ִ���������£�Ȩ��У�飨������л��棩--->��ѯ����--->������--->�Ż���--->Ȩ��У��--->ִ����--->����
�������ִ���������£�������---->Ȩ��У��---->ִ����--->����---redo log(prepare ״̬)--->binlog--->redo log(commit ״̬)


### Mysql�洢����
#### mysql֧���ĸ��洢���棿Ĭ��ʹ���ĸ���
mysql֧�ֶ��ִ洢���棬����ʹ��show engines����鿴mysql֧�ֵĴ洢���棻mysql��ǰĬ��������innoDB���������д洢������ֻ��innoDB�������Դ洢���棬��ֻ��innoDB֧������5.5.5֮ǰ��MyISAM��Ĭ�ϴ洢���棬5.5.5֮��InnoDB��Ĭ�ϴ洢����

#### Mysql�洢����ܹ�
mysql�洢������õ��ǲ��ʽ�ܹ���֧�ֶ��ִ洢���棬���ǿ���Ϊ��ͬ�����ݱ����ò�ͬ�Ĵ洢��������Ӧ��ͬ��������Ҫ���洢ʽ�����ǻ��ڱ��ģ��������ݿ�

���Ը���mysql����Ĵ洢����ʵ�ֱ�׼�ӿ�����дһ�������Լ��Ĵ洢����

#### MyISAM��InnoDB��ʲô����
MyISAM��֧��������м���������ȱ���Ǳ������޷���ȫ�ָ�
1���Ƿ�֧���м���
MyISAMֻ�б���������InnoDB֧���м����ͱ�������Ĭ��Ϊ�м�������MyISAMһ��������ס�����ű������ڲ���д������º����
2���Ƿ�֧������
MyISAM���ṩ����֧�֣�InnoDB�ṩ����֧�֣�ʵ����sql��׼�������ĸ����뼶�𣬾����ύ�ͻع������������InnoDBĬ��ʹ�õ�repeatable-read�����ض������뼶���ǿ��Խ���ö�����ķ�����
3���Ƿ�֧�����
MyISAM��֧�֣�InnoDB֧��
�������ά������һ���Էǳ��а��������Ƕ�������һ������ģ���ˣ�ͨ����������������Ŀ��ʹ���������ҵ������н���Լ������
ע������ʹ������뼶����һ��������������Ӧ�ò���
ѧ�����е�student_id����������ô�ɼ����е�student_id��Ϊ������������ѧ�����е�student_id,ͬʱ�����ɼ����е�student_id���£���Ϊ�������£�����ͼ������¸������ڵ����Ͳ��������ʺϷֲ�ʽ���߲�����Ⱥ������������ǿ�������������ݿ���·籩�ķ��գ����Ӱ�����ݿ�Ĳ����ٶ�

4���Ƿ�֧�����ݿ��쳣������İ�ȫ�ָ�
MyISAM��֧�֣�InnoDB֧��

5���Ƿ�֧��MVCC
MyISAM��֧�֣�InnoDB֧��
MyISAM���м�������֧�֣�MVCC���Կ����м�����������������Ч���ټ�������

6������ʵ�ֲ�һ��
MyISAM�����InnoDB���涼��ʹ��B+tree��Ϊ�����ṹ���������ߵ�ʵ�ַ�ʽ��̫һ��
InnoDB�����У��������ļ��������������ļ������MyISAM�������ļ��������ļ��Ƿ���ģ���������ļ��������ǰ���B+tree��֯��һ�������ṹ������Ҷ�ڵ�data�򱣴������������ݼ�¼
7�������в��
InnoDB���ܱ�MyISAM��ǿ���������ڶ�д���ģʽ����ֻ��ģʽ�£�����cpu���������ӣ�InnoDB�Ķ�д������������

#### MyISAM��InnoDB���ѡ��
����������ѡ��InnoDB�洢���棬��ĳЩ���ܼ�������£�ʹ��MyISAMҲ����
��mysql�����ܡ�����һ�仰����Ҫ�������š�MyISAM��InnoDB�족֮��ľ���̸֮��������۲����ԣ��ھ۴������У�InnoDB�ٶȿ���MyISAM
һ�������ѡ��InnoDBû�����⣬����ĳЩ���������ܲ����ں�����չ�����Ͳ���������Ҳ����Ҫ����֧�֣�Ҳ���ں�������İ�ȫ�ָ�����Ļ���ѡ��MyISAMҲ����

## mysql��ѯ����
ִ�в�ѯ����ʱ����Ȳ�ѯ���棬������8.0֮���Ƴ���������ѯ�������ͬ���Ĳ�ѯ�����Լ���������£���ֱ���ڻ����з��ؽ����
��ѯ���治���е������
1.�κ�������ѯ���κ��ַ��ϵĲ�ͬ���ᵼ�»��治����
2.�����ѯ�а����κ��û��Զ��庯�����洢�������û���������ʱ����mysql�е�ϵͳ�������ѯ���Ҳ���ᱻ����
3.���潨����mysql�Ĳ�ѯ����ϵͳ�������Ƶ�ÿ�ű��������Щ�������仯����ô�����ű���ص����л������ݶ���ʧЧ

������Ȼ���������ݿ�Ĳ�ѯ���ܣ����ǻ���ͬʱҲ�����˶��⿪����ÿ�β�ѯ��Ҫ��һ�λ��������ʧЧ��Ҫ���٣���ˣ�������ѯ����Ҫ�������������д�ܼ���Ӧ�ø�����ˡ����������Ҫע����ƻ���ռ��С
## mysql��־
### ʲô������
�������߼��ϵ�һ�������Ҫô��ִ�У�Ҫô����ִ��
������������С����С��ת1000Ԫ�����ת���漰�������ؼ��������������������붼�ɹ����߶�ʧ��
1.��С����������1000
2.��С����������1000
��������������������һ���߼��ϵ����壬�������Ҫ�����Ĳ���Ҫô���ɹ���Ҫô��ʧ�ܣ������Ͳ������С�������ٶ�С������û�����ӵ������

### ʲô�����ݿ�����
������������̸�������ʱ�����û����ָ�ֲ�ʽ��������ָ�ľ������ݿ�����
�����Ŀ���ڵ���ܹ����Ӵ��ľ������ݿ�����
#### ���ݿ�������ʲô����
���ݿ�������Ա�֤��������ݿ�Ĳ���������sql��䣩����һ���߼��ϵ����壬�������߼��ϵ��������Щ���ݿ������ѭ��Ҫôȫ��ִ�гɹ���Ҫôȫ����ִ��
```
# ����һ������
start transaction;
## �ύ����
commit;
```
��ϵ�����ݿ�������acid���ԣ�a��ԭ���ԣ�c��һ���ԣ�i�������ԣ�d���־���
ԭ���ԣ���������С��ִ�е�λ���������ָ�����ԭ����Ҫ��֤����Ҫôȫ����ɣ�Ҫô��ȫ��������
һ���ԣ�ִ������ǰ�����ݱ���һ�£�����ת��ҵ�����������Ƿ�ɹ����տ�����ת���˵��ܶ��
�����ԣ������������ݿ�ʱ��һ���û������񲻱�����������ţ�����������֮�����ݿ��Ƕ�����
�־��ԣ�һ�������ύ���������ݿ������ݿ������ݵĸı��ǳ־õģ���ʹ���ݿⷢ������Ҳ��Ӧ�ö������κ�Ӱ��
ֻ�б�֤������ĳ־��ԡ������ԡ�ԭ���ԣ����ܱ���һ���ԣ�Ҳ����˵adi���ֶΣ�c��Ŀ��

### ���������������Щ����
�ڵ��͵�Ӧ�ó����У�������񲢷������������������ͬ��������ɸ��Ե����񣨶���û���ͬһ���ݽ��в�������������Ȼ�Ǳ���ģ������ܻᵼ�����µ�����
#### ���
һ�������ȡ���ݲ������ݽ������޸ģ�����޸Ķ�����������˵�ǿɼ��ģ���ʹ��ǰ����û�б��ύ����ʱ����һ�������ȡ�������δ�ύ�����ݣ�����һ������ͻȻ�ع�����������û��ͬ�������ݿ⣬�ǵڶ��������ȡ���ľ��������ݡ�
���磺���� 1 ��ȡĳ���е����� A=20������ 1 �޸� A=A-1������ 2 ��ȡ�� A = 19,���� 1 �ع����¶� A ���޸Ĳ�δ�ύ�����ݿ⣬ A ��ֵ���� 20��
![ͼƬ](https://javaguide.cn/assets/concurrency-consistency-issues-dirty-reading-ee15b0b9.png)

#### ��ʧ�޸�
��һ�������ȡһ������ʱ����һ������Ҳ�����˸����ݣ���ô�ڵ�һ�������޸���������ݺ󣬵ڶ�������Ҳ�޸���������ݣ�������һ�������ڵ��޸Ľ���ͱ���ʧ
���磺���� 1 ��ȡĳ���е����� A=20������ 2 Ҳ��ȡ A=20������ 1 ���޸� A=A-1������ 2 ����Ҳ�޸� A=A-1�����ս�� A=19������ 1 ���޸ı���ʧ��
![ͼƬ](https://javaguide.cn/assets/concurrency-consistency-issues-missing-modifications-5b2e2bd8.png)

#### �����ظ���
ָ��һ�������ڶ�ζ�ͬһ���ݣ����������û�н���ʱ����һ������Ҳ�����˸����ݡ���ô���ڵ�һ����������ζ�����֮�䣬���ڵڶ���������޸ĵ��µ�һ���������ζ�ȡ�����ݿ��ܲ�̫һ������ͷ�������һ�����������ζ����������ǲ�һ�������
���磺���� 1 ��ȡĳ���е����� A=20������ 2 Ҳ��ȡ A=20������ 1 �޸� A=A-1������ 2 �ٴζ�ȡ A =19����ʱ��ȡ�Ľ���͵�һ�ζ�ȡ�Ľ����ͬ��

#### �ö�
�ö��Ͳ����ظ������ƣ���������һ�������ȡ�˼������ݣ�������һ���������������һЩ����ʱ�������Ĳ�ѯ�У���һ������ͻᷢ�ֶ���һЩԭ�������ڵļ�¼���ͺ������˻þ�һ�������Գ�Ϊ�ö�
���磺���� 2 ��ȡĳ����Χ�����ݣ����� 1 �������Χ�������µ����ݣ����� 2 �ٴζ�ȡ�����Χ�����ݷ�������ڵ�һ�ζ�ȡ�Ľ�������µ����ݡ�

### �����ظ����ͻö�������
* �����ظ������ص��������޸Ļ��¼���ٱ����ζ�ȡһ����¼��������ĳЩ��¼��ֵ���޸�
* �ö����ص����ڼ�¼����������ִ��ͬһ����ѯʱ�����ֲ鵽�ļ�¼������

�ö����Կ��������ظ�����һ��������������������ֻö���ԭ���ǽ���ö��Ͳ����ظ����ķ�����һ��
�ٸ����ӣ�ִ�� delete �� update ������ʱ�򣬿���ֱ�ӶԼ�¼��������֤����ȫ����ִ�� insert ������ʱ�����ڼ�¼����Record Lock��ֻ����ס�Ѿ����ڵļ�¼��Ϊ�˱�������¼�¼����Ҫ������϶����Gap Lock����Ҳ����˵ִ�� insert ������ʱ����Ҫ���� Next-Key Lock��Record Lock+Gap Lock�� ���м�������֤�����ֻö���

### ��������Ŀ��Ʒ�ʽ����Щ
mysql�в�������Ŀ��Ʒ�ʽ�����֣�����MVCC�������Կ����Ǳ��ۿ��Ƶ�ģʽ����汾�������ƣ�MVCC�����Կ������ֹۿ��Ƶ�ģʽ
�����Ʒ�ʽ�»�ͨ��������ʾ���ƹ�����Դ������ͨ�������ֶΣ�mysql��Ҫͨ����д����ʵ�ֲ�������
* ������(s��)���ֳƶ����������ڶ�ȡ��¼��ʱ���ȡ�������������������ͬʱ��ȡ�������ݣ�
* ������(x��)���ֳ�д��/��ռ�����������޸ļ�¼��ʱ���ȡ���������������������ͬʱ��ȡ�����һ����¼�Ѿ����������������������������ٶ�������¼���κ����͵������������ݣ�

��д�����������������У������޷�����д����дд���С����⣬���������ȵĲ�ͬ���ֱ���Ϊ���������м�����InnoDB����֧�ֱ�������Ҳ֧���м�����Ĭ��Ϊ�м������м����������ȸ�С��������صļ�¼�������ɣ���һ�л���м�¼�����������Զ��ڲ���д�������˵��InnoDB�����ܸ��ߡ������Ǳ����������м����������ڹ���������������

MVCC��mysql��ʵ�����������ֶ���Ҫ�ǣ������ֶΡ�read view��undo log
* undo log�����ڼ�¼ĳ�����ݵĶ���汾������
* read view�������ֶΣ������жϵ�ǰ�汾���ݵĿɼ���

### sql��׼��������Щ������뼶��
sql��׼�������ĸ����뼶��
read-uncommitted(��ȡδ�ύ)����͵ĸ��뼶��������ȡ��δ�ύ�����ݱ�������ܻᵼ������������ظ������ö�
read-committed(��ȡ���ύ)��������ȡ�Ĳ��������Ѿ��ύ�����ݣ�������ֹ��������ǲ����ظ����ͻö����п��ܷ���
repeatable-read(���ظ���)����ͬһ�ֶεĶ�ζ�ȡ�������һ�µģ��������ݱ��������Լ����޸ģ�������ֹ����Ͳ����ظ��������ö����п��ܷ���
serializable(�ɴ��л�)����ߵĸ��뼶����ȫ����acid�ĸ��뼶�����������������ִ�У���������֮�����ȫ�����ܲ������ţ����ü�����Է�ֹ�ö�������������ظ���

### mysql�ĸ��뼶���ǻ�����ʵ�ֵ���
mysql�ĸ��뼶���������MVCC���ƹ�ͬʵ�ֵ�
serializable���뼶����ͨ����ʵ�ֵģ�read-committed��repeatable-read���뼶���ǻ���MVCCʵ�ֵġ�������serializable֮����������뼶�����Ҳ��Ҫ�õ������ƣ�����repeatable-read�ڵ�ǰ���������Ҫʹ�ü���������֤������ֻö�

### mysql��Ĭ�ϸ��뼶����ʲô��
mysql InnoDB�洢�����Ĭ��֧�ֵĸ��뼶����repeatable-read���𣬿���ͨ��select @@tx_isolation;����鿴��8.0��������Ϊselect @@transaction_isolation;

## mysql��
����һ�ֳ����Ĳ�������Ŀ��Ʒ�ʽ

### ���������м�����ʲô����
MyISAM����֧�ֱ�������һ������һ�ű������ڲ���д����������ܺܲInnoDB����֧�ֱ�������Ҳ֧���м�����Ĭ��Ϊ�м���
�м��������ȸ�С��������صļ�¼�������ɣ����ԶԲ���д�������˵��InnoDB�����ܸ���
#### ���������м����Ա�
* ��������mysql��������������һ������ȫ�������⣩������Է������ֶμӵ������Ե�ǰ���������ű�������ʵ�ּ򵥣���Դ����Ҳ���٣������죬���������������������������ͻ�ĸ�����ߣ��߲�����Ч�ʼ��͡��������ʹ洢�����޹أ�MyISAM��InnoDB���涼֧�ֱ�����
* �м�����mysql������������С��һ����������������ֶμӵ�����ֻ��Ե�ǰ�������м�¼���м������м����ܴ��������ݿ�����ĳ�ͻ�������������С�������ȸߣ��������Ŀ���Ҳ��󣬼�������������������м����ʹ洢�����йأ����ڴ洢�������ʵ�ֵ�

### �м�����ʹ����ʲôע������
InnoDB����������������ֶμӵ���������������Է������ֶμӵ�����������ִ��delete��update���ʱ�����where�������ֶ�û������Ψһ������������ʧЧ�Ļ����ͻᵼ��ɨ��ȫ���Ա��е������м�¼���м�����
�����ܶ�ʱ��ʹʹ��������Ҳ�п��ܻ���ȫ��ɨ�裬����mysql�Ż�����ԭ��

### InnoDB���ļ�����
InnoDB������ͨ������������ҳ�ϵļ�¼����ʵ�ֵģ�mysql InnoDB֧��������������ʽ��
* ��¼�������ڵ����м�¼�ϵ���
* ��϶��������һ����Χ����������¼����
* �ټ�����record lock+gap lock������һ����Χ��������¼��������ҪĿ����Ϊ�˽���ö����⡣��¼��ֻ����ס�Ѿ����ڵļ�¼��Ϊ�˱�������¼�¼����Ҫ������϶��

��InnoDBĬ�ϵĸ��뼶��repeatable-read�£�����Ĭ��ʹ�õ���next-key lock�����ǣ����������������Ψһ������������InnoDB���next-key lock�����Ż������併��Ϊrecord lock��������ס���������������Ƿ�Χ��


### ��������������
�����Ǳ����������м����������ڹ�������s��������������x���������ࣺ
���������κ����������ݣ����������͹���������
����MVCC�Ĵ��ڣ�����һ���select��䣬InnoDB������κ���������ͨ������������ʾ�ӹ�������������
```
# ������ ������5.7��8.0��ʹ��
select ... lock in share mode;
# ������ ������8.0��ʹ��
select ... for share
# ������
select ... for update
```

### ��������ʲô��
�����Ҫ�õ������Ļ�������жϱ��еļ�¼û�������أ�һ��һ�еı�������̫�������Ҫ�õ�һ�����������Ķ����������ж��Ƿ���Զ�ĳ����ʹ�ñ���
�������Ǳ��������������֣�
* ����������is����������������Ա���ĳЩ��¼�ӹ��������ӹ�����ǰ�����øñ���is��
* ������������ix����������������Ա��е�ĳЩ��¼������������������ǰ�����øñ���ix��

�������������������Լ�ά���ģ��û��޷��ֶ���������������Ϊ�����мӹ���/������֮ǰ��InnoDB���Ȼ�ȡ���������������ݱ��Ķ�Ӧ������
������֮���ǻ�����ݵ�
�������͹����������������⣨����ָ���Ǳ�����Ĺ����������������������������м��Ĺ����������������⣩