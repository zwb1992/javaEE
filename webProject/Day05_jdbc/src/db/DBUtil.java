package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zwb on 17/3/23.
 * 使用jdbc来获取数据库连接
 */
public class DBUtil {
    private static final String driver = "com.mysql.jdbc.Driver";
    //连接MySql数据库，用户名和密码都是root
    private static final String url = "jdbc:mysql://localhost:3306/shopping";
    private static final String username = "root";
    private static final String password = "zwb3592031";

    private static Connection connection = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("找不到驱动程序类 ，加载驱动失败！");
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DBUtil.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(url, username, password);
                        System.out.println("数据库连接成功！");
                    } catch (SQLException se) {
                        System.out.println("数据库连接失败！");
                        se.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
