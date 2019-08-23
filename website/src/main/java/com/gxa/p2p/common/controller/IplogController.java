package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ym
 * @Date: 2019/8/23 15:22
 * @Version 1.0
 */
@Controller
public class IplogController {

    @Autowired
    private IIplogService iIplogService;

    @RequestMapping("ipLog")
    public  String  JumpintoIplogPage(IplogQueryObject iplogQueryObject,Model model){
        model.addAttribute("pageResultSet",iIplogService.selectAll(iplogQueryObject));
    return "iplog_list";
    }
}
