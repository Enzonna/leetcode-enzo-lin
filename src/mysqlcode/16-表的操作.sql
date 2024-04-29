#查看所有的表
SHOW TABLES;

#查看表的字段信息
DESC person;

#查看表的信息
SHOW CREATE TABLE student;

/*
创建表：
方式一：
create table [if not exists] 表名(
字段名 字段类型,
字段名2 字段类型,
......
字段名n 字段类型  #注意：最后一个字段没有逗号除非该字段下面还有其它内容（约束）
) [character set '编码集']

注意：如果表没有指定编码集默认和库的编码集一致。
*/
CREATE TABLE person(
id INT,
NAME VARCHAR(23) #varchar是字符串类型
);

#IF NOT EXISTS :如果表不存在则创建 存在则不创建。如果没有该字段表存在则报错。
CREATE TABLE IF NOT EXISTS person(
id INT,
NAME VARCHAR(23) #varchar是字符串类型
);

CREATE TABLE student(
id INT,
NAME VARCHAR(23) #varchar是字符串类型
) CHARACTER SET 'utf8';#utf8默认是utf8mb3


#==================================================================
#创建表方式二（基于现有的表创建一张新表（没有数据）） ： 
#格式 ：create table [if not exists] 表名 like 表名-存在的表
CREATE TABLE emp LIKE student;  
CREATE TABLE emp2 LIKE myemployees.`employees`; #库名.表名 ：跨库


#==================================================================
/*
创建表方式三 ：将查询结果创建一张新表
create table [if not exists] 表名
as
select语句
*/
CREATE TABLE emp3
AS
SELECT employee_id,first_name,salary,job_id
FROM myemployees.`employees`
WHERE employee_id < 120;



#删除表 ：drop table [if exists] 表名;
DROP TABLE emp3;

#[if exists] :如果表存在则删除不存在则不删。如果没有该字段表不存在则报错。
DROP TABLE IF EXISTS emp3;



