package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ym
 * @Date: 2019/8/19 11:29
 * @Version 1.0
 */
@Controller
public class LoginInfoController {
    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        int count  = iLoginInfoService.checkUsername(username);
        return count <= 0;
    }
    @RequestMapping("hello")
    private void hello(){
        System.out.println("hello world");

    }
    @RequestMapping("register")
    @ResponseBody
    public JSONResult register(String username, String password) {
        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.register(username, password);
            System.out.println("username password succeed");
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }
    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username,String password){
        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.login(username, password);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }
}
