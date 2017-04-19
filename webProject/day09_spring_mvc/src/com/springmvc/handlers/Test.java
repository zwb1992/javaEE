package com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zwb on 17/4/14.
 */
@Controller
@RequestMapping("/test")
public class Test {


    @RequestMapping("/hello")
    public String hello(){
        System.out.print("test hello");
        return "success";
    }
}
