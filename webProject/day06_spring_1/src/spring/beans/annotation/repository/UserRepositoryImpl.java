package spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring.beans.annotation.service.UserService;

/**
 * Created by zwb on 17/3/28.
 *
 */

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    //@Autowired 自动装配，IOC容器中有的，就自动赋值
    //required = false 可以允许该属性没有被IOC容器标识
    //@Qualifier 指定需要装配的bean的名字

    @Autowired(required = false)
    @Qualifier("userService")
    private UserService userService;

    @Override
    public void say() {
        System.out.println(userService);
    }
}
