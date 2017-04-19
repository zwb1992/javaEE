package spring.beans.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zwb on 17/3/29.
 * 泛型依赖注入
 */
public class MainGeneric {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-generic.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.add();

        RoleService roleService = (RoleService)applicationContext.getBean("roleService");
        roleService.add();
    }
}
