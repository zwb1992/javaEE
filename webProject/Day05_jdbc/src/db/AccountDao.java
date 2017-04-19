package db;

import com.spring.AccountInfo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by zwb on 17/3/23.
 */
public class AccountDao {

    /**
     * 通过用户id获取用户信息
     *
     * @param id
     * @return
     */
    public static AccountInfo get(int id) {
        Connection connection = new DBCPUtil().getConnection();
        AccountInfo accountInfo = null;
        if (connection != null) {
            try {
                //使用存储过程
                CallableStatement statement = connection.prepareCall("call getAccount(?)");
                statement.setInt(1, id);
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    accountInfo = new AccountInfo();
                    accountInfo.setId(resultSet.getInt("id"));
                    accountInfo.setAccount(resultSet.getString("account"));
                    accountInfo.setAmount(resultSet.getDouble("amount"));
                    accountInfo.setCreate_at(resultSet.getDate("create_at"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return accountInfo;
    }

    /**
     * 更新金额信息
     *
     * @param a
     * @throws Exception
     */
    public static void update(AccountInfo a) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "update account_info set amount=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, a.getAmount());
        statement.setInt(2, a.getId());
        System.out.print(statement.toString());
        statement.execute();
    }

    /**
     * 更新金额信息
     * 使用dbcp数据库连接池
     * @param a
     * @throws Exception
     */
    public static void update(AccountInfo a, Connection connection) throws Exception {
        String sql = "update account_info set amount=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, a.getAmount());
        statement.setInt(2, a.getId());
        statement.execute();
    }

}
