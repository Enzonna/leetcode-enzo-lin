
/*
	distinct : 去重
	格式：
	   distinct 字段名1，字段名2,.......
*/
#需求:查询员工所在的部门有哪些
SELECT DISTINCT department_id
FROM employees
WHERE department_id IS NOT NULL


SELECT DISTINCT department_id, job_id #两个字段都一样再去重
FROM employees
WHERE department_id IS NOT NULL


#语法上错误
SELECT DISTINCT department_id,DISTINCT job_id 
FROM employees
WHERE department_id IS NOT NULL
