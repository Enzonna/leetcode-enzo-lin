
/*

注意：default 和not null只有列级约束
*/


#在创建表时添加表级约束

#主键
CREATE TABLE stu2(
id INT,
sid INT,
NAME VARCHAR(20),
#添加主键的表级约束 :CONSTRAINT 索引名 PRIMARY KEY(字段名1,字段名2,......)
CONSTRAINT stu2_id_sid PRIMARY KEY(id,sid)
);

DESC stu2;

INSERT INTO stu2(id,sid) VALUES(1,2);
INSERT INTO stu2(id,sid) VALUES(1,3);



#唯一
CREATE TABLE stu3(
#
id INT,
sid INT,
NAME VARCHAR(20),
#添加unique的表级约束 :CONSTRAINT 索引名 UNIQUE(字段名1,字段名2,......)
CONSTRAINT stu3_id_sid UNIQUE(id,sid)
);

DESC stu3;
INSERT INTO stu3(id,sid) VALUES(1,2);
INSERT INTO stu3(id,sid) VALUES(1,3);


#check
CREATE TABLE stu4(
id INT,
sid INT,
CHECK(id > 10 AND sid > 20)
);

INSERT INTO stu4(id,sid) VALUES(11,21);
INSERT INTO stu4(id,sid) VALUES(13,20);







