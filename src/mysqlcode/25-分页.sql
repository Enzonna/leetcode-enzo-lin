
/*

limit 索引值,数据的条数

分页公式 ：(页数-1)*数据的条数，数据的条数
*/
#需求：查询表中的前十条数据
SELECT *
FROM employees
LIMIT 0,10;

#再拉取十条
SELECT *
FROM employees
LIMIT 10,10;

#再拉取十条
SELECT *
FROM employees
LIMIT 20,10;