
/*
过滤：
select 字段名1,字段名2,......
from 表名
where 过滤条件

注意：where必须在from的后面。
*/
#需求：查询部门号为50的员工有哪些
SELECT first_name,department_id
FROM employees
WHERE department_id=50; #注意：=不是赋值符号 是等于

#需求：查询员工Steven的信息
SELECT *
FROM employees
WHERE first_name="Steven";

#需求：查询员工StevenKing的信息
SELECT *
FROM employees
#where first_name='Steven' && last_name='King';
WHERE first_name='Steven' AND last_name='King'; #推荐and

#需求：查询除90号部门外其它部门的员工信息
SELECT *
FROM employees
#where department_id != 90;
WHERE department_id <> 90; #推荐 <>

#需求：查询奖金率是null的员工信息
SELECT first_name,commission_pct
FROM employees
WHERE commission_pct IS NULL;


#需求：查询奖金率不是null的员工信息
SELECT first_name,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

#需求：查询薪水在5000到8000之间的员工信息（包含边界）
SELECT first_name,salary
FROM employees
#where salary>=5000 and salary<=8000;
#BETWEEN...and...是包含边界
WHERE salary BETWEEN 5000 AND 8000;#相当于salary>=5000 and salary<=8000

/*
使用between...and...要注意的点
1.BETWEEN...and...是包含边界
2.between后面是小的值 and后面是大的值
*/
#下面的写法是错误的
SELECT first_name,salary
FROM employees
WHERE salary BETWEEN 8000 AND 5000;##相当于salary>=8000 and salary<=5000


#需求：查询薪水不在5000到8000之间的员工信息
SELECT first_name,salary
FROM employees
#where salary < 5000 || salary > 8000;
#where salary<5000 or salary>8000;#推荐使用or
WHERE salary NOT BETWEEN 5000 AND 8000;


#需求：查询部门号90和80号部门的员工信息
SELECT first_name,department_id
FROM employees
#where department_id=90 or department_id=80;
WHERE department_id IN(80,90);#department_id=90 or department_id=80


#需求：查询部门号除90和80号部门的员工信息
SELECT first_name,department_id
FROM employees
WHERE department_id NOT IN(80,90);




