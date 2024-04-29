
CREATE TABLE student(
id INT,
gender CHAR,
NAME VARCHAR(20),
score DOUBLE(5,2),# 5=整数位+小数位 2=小数位 (如果插入的值超过了小数位的长度会四舍五入)
syear DATE
);

INSERT INTO student(id,gender,NAME,score,syear) VALUES(1,'男','小龙哥',23.356,'2023-12-10 11:11:11');

