
/*
六种约束：
	NOT NULL 非空约束，规定某个字段不能为空
	UNIQUE  唯一约束，规定某个字段在整个表中是唯一的
	PRIMARY KEY  主键(非空且唯一)
	FOREIGN KEY  外键
	CHECK  检查约束
	DEFAULT  默认值
	
约束分类：列级约束 vs 表级约束

列级约束：同时只能约束一列
表级约束：同时可以约束多列

创建表时添加约束
	添加列级约束
	添加表级约束
	
创建表后添加约束（知道即可）
	添加列级约束
	添加表级约束
	
注意：default 和not null只有列级约束
*/

DROP TABLE p2;

#创建表时添加列级约束
CREATE TABLE stu(
id INT PRIMARY KEY,#主键约束 = 非空且唯一
sid INT UNIQUE, #唯一约束
NAME VARCHAR(20) NOT NULL, #非空约束
score INT CHECK(score > 60),#check约束
age INT DEFAULT 18 #默认约束
);

DESC stu;

INSERT INTO stu(id,sid,NAME,score,age) VALUES(1,1000,'a',70,20);
INSERT INTO stu(id,sid,NAME,score,age) VALUES(2,1001,'b',71,21);
INSERT INTO stu(id,sid,NAME,score,age) VALUES(3,1002,'c',72,22);
INSERT INTO stu(id,sid,NAME,score,age) VALUES(4,1003,'d',73,23);
INSERT INTO stu(id,sid,NAME,score,age) VALUES(5,1004,'e',61,25);
INSERT INTO stu(id,sid,NAME,score) VALUES(6,1005,'f',62);





