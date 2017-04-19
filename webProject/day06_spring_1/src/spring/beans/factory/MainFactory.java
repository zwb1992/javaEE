package spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.lifecycle.LifeCycle;

import java.sql.SQLException;

/**
 * Created by zwb on 17/3/27.
 * 管理bean的生命周期
 */
public class MainFactory {

    public static void main(String[] args) throws SQLException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-factory.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Car car1 = (Car) applicationContext.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);
    }

}
