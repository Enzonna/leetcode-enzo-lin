
#需求：查询姓名中包含f的员工信息
SELECT first_name,last_name
FROM employees
WHERE first_name LIKE '%f%'; #%表示任意个数的任意字符

#需求：查询名字中第二个字符为d的员工信息
SELECT first_name
FROM employees
WHERE first_name LIKE '_d%';#_表示任意一个字符

#需求：查询名字中第二个字符为_的员工信息
SELECT first_name
FROM employees
WHERE first_name LIKE '_\_%';# \_转义字符表示内容为_

#替换转义字符
SELECT first_name
FROM employees
WHERE first_name LIKE '_$_%' ESCAPE '$'; #ESCAPE 指定某个字符为转义字符

#需求：查询名字中包含a又包含e的员工信息
#写法一
SELECT first_name
FROM employees
WHERE first_name LIKE '%a%e%' OR first_name LIKE '%e%a%';
#写法二
SELECT first_name
FROM employees
WHERE first_name LIKE '%a%' AND first_name LIKE '%e%';



