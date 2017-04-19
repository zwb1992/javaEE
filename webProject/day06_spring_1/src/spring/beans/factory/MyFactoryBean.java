package spring.beans.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zwb on 17/3/28.
 */
public class MyFactoryBean implements FactoryBean<Car>{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Car getObject() throws Exception {
        return new Car(name,500000,"黄色");
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
