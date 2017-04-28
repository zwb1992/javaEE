package com.imooc.mvcdemo.utils;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zwb on 17/4/25.
 * 定义全局的日期格式化==把一个String对象转换成另外一个对象
 */
public class MyDateFormatter implements Formatter<Date>{
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(s);
    }

    public String print(Date date, Locale locale) {
        return null;
    }
}
