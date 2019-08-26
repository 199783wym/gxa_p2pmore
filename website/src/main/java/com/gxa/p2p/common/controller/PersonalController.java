package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JSONResult bindPhone(String phoneNumber, String verifyCode) {
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

}
