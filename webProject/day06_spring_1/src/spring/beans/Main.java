package spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zwb on 17/3/27.
 *
 */
public class Main {

    public static void main(String[] args) throws SQLException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.say();

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.toString());

        car = (Car) applicationContext.getBean("car1");
        System.out.println(car.toString());

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());

        person = (Person) applicationContext.getBean("person1");
        System.out.println(person.toString());

        person = (Person) applicationContext.getBean("person2");
        System.out.println(person.toString());

        //配置直接的继承
        applicationContext = new ClassPathXmlApplicationContext("beans-extends.xml");
        Car car1 = (Car) applicationContext.getBean("car");
        System.out.println(car1.toString());
        car1 = (Car) applicationContext.getBean("car1");
        System.out.println(car1.toString());

        person  = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //使用外部属性文件
        applicationContext = new ClassPathXmlApplicationContext("beans-properties.xml");
        DataSource ds = (DataSource) applicationContext.getBean("dateSource");
        System.out.println("mysql连接："+ds.getConnection());

    }

}
