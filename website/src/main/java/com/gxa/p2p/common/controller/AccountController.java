package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ym
 * @Date: 2019/8/20 10:06
 * @Version 1.0
 */
@Controller
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IUserinfoService iUserinfoService;

    @RequestMapping("personal")
    public String personnal(Model model){
        LoginInfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo",loginInfo);
        Account account =iAccountService.selectAccountById(loginInfo.getId().intValue());
        Userinfo userinfo=iUserinfoService.getUserinfo(loginInfo.getId().intValue());
        model.addAttribute("account",account);
        model.addAttribute("userinfo",userinfo);
        return "personal";
    }
}
