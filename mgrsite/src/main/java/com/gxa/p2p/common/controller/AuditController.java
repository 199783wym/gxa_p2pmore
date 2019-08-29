package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.query.BorrowQueryObject;
import com.gxa.p2p.common.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ym
 * @Date: 2019/8/28 23:20
 * @Version 1.0
 */
@Controller
public class AuditController {
    @Autowired
    private IBorrowService iBorrowService;

    @RequestMapping("bidrequest_publishaudit_list")
    private String audit(Model model, BorrowQueryObject borrowQueryObject){
        model.addAttribute("pageResult",iBorrowService.queryForPage(borrowQueryObject));

        return "/bidrequest/publish_audit";
    };
}
