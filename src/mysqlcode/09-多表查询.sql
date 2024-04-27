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
	
sql99语法
	select 字段名1,字段名2,.....
	from 表名1 join/left join/right join/full join 表名2
	on 连接条件
	join/left join/right join/full join 表名3
	on 连接条件
	......
	where 过滤条件
	order by 字段名1 asc/desc,字段名2 asc/desc,......

*/
/*
用来说明select是字段名而非关键字
select `select` ,`from`
*/

#内连接：获取两张表中匹配的内容
#等值连接：连接的条件用的是等号
#非自连接：连接的表不是同一张表
#sql99语法
#需求：查询每个员工的姓名和所在的部门名称
SELECT e.`first_name`,d.`department_name`
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`;

#sql99语法
#需求：查询每个员工的姓名和所在的部门名称及部门所在的城市名称
SELECT e.`first_name`,d.`department_name`,l.`city`
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`;



#自连接：连接的表是同一张表
#需求：查询员工的名字及领导的名字
SELECT e1.`first_name` 员工名字,e2.`first_name` 领导的名字
FROM employees e1 JOIN employees e2   #e1当成员工表 e2当成领导表
ON e1.`manager_id`= e2.`employee_id`;

SELECT e2.`first_name` 员工的名字,e1.`first_name` 领导的姓名
FROM employees e1 JOIN employees e2 #e1当成领导表 e2当成员工表
ON e1.`employee_id` =  e2.`manager_id`;


#非等值连接：连接条件用的不是等号
#需求：查询员工的姓名，薪水和薪水等级
SELECT e.`first_name`,e.`salary`,j.`GRADE`
FROM employees e JOIN job_grades j
#on e.`salary` >= j.`LOWEST_SAL` and e.`salary` <= j.`HIGHEST_SAL`;
ON e.`salary` BETWEEN j.`LOWEST_SAL` AND j.`HIGHEST_SAL`;


#左外连接：除了两张表中匹配的内容外还包括左表中不匹配的内容
#需求：查询所有员工的姓名和他们的部门名称
SELECT e.`first_name`,e.`department_id`,d.`department_id`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;


#右外连接：除了两张表中匹配的内容外还包括右表中不匹配的内容
#需求：查询所有的部门名称及部门中的员工姓名
#注意：右外连接完全可以通过左外连接实现（只需要交换两张表的位置即可）
SELECT e.`first_name`,d.`department_name`
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;

#满外连接：除了两张表中匹配的内容还包括左表和右表中不匹配的内容
#mysql不支持（oracle支持）
/*
实现full join:

左外连接
union
右外连接;

union（去重）:将两张表的结果合成一张表。
union all(不去重):将两张表的结果合成一张表。
*/
#需求：查询所有的员工姓名及所有的部门名称（除了匹配的 还包括 没有部门的员工  及 没有员工的部门）
/*
使用union时要注意的点：
	1.union去重
	2.两张表合成一张表那么这两张表的字段的个数和类型要保持一致。
*/
SELECT e.`employee_id`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
UNION
SELECT e.`employee_id`,d.`department_name`
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;

#union all:不去重
SELECT e.`employee_id`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
UNION ALL
SELECT e.`employee_id`,d.`department_name`
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;


#注意：如果select后面是一个常量（字面量）那么每条数据后面都会加一个该值
SELECT employee_id,first_name,1
FROM employees;










