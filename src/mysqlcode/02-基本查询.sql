
#可以理解成输出语句
SELECT 1+1;

SELECT 2+1
FROM DUAL;#dual是一张虚拟表（伪表）这个可以省略不写

#注意：任意类型的数据和null做运算结果为null
SELECT 1+NULL;
SELECT "a"+NULL;

SELECT "a"+2;#不是字符串拼接，就是加法运算。a无法转换成数值所以用0替代
SELECT CONCAT("a",2);#字符串拼接


/*
字段的别名：
格式：
	select 字段名1 as 别名1,字段名2 别名2,......
	from 表名;
	
注意：如果别名中间有空格需要使用双引号，单引号或飘号引起来。
*/
SELECT salary,salary+1000,salary  #注意：salary+1000没有修改原表中的数据
FROM employees;

#给字段起别名
SELECT salary+1000 AS new_salary,
	salary+2000 new_salaray2,
	salary+1 "new salary", #别名中间不要出现空格
	salary+2 'new salary2',
	salary+3 `new salary3`,
	salary+4 薪水 
FROM employees;







