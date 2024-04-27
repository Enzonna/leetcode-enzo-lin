/*
select 字段名1，字段名2,......
from 表名
where 过滤条件
order by 字段名1 asc/desc,字段名2 asc/desc,........


说明：
	1.asc表示升序，desc表示降序
	2.如果order by后面的字段没有指定排序方式默认是升序
*/

#需求：查询所有员工的姓名和薪水并对薪水进行排序-升序
SELECT first_name,salary
FROM employees
ORDER BY salary ASC;

SELECT first_name,salary
FROM employees
ORDER BY salary;-- 注意：如果order by后面的字段没有指定排序方式默认是升序

#需求：查询50号部门所有员工的姓名，工种和薪水 并按照薪水排序-降序
SELECT department_id,first_name,job_id,salary
FROM employees
WHERE department_id=50
ORDER BY salary DESC;

#需求：对所有员工的薪水加1000 并对新的薪水进行排序-降序
SELECT salary,salary+1000 new_sal
FROM employees
ORDER BY new_sal DESC; -- order by后面可以使用别名


SELECT salary,salary+1000
FROM employees
ORDER BY `salary+1000` DESC; -- salary+1000是字段名

#需求：查询所有员工的姓名，薪水及部门号。要求按照部门号排序-降序 如果部门号相同再按照薪水排序-升序
SELECT first_name,department_id,salary
FROM employees
ORDER BY department_id DESC,salary ASC;









