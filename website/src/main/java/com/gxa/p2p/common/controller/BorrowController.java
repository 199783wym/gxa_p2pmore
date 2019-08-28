package com.gxa.p2p.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ym
 * @Date: 2019/8/28 10:40
 * @Version 1.0
 */
@Controller
public class BorrowController {

    @RequestMapping("borrowInfo")
    private String borrowInfo(Model model){
        return "borrow_apply";
    }
}
