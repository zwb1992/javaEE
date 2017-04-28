package com.imooc.mvcdemo.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zwb on 17/4/25.
 * 把一个对象转换成另外一个对象
 */
public class MyDateConverter implements Converter<String,Date> {
    public Date convert(String s) {
        Date date;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(s);
        }catch (Exception e){
            return null;
        }
        return date;
    }
}
