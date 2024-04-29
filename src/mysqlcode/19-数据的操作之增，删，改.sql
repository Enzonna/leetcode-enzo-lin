CREATE TABLE student(
id INT,
NAME VARCHAR(20),
age INT
);

#向表中插入单行数据: insert into 表名(字段名1,字段名2,......) values(值1，值2,......)
INSERT INTO student(id,NAME,age) VALUES(1,'longge',18);

#注意：如果插入的是全字段（给每个字段都插入值）那么表名后面的字段名可以省略不写
INSERT INTO student VALUES(2,'yuanyuan',20);

INSERT INTO student(id,age) VALUES(3,20);

#向表中插入多行数据：
#insert into 表名(字段名1,字段名2,......) values(值1，值2,......),(值1，值2,......),......
INSERT INTO student VALUES(4,'zhiling',20),(5,'reba',30);

/*
将查询的结果插入到表中

insert into 表名(字段名1，字段名2,.....)
select 字段名1，字段名2,....
......

注意：插入的字段和查询的字段的个数和类型要匹配。
*/
INSERT INTO student(id,NAME)
SELECT employee_id,first_name
FROM myemployees.`employees`
WHERE employee_id < 120;


#查看表结构
DESC myemployees.`employees`;


####===============================================================

#修改数据: update 表名 set 字段名1=值1,字段名2=值2,...... [where 过滤条件]

UPDATE student SET NAME='weige',age=56 WHERE id=3;
UPDATE student SET age = 18 WHERE id > 5;

UPDATE student SET age = 20;

####===============================================================

#删除数据：delete from 表名 [where 过滤条件]
DELETE FROM student WHERE id=5;
DELETE FROM student WHERE id>=100;
DELETE FROM student;




