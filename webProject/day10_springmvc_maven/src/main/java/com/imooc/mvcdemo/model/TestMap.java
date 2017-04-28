package com.imooc.mvcdemo.model;

import java.util.Map;

/**
 * Created by zwb on 17/4/25.
 * 测试传递list集合
 */

public class TestMap {
    Map<String,Test1> test1s;

    public Map<String, Test1> getTest1s() {
        return test1s;
    }

    public void setTest1s(Map<String, Test1> test1s) {
        this.test1s = test1s;
    }

    @Override
    public String toString() {
        return "TestMap{" +
                "test1s=" + test1s +
                '}';
    }
}
