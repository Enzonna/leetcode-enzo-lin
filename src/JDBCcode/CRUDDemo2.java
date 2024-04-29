package JDBCcode;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    查询表中的数据
 */
public class CRUDDemo2 {

    /*
        查询单行数据
     */
    @Test
    public void test() throws SQLException {
        //1.获取Connection
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        String sql = "select id,name,age from person where id = ?";

        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //给占位符赋值
        ps.setInt(1,3);

        //4.执行sql语句
        //ResultSet : 通过ResultSet获取查询的结果
        ResultSet rs = ps.executeQuery();

        while (rs.next()){ //next() : 判断是否有下一条数据
            //一次循环就是一条数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println(id + " " + name + " " + age);
        }

        //5.关闭资源
        JDBCUtils.close(rs,ps,connection);
    }


    /*
        查询多行数据
     */
    @Test
    public void test2() throws SQLException {
        //1.获取Connection
        Connection connection = JDBCUtils.getConnection();

        //2.写sql语句
        String sql = "select id,name,age from person";

        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);

        //4.执行sql语句
        //ResultSet : 通过ResultSet获取查询的结果
        ResultSet rs = ps.executeQuery();

        while (rs.next()){ //next() : 判断是否有下一条数据
            //一次循环就是一条数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println(id + " " + name + " " + age);
        }

        //5.关闭资源
        JDBCUtils.close(rs,ps,connection);
    }

    @Test
    public void test3() throws Exception {
        List<Person> person = getPerson();
        for (Person p : person) {
            System.out.println(p);
        }
    }

    /*
        自定义一个方法返回查询的结果

        体会万事万物皆对象
     */
    public List<Person> getPerson() throws Exception {
        //创建一个集合用来存放Person对象。一个Person对象就对应表中的一条数据
        List<Person> list = new ArrayList<>();

        Connection connection = JDBCUtils.getConnection();

        String sql = "select id,name,age from person";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            //将对象存放到集合中。一条数据就是一个对象
            list.add(new Person(id,name,age));
        }


        JDBCUtils.close(rs,ps,connection);

        return list;
    }

}


