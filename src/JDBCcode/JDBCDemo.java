package JDBCcode;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
    JDBC : Java提供的一套用来操作数据库的接口

    作用：用来通过Java代码操作数据库

    准备工作：
        1.数据库一定要可以正常使用
        2.数据库的账号和密码一定要正确
        3.添加驱动 - 将驱动包放入到当前工程/module下的lib中 然后右键- add as library
             注意：驱动包的版本和mysql的版本要能够匹配
        4.通过Driver接口获取Connection连接对象
 */
public class JDBCDemo {

    /*
        获取Connection对象方式一
     */
    @Test
    public void test() throws SQLException {
        /*
            多态： 接口的类型指向实现类的对象

            在同一个类中用到了不同包中相同名字的类、接口 这个时候就需要用到全类名

            全类名：包含包名在内的类的全名称
         */
        Driver driver = new com.mysql.cj.jdbc.Driver();

        /*
        connect(String url, java.util.Properties info)
            url : 数据库的连接地址
                jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC&参数2=值&参数3=值
                    jdbc:mysql: 协议
                    localhost : mysql所在的服务器的IP地址
                    3306 ：端口号
                    myemployees : 库名
                    serverTimezone=UTC : 给mysql传的参数 - 这个参数是设置时区

            info ：用来设置账号和密码
         */
        //mysql的连接地址
        String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
        //创建Properties对象
        //map是通过key获取值的
        Properties p = new Properties();
        p.setProperty("user","root");//账号 key不能随便写 （是一种约定   调用方法的 和 创建方法的不是同一批人）
        p.setProperty("password","123321");//密码 key不能随便写
        //调用connect方法获取Connection对象  有了Connection对象才可以操作数据库
        Connection connect = driver.connect(url, p);

        System.out.println(connect);
    }

    /*
        获取Connection对象方式二

        注意：我们的思路要由面向对象时如何造一个类及类中定义哪些类的成员
            变成 核心类库/第三方jar包 提供的类可以帮助我们做什么事情
     */
    @Test
    public void test2() throws SQLException {
        //1.创建Driver对象
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //2.将driver注册到DriverManager中 由DriverManager管理Driver
        //DriverManager中可以注册很多Driver
        DriverManager.registerDriver(driver);

        //3.通过DriverManager获取Connection对象
        String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url, "root", "123321");

        System.out.println(connection);
    }

    /*
       获取Connection对象方式二 的优化

        Driver类中的静态代码块
            static {
                 DriverManager.registerDriver(new Driver());
             }
    */
    @Test
    public void test3() throws Exception {

        //获取Class对象 - 触发类的初始化
        //目的就是为了让Driver类中的静态代码块执行
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.通过DriverManager获取Connection对象
        String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url, "root", "123321");

        System.out.println(connection);
    }
    @Test
    public void test4() throws ClassNotFoundException {
        Class.forName("com.atguigu.java.A");
    }

    
    /*
        最终版
     */
    @Test
    public void test5() throws Exception {
        //1.读取配置文件中的内容
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2创建流
        FileInputStream fis = new FileInputStream("jdbc.properties");
        //1.3加载流
        pro.load(fis);
        //1.4读取数据
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");
        System.out.println(username + " " + password + " " + url + " " + driver);
        //1.5关闭资源
        fis.close();

        //2.获取Connection对象
        //2.1 让Driver中的静态代码块执行
        Class.forName(driver);
        //2.2获取Connection对象
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

}

class A{
    static {
        System.out.println("A");
    }
}
