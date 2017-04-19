package db;

import com.spring.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 17/3/20.
 */
public class GoodsDao {

    /**
     * 获取所有商品
     *
     * @return
     */
    public List<Good> getGoods() {
        List<Good> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = DbHelper.getConnection();
        String sql = "select * from goods;";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Good good = new Good();
                good.setId(resultSet.getInt("id"));
                good.setName(resultSet.getString("name"));
                good.setAddress(resultSet.getString("address"));
                good.setPrice(resultSet.getString("price"));
                good.setPhoto(resultSet.getString("photo"));
                list.add(good);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                resultSet = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
                statement = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据商品id获取某一商品
     *
     * @param id
     * @return
     */
    public Good getGoodById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = DbHelper.getConnection();
        String sql = "select * from goods WHERE id =?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Good good = new Good();
                good.setId(resultSet.getInt("id"));
                good.setName(resultSet.getString("name"));
                good.setAddress(resultSet.getString("address"));
                good.setPrice(resultSet.getString("price"));
                good.setPhoto(resultSet.getString("photo"));
                return good;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                resultSet = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
                statement = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取所有收藏的商品
     *
     * @return
     */
    public List<Good> getGoodsBySelected(String selection) {
        List<Good> list = new ArrayList<>();
        if (selection == null) {
            return list;
        }
        String[] str = selection.split("_");
        if (str == null || str.length == 0) {
            return list;
        }
        if (str.length > 5) {
            for (int i = str.length - 1; i >= str.length - 5; i--) {
                int id = Integer.parseInt(str[i]);
                Good good = getGoodById(id);
                if (good != null) {
                    list.add(good);
                }
            }
        } else {
            for (int i = str.length - 1; i >= 0; i--) {
                int id = Integer.parseInt(str[i]);
                Good good = getGoodById(id);
                if (good != null) {
                    list.add(good);
                }
            }
        }
        return list;
    }

}
