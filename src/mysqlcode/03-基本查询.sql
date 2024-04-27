/*
注意：
1.SQL 语言大小写不敏感。 
2.SQL 可以写在一行或者多行
3.关键字不能被缩写也不能分行
4.各子句一般要分行写。
5.使用缩进提高语句的可读性。
*/
SELECT *
FROM employees;

SELECT * FROM  employees;

/*
错误的写法
se
lect * from employees

st * fr employees;
*/

SELECT *
FROM employees
WHERE salary > 2000
GROUP BY department_id
HAVING MAX(salary) > 3000
ORDER BY salary DESC;



SELECT 
	first_name,
	last_name,
	salary
FROM (
	SELECT *
	FROM  employees
);


