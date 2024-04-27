#7. 查询工资比80号部门平均工资高的员工的员工号，姓名和工资。
SELECT employee_id,first_name,salary
FROM employees
WHERE salary > (
	#80号部门平均工资
	SELECT AVG(salary)
	FROM employees
	WHERE department_id=80
);


#10.查询姓名中包含f的员工的相同部门的员工有哪些
SELECT first_name,department_id
FROM employees
WHERE department_id IN(
	#查找姓名中包含f的员工所在的部门
	SELECT department_id
	FROM employees
	WHERE first_name LIKE '%f%'
);

#11.查询各工种最低员工薪水的薪水等级
SELECT t1.*,t2.grade
FROM(
	#查询各工种最低薪水
	SELECT job_id,MIN(salary) min_salary
	FROM employees
	GROUP BY job_id
) t1 JOIN job_grades t2
ON  t1.min_salary BETWEEN t2.lowest_sal AND t2.Highest_sal;





#12.查询各部门(没有部门不要)员工最高薪水的员工的信息。
SELECT t1.*,t2.`department_id`,t2.`salary`,t2.`first_name`
FROM(
	#查询各部门最高薪水
	SELECT department_id,MAX(salary) max_sal
	FROM employees
	WHERE department_id IS NOT NULL
	GROUP BY department_id
) t1 JOIN employees t2
ON t1.department_id = t2.`department_id` AND t1.max_sal = t2.`salary`;







#13.查询30号部门薪水最低的员工的邮箱是多少
SELECT t2.*
FROM(
	#查询号部门最低薪水
	SELECT MIN(salary) min_salary
	FROM employees
	WHERE department_id=30 #2500
) t1 JOIN employees t2
ON t1.min_salary=t2.`salary` AND t2.`department_id`= 30;


SELECT *
FROM employees
WHERE salary = (
	SELECT MIN(salary) min_salary
	FROM employees
	WHERE department_id=30
) AND department_id = 30;






