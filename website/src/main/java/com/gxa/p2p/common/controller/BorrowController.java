package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.Bidrequest;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IBorrowService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: ym
 * @Date: 2019/8/28 10:40
 * @Version 1.0
 */
@Controller
public class BorrowController {
    @Autowired
    private IBorrowService iBorrowService;
    @Autowired
    private IAccountService iAccountService;

    @RequestMapping("borrowInfo")
    private String borrowInfo(Model model){
        model.addAttribute("minBidAmount",50);
        model.addAttribute("minBidRequestAmount",50);
        Account account = new Account();
        account=iAccountService.selectAccountById(UserContext.getLoginInfo().getId().intValue());
        model.addAttribute("account", account);

        return "borrow_apply";
    }

    @RequestMapping("borrow_apply")
    private String methodBorrowApply(Bidrequest bidrequest){
        bidrequest.setCreateuserId(UserContext.getLoginInfo().getId());
        bidrequest.setVersion(1);
        bidrequest.setBidrequesttype((byte)0);
        bidrequest.setBidrequeststate((byte)0);
        bidrequest.setBidcount(0);
        bidrequest.setTotalrewardamount(bidrequest.getCurrentrate().multiply(bidrequest.getBidrequestamount()).divide(new BigDecimal(100)));
        bidrequest.setCurrentsum(new BigDecimal(0));
        bidrequest.setApplytime(new Date());

        Calendar calendar =
                new GregorianCalendar();
        calendar.setTime(bidrequest.getApplytime()); //你自己的数据进行类型转换
        calendar.add(calendar.DATE,bidrequest.getDisabledays());//把日期往后增加一天.整数往后推,负数往前移动
        Date date=calendar.getTime();
        bidrequest.setDisabledate(date);
//createbidrequest
        iBorrowService.createbidrequest(bidrequest);
        return "borrow_apply_result";
    }
}
