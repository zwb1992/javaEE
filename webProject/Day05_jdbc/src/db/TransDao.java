package db;

import com.spring.TransInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by zwb on 17/3/23.
 * 交易记录表
 */
public class TransDao {

    /**
     * 插入交易记录
     *
     * @param transInfo
     * @throws Exception
     */
    public static void insert1(TransInfo transInfo) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("call insertTransInfo(?,?,?,?)");
        statement.setInt(1, transInfo.getSource_id());
        statement.setString(2, transInfo.getSource_account());
        statement.setInt(3, transInfo.getDestination_id());
        statement.setString(4, transInfo.getDestination_account());
        statement.setDouble(5, transInfo.getAmount());
        statement.execute();

    }
    /**
     * 插入交易记录
     *
     * @param transInfo
     * @throws Exception
     */
    public static void insert(TransInfo transInfo) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO trans_info(source_id,source_account,destination_id,destination_account,amount) " +
                "VALUES (?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, transInfo.getSource_id());
        statement.setString(2, transInfo.getSource_account());
        statement.setInt(3, transInfo.getDestination_id());
        statement.setString(4, transInfo.getDestination_account());
        statement.setDouble(5, transInfo.getAmount());
        statement.execute();
    }

    /**
     * 插入交易记录
     * 使用数据库连接池
     *
     * @param transInfo
     * @throws Exception
     */
    public static void insert(TransInfo transInfo, Connection connection) throws Exception {
        String sql = "INSERT INTO trans_info(source_id,source_account,destination_id,destination_account,amount) " +
                "VALUES (?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, transInfo.getSource_id());
        statement.setString(2, transInfo.getSource_account());
        statement.setInt(3, transInfo.getDestination_id());
        statement.setString(4, transInfo.getDestination_account());
        statement.setDouble(5, transInfo.getAmount());
        statement.execute();
    }

}
