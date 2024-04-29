

#对字段的操作：alter table 表名 add/drop/change/modify [column] ......

#添加字段：alter table 表名 add [column] 字段名 字段类型;
ALTER TABLE emp ADD COLUMN age INT;

#修改字段的名字: alter table 表名 change [column] 原字段名 新字段名 字段的类型;
ALTER TABLE emp CHANGE age age2 INT; #修改字段名
ALTER TABLE emp CHANGE age2 age2 INT;#修改字段类型

#修改字段的类型：alter table 表名 modify [column] 新字段类型;
ALTER TABLE emp MODIFY age2 VARCHAR(20);

#修改表的名字 : ALTER TABLE 原表名 RENAME TO 新表名;
ALTER TABLE student RENAME TO stu;


DESC emp;