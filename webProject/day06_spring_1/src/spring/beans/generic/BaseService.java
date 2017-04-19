package spring.beans.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zwb on 17/3/29.
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }
}
