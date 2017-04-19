package service;

import com.spring.AccountInfo;
import com.spring.TransInfo;
import db.AccountDao;
import db.DBCPUtil;
import db.DBUtil;
import db.TransDao;

import java.sql.Connection;

/**
 * Created by zwb on 17/3/23.
 *
 */
public class TransInfoService {

    /**
     * 要用同一个connection去操作数据库，否则会出现不一致的情况
     * @param from
     * @param to
     * @param amount
     * @return
     * @throws Exception
     */
    public static String trans(AccountInfo from,AccountInfo to,double amount) throws Exception{
        Connection connection = new DBUtil().getConnection();
        if(connection == null){
            return "failed";
        }
        try {
            connection.setAutoCommit(false);
            from.setAmount(from.getAmount()-amount);
            AccountDao.update(from);
//            int i = 10/0;
            to.setAmount(to.getAmount()+amount);
            AccountDao.update(to);
            TransInfo transInfo = new TransInfo();
            transInfo.setSource_id(from.getId());
            transInfo.setSource_account(from.getAccount());
            transInfo.setDestination_id(to.getId());
            transInfo.setDestination_account(to.getAccount());
            transInfo.setAmount(amount);
            TransDao.insert(transInfo);
            connection.commit();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
            return "failed";
        }
    }

    /**
     * DBCP
     * 要用同一个connection去操作数据库，否则会出现不一致的情况
     * @param from
     * @param to
     * @param amount
     * @return
     * @throws Exception
     */
    public static String transDBCP(AccountInfo from,AccountInfo to,double amount) throws Exception{
        Connection connection = new DBCPUtil().getConnection();
        if(connection == null){
            return "failed";
        }
        try {
            connection.setAutoCommit(false);
            from.setAmount(from.getAmount()-amount);
            AccountDao.update(from,connection);
//            int i = 10/0;
            to.setAmount(to.getAmount()+amount);
            AccountDao.update(to,connection);
            TransInfo transInfo = new TransInfo();
            transInfo.setSource_id(from.getId());
            transInfo.setSource_account(from.getAccount());
            transInfo.setDestination_id(to.getId());
            transInfo.setDestination_account(to.getAccount());
            transInfo.setAmount(amount);
            TransDao.insert(transInfo,connection);
            connection.commit();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
            return "failed";
        }
    }

    public static void main(String[] args) throws Exception{
        AccountInfo from = AccountDao.get(1);
        System.out.println("顾客："+from.toString());
        AccountInfo to = AccountDao.get(2);
        System.out.println("老板："+to.toString());
//        System.out.println("结果:"+trans(from,to,100));
        System.out.println("结果:"+transDBCP(from,to,50));
    }

}
