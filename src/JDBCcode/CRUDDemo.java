package JDBCcode;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    对表中的数据进行增，删，改，查

    CREATE TABLE person(
    id INT,
    NAME VARCHAR(20),
    age INT
    );
 */
public class CRUDDemo {

    /*
        向表中添加数据
     */
    @Test
    public void insert() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        //? : 占位符
        String sql = "insert into person(id,name,age) values(?,?,?)";

        //3.预编译
        /*
            PreparedStatement的作用 ：①给占位符赋值 ②执行sql语句
         */
        PreparedStatement ps = connection.prepareStatement(sql);
        //3.1 给占位符赋值
        ps.setInt(1,100);// 1表示第几个占位符 100给占位符的赋值内容
        ps.setString(2,"longge");// 2表示第几个占位符 longge给占位符的赋值内容
        ps.setInt(3,18);

        //4 执行sql语句
        int result = ps.executeUpdate();//executeUpdate() : 用来执行增，删，改的操作
        System.out.println("共有" + result + "行受到影响");

        //5.关闭资源
       JDBCUtils.close(ps,connection);
    }

    /*
        修改表中数据
     */
    @Test
    public void update() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        //注意:具体的数据使用占位符  不是字段名用占位符
        String sql = "UPDATE person SET NAME=?,age=? WHERE id=?";

        //3.预编译
        /*
            PreparedStatement的作用 ：①给占位符赋值 ②执行sql语句
         */
        PreparedStatement ps = connection.prepareStatement(sql);
        //给占位符赋值
        ps.setString(1,"canglaoshi");
        ps.setInt(2,28);
        ps.setInt(3,1);

        //4.执行sql语句
        int result = ps.executeUpdate();
        System.out.println("共有" + result + "行受到影响");

        //5.关闭资源
        JDBCUtils.close(ps,connection);
    }

    /*
       删除表中数据
    */
    @Test
    public void delete() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        String sql = "delete from person";

        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);

        //4.执行sql语句
        int result = ps.executeUpdate();
        System.out.println("共有" + result + "行受到影响");

        //5.关闭资源
        JDBCUtils.close(ps,connection);
    }
}
