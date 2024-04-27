/*
LOWER('SQL Course') ：将内容全部转成小写
UPPER('SQL Course') ：将内容全部转成大写
*/

SELECT LOWER('aAbBcC'),UPPER('aAbBcC');

SELECT LOWER(first_name),UPPER(last_name)
FROM employees;

/*
CONCAT('Hello', 'World') : 字符串拼接
SUBSTR('HelloWorld',1,5) : 截取子串 1是索引位置  5是内容的长度
	注意：索引是从1开始
LENGTH('HelloWorld') : 字符串的长度
INSTR('HelloWorld', 'W') : w在字符串中首次出现的位置-从左向右查找
LPAD(salary,10,'*') ：
	当字段的内容的长度不够10的时候用*补在左边补
RPAD(salary, 10, '*')：
	当字段的内容的长度不够10的时候用*补在右边补
TRIM('H' FROM 'HelloWorld') ：去除字符串两端指定的字符
REPLACE('abcd','b','m') : 将当前字符串中b替换成m
*/
SELECT CONCAT(first_name,last_name)
FROM employees;

SELECT SUBSTR('abcdef',2,2);

SELECT first_name,LENGTH(first_name)
FROM employees;

SELECT INSTR('abwccwc','w');

SELECT LPAD(first_name,10,"*"),RPAD(last_name,10,"*")
FROM employees;


SELECT TRIM('#' FROM '####a####c####');


SELECT REPLACE('abcdaaa','a','A');#mysql不区分大小写-关键字（sql语句） 数据（内容）是区分大小写的



/*
ROUND: 四舍五入
ROUND(45.926, 2)			45.93

TRUNCATE: 截断
TRUNCATE(45.926,0)      		45

MOD: 求余
MOD(1600, 300)		          100

*/
SELECT ROUND(45.926, 2),ROUND(45.926, 1),ROUND(45.926, 0),ROUND(45.926, -1);

SELECT TRUNCATE(45.926,2), TRUNCATE(45.926,1), TRUNCATE(45.926,0), TRUNCATE(45.926,-1);

#结果的正负和第一个参数的正负有关
SELECT MOD(3,2),MOD(-3,2),MOD(3,-2),MOD(-3,-2);


SELECT NOW();#当前日期和时间

SELECT VERSION(); #查看mysql版本

/*
ifnull(字段名,默认值)：如果字段的内容为null就用默认值替换
*/
#需求：查询所有员工的薪水（薪水+奖金）
SELECT first_name,salary,commission_pct,salary+salary*commission_pct#null参与运算
FROM employees;

SELECT first_name,salary,commission_pct,salary+salary*IFNULL(commission_pct,0)
FROM employees;


/*
case表达式：

格式1：
  case 字段名
	  when 值1 then 返回值1
	  when 值2 then 返回值2
	  when 值3 then 返回值3
	  else 返回值n
  end

格式2：
  case 
	  when 表达式1 then 返回值1
	  when 表达式2 then 返回值1
	  when 表达式3 then 返回值1
	  else 返回值n
  end	  
*/

#需求：练习：查询部门号为 10, 20, 30 的员工信息, 若部门号为 10, 则打印其工资的 1.1 倍, 
#	20 号部门, 则打印其工资的 1.2 倍, 30 号部门打印其工资的 1.3 倍数

SELECT first_name,department_id,salary,CASE department_id
					WHEN 10 THEN salary*1.1
					WHEN 20 THEN salary*1.2
					WHEN 30 THEN salary*1.3
					ELSE salary
					END "别名1"
FROM employees
WHERE department_id IN(10,20,30);



#需求：查询所有员工的姓名，薪水及描述信息（如果薪水大于10000输出会所嫩模，
#	小于10000输出下海干活 等于10000输出再接再厉）

SELECT first_name,salary,CASE 
			 WHEN salary>10000 THEN "会所嫩模"
			 WHEN salary<10000 THEN "下海干活"
			 ELSE "再接再厉"
			 END "别名"
FROM employees;			



