package spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zwb on 17/3/27.
 *
 */
public class Main_spel {

    public static void main(String[] args) throws SQLException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-spel.xml");
        Car car = (Car)applicationContext.getBean("car");
        System.out.println(car);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

    }

}
