package com.imooc.mvcdemo.controller;

import com.imooc.mvcdemo.model.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zwb on 17/4/25.
 */
@Controller
public class TestController {


    /**
     * 当两个对象的属性值相同时，使用@InitBinder来区分两个对象，传值得时候使用  test1.name&test2.name
     * @param test1
     * @param test2
     * @return
     */
    @ResponseBody
    @RequestMapping("/testObject")
    public String testObject(Test1 test1, Test2 test2){
        return "test1="+test1+",test2="+test2;
    }

    @InitBinder("test1")
    public void initTest1(WebDataBinder binder){
        binder.setFieldDefaultPrefix("test1.");
    }

    @InitBinder("test2")
    public void initTest2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("test2.");
    }

    /**
     * 传递list集合时，一定要用一个对象去包裹list集合
     * 传值如下：test1s[0].name="tom"&tests[20].name="jerry"  这个时候集合长度为21，切0-20中间的对象的参数全部为默认参数
     * @param testList
     * @return
     */
    @ResponseBody
    @RequestMapping("/testList")
    public String testList(TestList testList){
        return "testList="+testList.toString();
    }

    /**
     * 传递set集合时，一定要用一个对象去包裹set集合,且需要在构造函数里面先初始化
     * 传值如下：test1s[0].name="tom"&tests[1].name="jerry"  集合长度为初始化长度
     * @param testSet
     * @return
     */
    @ResponseBody
    @RequestMapping("/testSet")
    public String testSet(TestSet testSet){
        return "testSet="+testSet.toString();
    }

    /**
     * 传递map集合时，一定要用一个对象去包裹map集合
     * 传值如下：test1s['X'].name="tom"&tests['Y'].name="jerry"
     * @param testMap
     * @return
     */
    @ResponseBody
    @RequestMapping("/testMap")
    public String testMap(TestMap testMap){
        return "testMap="+testMap.toString();
    }

    /**
     * 使用@RequestBody来接收传递的json对象
     * @param test1
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public String testJson(@RequestBody Test1 test1){
        return "test1="+test1.toString();
    }

    @ResponseBody
    @RequestMapping("/testFormatter1")
    public String testFormatter(Date date1){
        return "date1="+date1.toString();
    }

    /**
     * 使用这种方式，是传递的字符串2017-12-12 转换成date类型
     * @param binder
     */
    @InitBinder("date1")
    public void initDate(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    /**
     * 使用全局配置
     * @param date2
     * @return
     */
    @ResponseBody
    @RequestMapping("/testFormatter2")
    public String testFormatter2(Date date2){
        return "date2="+date2.toString();
    }
}
