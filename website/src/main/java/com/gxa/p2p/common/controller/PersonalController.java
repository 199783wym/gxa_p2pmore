package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/26 11:45
 * @Version 1.0
 */
@Controller
public class PersonalController {

    @Autowired
    IUserinfoService iUserInfoService;
    /**
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public JSONResult bindPhone(String phoneNumber, String verifyCode, HttpServletRequest request) {
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode,request);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }
    @RequestMapping("bindEmail")
    public String bingEmail(String code, Model model) {
        System.out.println(code);
        try {
            iUserInfoService.bindEmail(code);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("success", false);
            model.addAttribute("msg", e.getMessage());
        }
        return "checkmail_result";
    }


}
