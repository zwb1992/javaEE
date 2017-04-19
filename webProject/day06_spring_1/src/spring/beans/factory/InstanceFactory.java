package spring.beans.factory;

import java.util.HashMap;

/**
 * Created by zwb on 17/3/28.
 * 通过实例化工厂方法配置bean
 */
public class InstanceFactory {

    private HashMap<String, Car> map;

    public InstanceFactory() {
        map = new HashMap<>();
        map.put("audi", new Car("audi", 1234, "黑色 "));
        map.put("baoma", new Car("baoma", 3333, "白色 "));
    }

    public Car getCar(String name) {
        return map.get(name);
    }
}
