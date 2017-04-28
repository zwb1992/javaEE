package com.imooc.mvcdemo.model;

import java.util.List;

/**
 * Created by zwb on 17/4/25.
 * 测试传递list集合
 */

public class TestList {
    List<Test1> test1s;

    public List<Test1> getTest1s() {
        return test1s;
    }

    public void setTest1s(List<Test1> test1s) {
        this.test1s = test1s;
    }

    @Override
    public String toString() {
        return "TestList{" +
                "test1s=" + test1s +
                '}';
    }
}
