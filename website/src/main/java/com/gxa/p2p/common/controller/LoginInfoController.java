package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }
    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username,
                            String password,
                            HttpServletRequest request){
        JSONResult json = new JSONResult();
//        try {
//            iLoginInfoService.login(username, password);
//        } catch (RuntimeException re) {
//            json.setSuccess(false);
//            json.setMsg(re.getMessage());
//        }
        boolean flag =iLoginInfoService.login(username,password,request, LoginInfo.USER_WEB);
        if (flag){
        }
        else{
            json.setSuccess(false);
            json.setMsg("登录失败");
        }
        return json;

    }
}
