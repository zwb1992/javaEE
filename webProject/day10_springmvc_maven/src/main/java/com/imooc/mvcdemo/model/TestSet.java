package com.imooc.mvcdemo.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by zwb on 17/4/25.
 * 传递set集合是，必须先初始化，这时set容器大小就固定了
 */
public class TestSet {
    private Set<Test1> test1s;

    public TestSet(){
        test1s = new LinkedHashSet<Test1>();
        test1s.add(new Test1());
        test1s.add(new Test1());
    }

    public Set<Test1> getTest1s() {
        return test1s;
    }

    public void setTest1s(Set<Test1> test1s) {
        this.test1s = test1s;
    }

    @Override
    public String toString() {
        return "TestSet{" +
                "test1s=" + test1s +
                '}';
    }
}
