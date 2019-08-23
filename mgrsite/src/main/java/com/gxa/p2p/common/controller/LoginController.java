package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/23 10:39
 * @Version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username,
                             String password,
                            HttpServletRequest request) {
        JSONResult json = new JSONResult();
//        try {
//            iLoginInfoService.login(username, password);
//        } catch (RuntimeException re) {
//            json.setSuccess(false);
//            json.setMsg(re.getMessage());
//
            boolean flag =iLoginInfoService.login(username,password,request, LoginInfo.USER_MGR);
            if (flag){
                return json;
        } else {
                json.setSuccess(false);
            json.setMsg("登录失败");
        }
        return json;
    }

    @RequestMapping("index")
    public String index(){
        return "main";
    }

}
