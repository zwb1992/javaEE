package spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.annotation.controller.UserController;
import spring.beans.annotation.repository.UserRepositoryImpl;
import spring.beans.annotation.service.UserService;

/**
 * Created by zwb on 17/3/28.
 * 使用注解配置bean
 */
public class MainAnnotation {

    public static void main(String[] args){
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-annotation.xml");

        TestObject testObject = (TestObject)acx.getBean("testObject");
        System.out.println(testObject);

        UserRepositoryImpl userRepository = (UserRepositoryImpl)acx.getBean("userRepository");
        System.out.println(userRepository);
        userRepository.say();

//        UserService userService = (UserService)acx.getBean("userService");
//        System.out.println(userService);
//
//        UserController userController = (UserController)acx.getBean("userController");
//        System.out.println(userController);

    }

}
