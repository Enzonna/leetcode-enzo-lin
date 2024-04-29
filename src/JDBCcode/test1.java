package JDBCcode;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class test1 {


    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
        Properties p = new Properties();
        p.setProperty("user", "root");
        p.setProperty("password", "010320");

        Connection connect = driver.connect(url, p);
        System.out.println(connect);
    }

}
