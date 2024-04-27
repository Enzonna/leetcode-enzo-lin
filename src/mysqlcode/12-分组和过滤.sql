/*
格式：
select 字段名1,字段名2,.......
from 表名
where 过滤条件
group by 字段名1,字段名2,.....
having 过滤条件
order by 字段名1 asc/desc,字段名2 asc/desc,......

where和having的区别？
1.where在分组前过滤。having是在分组后过滤。
2.where后面不可以用组函数。having后面可以用组函数。
3.如果没有分组(group by)不要使用having进行过滤用where
*/
/*
#注意：select后面一旦出现组函数（聚合函数，分组函数）就不能再出现其它字段。
#	除非该字段在group by的后面
*/
#需求：查询各部门平均薪水-没有部门的不要。
SELECT department_id,AVG(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id; #按照部门分组

#需求：查询50号部门不同工种的最高薪水
SELECT job_id,MAX(salary)
FROM employees
WHERE department_id = 50
GROUP BY job_id;

#需求：查询不同部门不同工种的最低薪水是多少
SELECT department_id,job_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id,job_id;


#需求：查询不同部门不同工种的最低薪水是多少并按照最低薪水排序-升序
SELECT department_id,job_id,MIN(salary) min_salary
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id,job_id
ORDER BY min_salary ASC;


#需求：查询各部门的平均薪水 并且只要平均薪水大于5000的部门
SELECT department_id,AVG(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary) > 5000; #最好不要用别名-和hive有关系

SELECT department_id,AVG(salary) avg_sal
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING avg_sal > 5000;


#需求：查询各部门最高薪水 部门为null的不要
#方式一：效率高-能放在where后面过滤的尽量放在where后面过滤掉
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id;

#方式二：
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
HAVING department_id IS NOT NULL;



#需求：查询各部门的平均薪水 并且只要平均薪水大于5000的部门
#该方式效率高
SELECT department_id,AVG(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary) > 5000; #注意：AVG(salary)是在后组后得到的 所以要对此字段过滤只能在分组后过滤


SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id IS NOT NULL AND AVG(salary) > 5000;





