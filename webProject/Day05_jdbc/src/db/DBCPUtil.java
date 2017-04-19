package db;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by zwb on 17/3/23.
 * 使用dbcp数据库连接池来获取数据库
 */
public class DBCPUtil {

    //数据源
    private static DataSource DS;
    //配置文件
    private static final String configFile = "/dbcp.properties";

    /**
     * 获取数据库连接
     *
     * @return 返回数据库连接
     */
    public Connection getConnection() {
        Connection connection = null;
        if (DS != null) {
            try {
                connection = DS.getConnection();
                connection.setAutoCommit(false);//取消事务自动提交
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public DBCPUtil() {
        initDbcp();
    }

    /**
     * 初始化数据源
     */
    private void initDbcp() {
        Properties properties = new Properties();
        try {
            properties.load(Object.class.getResourceAsStream(configFile));
            DS = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
