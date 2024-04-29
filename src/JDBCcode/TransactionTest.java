package JDBCcode;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

/*
演示：
    1.没有使用事务 - 正常转账
    2.没有使用事务 - 一个成功一个失败
    3.使用了事务 - 正常转账
    4.使用了事务 - 演示一个成功一个失败

 */
public class TransactionTest {
    public static void main(String[] args) throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        String sql = "update account set balance=? where name=?";

        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);

        try {
            //开启事务
            connection.setAutoCommit(false);

            //aa减去1000
            //给占位符赋值
            ps.setInt(1, 1000);
            ps.setString(2, "aa");
            //执行sql语句
            ps.executeUpdate();

            System.out.println(1 / 0);

            //cc加1000
            ps.setInt(1, 3000);
            ps.setString(2, "cc");
            //执行sql语句
            ps.executeUpdate();

            //事务提交
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();//打印异常
            //事务回滚
            connection.rollback();
        }finally {
            //4.关闭资源
            //关闭事务
            connection.setAutoCommit(true);
            //关闭资源
            JDBCUtils.close(ps,connection);
        }



    }
}















