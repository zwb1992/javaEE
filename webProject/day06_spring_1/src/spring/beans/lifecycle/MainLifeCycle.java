package spring.beans.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;

/**
 * Created by zwb on 17/3/27.
 * 管理bean的生命周期
 */
public class MainLifeCycle {

    public static void main(String[] args) throws SQLException{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-lifecycle.xml");
        LifeCycle lifeCycle = (LifeCycle)applicationContext.getBean("lifeCycle");
        System.out.println(lifeCycle);
        applicationContext.close();
    }

}
