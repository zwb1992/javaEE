package spring.beans.factory;

import java.util.HashMap;

/**
 * Created by zwb on 17/3/28.
 * 通过静态工厂方法配置bean
 */
public class StaticBeanFactory {

    private static HashMap<String,Car> map = new HashMap<>();
    static {
        map.put("audi",new Car("audi",1234,"黑色 "));
        map.put("baoma",new Car("baoma",3333,"白色 "));
    }

    public static Car getCar(String name){
        return map.get(name);
    }
}
