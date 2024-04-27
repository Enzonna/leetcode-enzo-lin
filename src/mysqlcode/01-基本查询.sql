#单行注释
-- 单行注释（注意--后面一定要有一个空格）

#注意：每条sql语句的最后要以分号结尾
#查看所有的库 
SHOW DATABASES;

-- 选库
-- 格式：use 库名;
USE myemployees;


#查看库中所有的表
SHOW TABLES;

/*
多行注释

查看表中的内容：
格式： 
select 字段名1,字段名2,......
from 表名;

查看表中所有的字段
select *
from 表名
*/
SELECT first_name,salary FROM employees;

SELECT first_name,salary 
FROM employees;

#查看表中所有的字段
SELECT *
FROM employees;




