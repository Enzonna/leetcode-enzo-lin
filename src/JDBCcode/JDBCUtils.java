package JDBCcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String username;
    private static String password;
    private static String url;

    private static String driver;

    static {
        FileInputStream fis = null;//局部变量 静态代码块结束 局部变量在内存就没有了
        try {
            //1.读取配置文件中的内容
            //1.1创建Properties对象
            Properties pro = new Properties();
            //1.2创建流
            fis = new FileInputStream("jdbc.properties");
            //1.3加载流
            pro.load(fis);
            //1.4读取数据
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            url = pro.getProperty("url");
            driver = pro.getProperty("driver");
            //System.out.println(username + " " + password + " " + url + " " + driver);

        }catch (Exception e){
            e.printStackTrace();
            //让编译时异常转成运行时异常 -- 因为配置文件中的内容没有读取到下面获取Connection肯定失败
            //获取Connection失败操作数据库肯定失败
            throw new RuntimeException(e.getMessage());
        }finally {
            if (fis != null) {
                //1.5关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Connection getConnection(){
        try {
            //2.获取Connection对象
            //2.1 让Driver中的静态代码块执行
            Class.forName(driver);
            //2.2获取Connection对象
            Connection connection = DriverManager.getConnection(url, username, password);

            return connection;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /*
        关闭资源
     */
    public static void close(PreparedStatement ps, Connection connection) {
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*
        关闭资源
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection connection) {
        close(ps,connection);

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
