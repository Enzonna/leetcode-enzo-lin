

CREATE TABLE emp(
id INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(20)
);

INSERT INTO emp(NAME) VALUES('a');

/*
外键约束

   1.先创建主表还是从表？先创建主表再创建从表
   2.插入数据时先往主表还是从表？先往主表中插入数据再往从表中插入数据
   3.删除数据时先删除主表还是从表？先删除从表再删除主表
*/

CREATE DATABASE d1;

#主表
CREATE TABLE dept(
dept_id INT AUTO_INCREMENT PRIMARY KEY,
dept_name VARCHAR(20)
);


#从表
CREATE TABLE emp(
emp_id INT AUTO_INCREMENT PRIMARY KEY,
last_name VARCHAR(15),
dept_id INT,
#外键约束：该员工的部门号必须是dept表中有的部门号
#格式:CONSTRAINT 索引名 FOREIGN KEY(本表中的字段名) REFERENCES 主表的表名(主表的字段名)
CONSTRAINT emp_dept_id_fk FOREIGN KEY(dept_id) REFERENCES dept(dept_id)
);

#插入数据：先往主表中插入数据再往从表中插入数据
INSERT INTO dept(dept_id,dept_name) VALUES(10,'IT');
INSERT INTO emp(last_name,dept_id) VALUES('longge',10);

#删除数据
DELETE FROM emp;
DELETE FROM dept;


#=====================================================

#级联删除 ：当我们删除部门表中的数据时该部门中所有的员工将被直接删除

#主表
CREATE TABLE dept2(
dept_id INT AUTO_INCREMENT PRIMARY KEY,
dept_name VARCHAR(20)
);


#从表
CREATE TABLE emp2(
emp_id INT AUTO_INCREMENT PRIMARY KEY,
last_name VARCHAR(15),
dept_id INT,
#ON DELETE CASCADE: 级联删除
CONSTRAINT emp2_dept_id_fk FOREIGN KEY(dept_id) REFERENCES dept2(dept_id) ON DELETE CASCADE
);

#级联删除--当我们删除10号部门时 10号部门中所有的员工也将被删除掉
DELETE FROM dept2 WHERE dept_id=10;

