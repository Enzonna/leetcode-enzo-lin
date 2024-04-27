
/*
子查询：在一条查询语句a中再嵌套一条查询语句b。那么b语句叫作子查询（内查询）a语句叫作主查询（外查询）

子查询的分类：单行子查询 vs 多行子查询
	单行子查询：子查询返回的结果只有一条。
	多行子查询：子查询返回的结果有多条
	
单行子查询所使用运算符 ：> >= < <= = <>
多行子查询所使用运算符: in any all	


子查询是由内向往去写。
*/


#需求:谁的工资比 Abel 高?
#方式一：
#1.先查询Abel工资
SELECT salary
FROM employees
WHERE last_name='Abel'; #11000
#2.查询比11000高的薪水的员工信息
SELECT last_name,salary
FROM employees
WHERE salary > 11000;

#方式二：多表查询
SELECT e1.`last_name`,e1.`salary`
FROM employees e1 JOIN employees e2
ON e1.`salary` > e2.`salary` AND e2.`last_name`='Abel';

#方式三：子查询
SELECT last_name,salary
FROM employees
WHERE salary > (
	#单行子查询：子查询结回的结果只有一条
	#注意：子查询查询的结果只能有一个字段
	SELECT salary
	FROM employees
	WHERE last_name='Abel'
);

#===================================================

#题目：返回job_id与141号员工相同，salary比143号员工多的员工
#            姓名，job_id 和工资
#方式一：
#1.查询141号员工的job_id
SELECT job_id
FROM employees
WHERE employee_id=141;#ST_CLERK
#2.查询143号员工的薪水
SELECT salary
FROM employees
WHERE employee_id=143;#2600
#3.查询job_id为ST_CLERK薪水比2600高的员工信息
SELECT first_name,job_id,salary
FROM employees
WHERE job_id='ST_CLERK' AND salary>2600;

#方式二：子查询
SELECT first_name,job_id,salary
FROM employees
WHERE job_id=(
	SELECT job_id
	FROM employees
	WHERE employee_id=141
) AND salary>(
	SELECT salary
	FROM employees
	WHERE employee_id=143
);

#==================================================

#题目：返回公司工资最少的员工的last_name,job_id和salary
#方式一
#1.最少工资是多少
SELECT MIN(salary)
FROM employees; #2100
#2.查询工资为2100的员工信息
SELECT last_name,job_id,salary
FROM employees
WHERE salary=2100;

#方式二:
#2.查找最低薪水的员工信息
SELECT last_name,job_id,salary
FROM employees
WHERE salary=(
	#1.先查找最低薪水
	SELECT MIN(salary)
	FROM employees
);
/*
#注意：下面的写法不对
SELECT last_name,job_id,salary
FROM employees
WHERE salary=min(salary) #where后面不要使用组函数
*/

#===========================================================

#题目：查询最低工资大于50号部门最低工资的部门id和其最低工资

#2.查询各部门最低工资比2100低的
SELECT department_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING MIN(salary) > (
	#1.查询50号部门最低工资
	SELECT MIN(salary)
	FROM employees
	WHERE department_id=50
);



#注意：子查询返回的是一个空值（不是null）不是错误只不过是没有查询到匹配的内容。
SELECT first_name,job_id,salary
FROM employees
WHERE job_id=(
	SELECT job_id
	FROM employees
	WHERE employee_id=1410
);

#================================================================

#下面的sql语句会报错
SELECT first_name
FROM employees
WHERE salary > ( #子查询返回的结果为多条数据 但是使用的运算符是单行子查询使用的运算符
	SELECT salary
	FROM employees
	WHERE department_id = 50
);


#需求：返回其它部门中比job_id为‘IT_PROG’部门任一工资低的员工的员
#              工号、姓名、job_id 以及salary
#2.查询其它工种员工的薪水比工种为IT_PROG的员工的薪水任意一个低
SELECT employee_id,first_name,job_id,salary
FROM employees
WHERE salary <ANY(
	#1.查询工种为IT_PROG的员工的薪水
	SELECT DISTINCT salary
	FROM employees
	WHERE job_id='IT_PROG'
) AND job_id <> 'IT_PROG';


#题目：返回其它部门中比job_id为‘IT_PROG’部门所有工资都低的员工
 #           的员工号、姓名、job_id 以及salary
SELECT employee_id,first_name,job_id,salary
FROM employees
WHERE salary <ALL(
	#1.查询工种为IT_PROG的员工的薪水
	SELECT DISTINCT salary
	FROM employees
	WHERE job_id='IT_PROG'
) AND job_id <> 'IT_PROG';


























