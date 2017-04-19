package spring.beans.lifecycle;

/**
 * Created by zwb on 17/3/28.
 */
public class LifeCycle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("bean的setName方法");
        this.name = name;
    }

    public LifeCycle() {
        System.out.println("bean的constructor方法");
    }

    public void init(){
        System.out.println("bean的init方法");
    }

    public void destroy(){
        System.out.println("bean的destroy方法");
    }
}
