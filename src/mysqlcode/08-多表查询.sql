/*
多表查询：当查询的多个字段不在同一张表时就需要用到多表查询。

连接条件分类：
	自连接 vs 非自连接
	内连接 vs 外连接
	等值连接 vs 非等值连接
	
连接语句分类 ：sql92语法和sql99语法


sql92语法
	select 表名.字段名1，表名.字段名2,...
	from 表1 表别名1，表2 表别名2,......
	where 连接条件

*/
#sql92语法
#需求：查询每个员工的姓名和所在的部门名称
SELECT first_name,department_name
FROM employees,departments
WHERE employees.department_id=departments.department_id;#连接条件

#sql92语法
#需求：查询每个员工的姓名,部门号和所在的部门名称
/*
  在多表查询中如果某一个字段只出现在某一张表中那么该字段前的表名可加可不加。
	如果某一个字段出现在多张表中那么该字段前面的表名必须加
  结论：在多表查询中字段名前最好加上表名因为效率高
*/
SELECT employees.first_name,departments.department_name,employees.department_id
FROM employees,departments
WHERE employees.department_id=departments.department_id;

#给表起别名
SELECT e.first_name,d.department_name,e.department_id
FROM employees e,departments d
WHERE e.department_id=d.department_id;

#缺少连接条件 发生了笛卡尔集错误
SELECT e.first_name,d.department_name
FROM employees e,departments d


#需求：查询每个员工的姓名，部门名称和部门所在城市的名称
SELECT e.first_name,d.department_name,l.city
FROM employees e,departments d,locations l
WHERE e.`department_id`=d.`department_id` AND d.`location_id`=l.location_id;




