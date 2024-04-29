
CREATE TABLE account(
NAME VARCHAR(20),
balance INT
);

/*
事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。

案例：AA给CC转账1000
     try{
	      开启事务
	      aa -= 1000;
	      System.out.println(1/0);
	      cc += 1000;
	      事务提交 - 一旦提交就不能回滚了
     }catch(Exception e){
	事务回滚
     }
发生的问题：一个成功  一个失败。
      
解决思路：将多个操作看成一个整体要么都成功要么都失败-不允许有成功有失败的。

注意：对数据的操作才可以使用事务
*/
#开启事务-方式一
SET autocommit=FALSE;
#开启事务-方式二(一旦commit或rollback事务自动结束)
START TRANSACTION;

#具体的操作
DELETE FROM account;

#事务提交-一旦提交将不能再回滚
COMMIT;

#事务回滚
ROLLBACK;

#关闭事务
SET autocommit=TRUE;


#=============================================================

/*
delete from 和 truncate table的区别？
1.delete from可以使用事务。truncate table不能使用事务。
2.如果可以确认删除的数据不需要回滚用truncate table效率高。
*/
START TRANSACTION;

#清空表中的内容
TRUNCATE TABLE account;


ROLLBACK;









