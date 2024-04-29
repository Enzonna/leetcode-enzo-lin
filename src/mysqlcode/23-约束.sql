

#创建表后添加约束

CREATE TABLE stu5(
id INT,
sid INT,
NAME VARCHAR(20),
age INT,
score DOUBLE(5,2)
);

/*
primary key
添加约束 : alter table 表名 add primary key (字段名)
修改约束 : alter table 表名 modify  字段名 类型 primary key
删除约束 : alter table 表名 drop primary key
*/
ALTER TABLE stu5 ADD PRIMARY KEY(id);
ALTER TABLE stu5 DROP PRIMARY KEY;
ALTER TABLE stu5 MODIFY id INT PRIMARY KEY;

DESC stu5;



/*
unique:
添加约束 : alter table 表名  add unique(字段名)
添加约束 : alter table 表名 add constraint  索引名 unique(字段名)
修改约束 ：alter table 表名 modify 字段名 类型  unique
删除约束 ：alter table 表名 drop index 索引名
*/
ALTER TABLE stu5 ADD UNIQUE(sid); #sid就是索引名
ALTER TABLE stu5 ADD CONSTRAINT stu5_age_name UNIQUE(age,NAME);
ALTER TABLE stu5 DROP INDEX stu5_age_name;
ALTER TABLE stu5 DROP INDEX sid;

DESC stu5;





