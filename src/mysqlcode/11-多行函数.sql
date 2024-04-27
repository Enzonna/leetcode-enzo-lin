/*
AVG()：求平均数 
SUM()：求和
注意：只能对数值类型（整型，浮点型）的数据操作

MAX()：求最大值 
MIN() ：求最小值

COUNT() ：求数据的条数
*/
#需求：求员工薪水的总和，平均值，最高薪水，最低薪水
SELECT SUM(salary), AVG(salary), MAX(salary), MIN(salary)
FROM employees;

#注意：select后面一旦出现组函数（聚合函数，分组函数）就不能再出现其它字段。
#	除非该字段在group by的后面
/*
下面的写法都是错的
select first_name,avg(salary)
from employees;

select first_name,min(salary)
from  employees;

SELECT first_name,max(salary)
FROM  employees;
*/


/*
count(*) : 用来统计查询结果的数据的总条数。
count(字段名) ：用来统计查询结果中该字段不为null的有多少条数据
count(数值) : 理解成count(*)
	count(*):如果一条数据中所有字段全为null 不统计该条数据
	count(1):如果一条数据中所有字段全为null 统计该条数据
*/
#查询employees表中有多少条数据
SELECT COUNT(*)
FROM employees;

#查询50号部门有多少人
SELECT COUNT(*)
FROM employees
WHERE department_id = 50;


SELECT COUNT(employee_id), COUNT(commission_pct)
FROM employees;

#奖金率不为null的有多少人
SELECT COUNT(*)
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT COUNT(salary), COUNT(commission_pct)
FROM employees
WHERE department_id = 60;


SELECT first_name, salary, COUNT(2)
FROM employees;


#注意：avg在求平均值时有没有包括null? 不包括null
SELECT AVG(commission_pct), SUM(commission_pct) / 107, SUM(commission_pct) / 35
FROM employees;






