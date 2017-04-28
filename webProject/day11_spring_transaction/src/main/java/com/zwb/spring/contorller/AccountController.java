package com.zwb.spring.contorller;

import com.zwb.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zwb on 17/4/27.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 转账
     * @param from
     * @param to
     * @param money
     * @return
     */
    @RequestMapping(value = "/transfer",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String transfer(String from,String to,double money){
        accountService.transfer(from,to,money);
        String json = "{\"code\": 1,\"msg\": \"转账成功\"}";
        return json;
    }
}
