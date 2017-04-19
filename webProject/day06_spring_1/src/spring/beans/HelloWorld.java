package spring.beans;

/**
 * Created by zwb on 17/3/27.
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public void say(){
        System.out.println("hello:"+name);
    }
    public HelloWorld(){
        System.out.println("Constructor");
    }
}
