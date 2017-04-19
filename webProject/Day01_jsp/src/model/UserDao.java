package model;

/**
 * Created by zwb on 17/3/16.
 */
public class UserDao {
    public boolean isLoginEd(UserBean userBean) {
        return "admin".equals(userBean.getUsername()) && "123456".equals(userBean.getPassword());
    }
}
