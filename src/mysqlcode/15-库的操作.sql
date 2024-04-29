
#查看所有的库
SHOW DATABASES;

#选库
USE 库名;
USE mysql;

#创建库：create database [if not exists] 库名 [character set '编码集']
CREATE DATABASE db1;
#[if not exists]  :如果库不存在则创建 存在则不创建。如果没有该字段库在则报错。
CREATE DATABASE IF NOT EXISTS db2;
#[character set '编码集'] ：指定库的编码集
CREATE DATABASE db3 CHARACTER SET 'gbk';


#修改库的编码集 : alter database 库名 character set '编码集';
ALTER DATABASE db3 CHARACTER SET 'utf8';

#查看库的信息
/*
  mysql8之前编码集utf8长度为3个字节(utf8mb3)
  mysql8开始utf8编码集变成了utf8mb4(utf8编码集长度为4个字节)
  注意：默认的utf8是utf8mb3
*/
SHOW CREATE DATABASE db3;


#删除库 : drop database [if exists] 库名
DROP DATABASE db3;
#[if exists] : 如果库存在则删除不存在则不删。如果没有该字段 库不存在则报错。
DROP DATABASE IF EXISTS db3;
