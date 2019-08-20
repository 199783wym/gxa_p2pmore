package com.gxa.p2p.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ym
 * @Date: 2019/8/20 10:06
 * @Version 1.0
 */
@Controller
public class AccountController {
    @RequestMapping("personal")
    public String personnal(){
        return "personal";
    }
}
