package com.springmvc.handlers;

import com.springmvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by zwb on 17/4/14.
 */
//这个属性是把model中的值放入Session域对象当中，value指定放入哪些名称相对的内容，types指定放入哪些类型相同的值
@SessionAttributes(value = {"names"},types = {String.class})
@Controller
public class HelloWorld {

    private static final String SUCCESS = "success";
    /**
     * 1,使用RequestMapping 来映射请求URL
     * 2,返回值会通过视图解析器解析成实际的物理视图，对于InternalResourceViewResolver会做如下的解析
     * 前缀：prefix + 返回值"success" + 后缀：suffix 得到实际的物理视图，然后做转发
     * /WEB-INF/views/success.jsp
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.print("say hello");
        return SUCCESS;
    }

    /**
     * 使用method指定请求方式
     * @return
     */
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.print("testMethod");
        return SUCCESS;
    }

    /**
     * params,header 支持简单的表达式
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeader",params = {"name","age!=10"},headers = {})
    public String testParamsAndHeader(){
        System.out.print("testParamsAndHeader");
        return SUCCESS;
    }

    @RequestMapping(value = "/testParamsAndHeader/*/abc",params = {"name","age!=10"},headers = {})
    public String testAntPath(){
        System.out.print("testParamsAndHeader");
        return SUCCESS;
    }

    /**
     * @PathVariable 可以映射URL中的占位符到目标方法参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.print("testPathVariable:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRestPost(){
        System.out.print("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("testRest GET:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRest Put:"+id);
        return SUCCESS;
    }

    /**
     * 将post请求转换成DELETE或者PUT请求是，请求必须携带一个name="_method"的隐藏，值为DELETE或者PUT
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("testRest DELETE:" + id);
        return SUCCESS;
    }

    /**
     * 用@RequestParam接收请求参数 required表示参数不是必须的，defaultValue表示参数的默认值
     * @param username
     * @param age
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age",required = false,defaultValue = "0") int age) {
        System.out.println("test RequestParam:username:" + username+",age="+age);
        return SUCCESS;
    }

    /**
     * @CookieValue 获取cookieId
     * @param sessionId
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue :sessionId:" + sessionId);
        return SUCCESS;
    }

    /**
     * springMVC会根据参数与pojo的属性名称自动匹配，支持级联属性，自动赋值
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo user:"+user.toString());
        return SUCCESS;
    }

    /**
     * 使用servlet源生api，支持一下类型
     * HttpServletRequest
     * HttpServletResponse
     * Local
     * OutputStream
     * InputStream
     * Writer
     * Reader
     * Principal
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletApi")
    public void testServletApi(HttpServletRequest request, HttpServletResponse response, Writer writer) throws IOException{
        System.out.println("testServletApi request:"+request+"，response："+response);
//        return SUCCESS;
        writer.write("{name:'zhangsan'}");
    }


    /**
     * springMVC会把ModelAndView中的Model中的数据放入request的域对象当中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time",new Date());
        System.out.println(modelAndView.getViewName());
        return modelAndView;
    }

    /**
     * springmvc会把map（也可以是Model或者ModelMap）中的值放入request的域对象当中
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("Tom","Jerry","Mike"));
        return SUCCESS;
    }

    /**
     * 被@ModelAttribute标记的方法，会在每个目标方法执行前被执行
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id" ,required = false) Integer id,Map<String,Object> map){
        System.out.println("ModelAttribute method:");
        if(id != null){
            User user = new User();
            user.setId(1);
            user.setUsername("tom");
            user.setPassword("123456");
            user.setEmail("tom@qq.com");
            System.out.println("从数据库获取的对象:"+user);
            map.put("user",user);
        }
    }

    /**
     * 执行步骤：
     * 1，执行@ModelAttribute方法，从数据库去取User对象，springmvc把它放入map中，键为：user
     * 2，springmvc把user从map中取出，并把表单传过来的值赋值给user对应的属性
     * 3，把最终得到的user对象传入给目标方法
     * 注意：键名必须与目标方法入参名称一致
     * @param user
     * @return
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改:"+user);
        return SUCCESS;
    }

}
