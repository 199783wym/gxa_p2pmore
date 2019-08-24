package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.service.IIplogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;

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
    public  String  JumpintoIplogPage(@Param("beginDate") String beginDate,
                                      @Param("endDate")String  endDate,
                                      @Param("state")Byte state,
                                      @Param("currentPage")Integer currentPage,
                                      Model model){
        IplogQueryObject iplogQueryObject=new IplogQueryObject();

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (beginDate != null) {
                iplogQueryObject.setBeginDate(format1.parse(beginDate));
                System.out.println(beginDate);
//            iplogQueryObject.setBeginDate(beginDate.);
            }
            if (endDate != null) {
                iplogQueryObject.setEndDate(format1.parse(endDate));
//            iplogQueryObject.setEndDate(endDate);

            }
            if (state != null) {
                iplogQueryObject.setState(state);

            }
            if(currentPage!=null){
                iplogQueryObject.setCurrentPage(currentPage);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("pageResultSet",iIplogService.selectIplog(iplogQueryObject));
        model.addAttribute("iplogQueryObject",iplogQueryObject);
    return "iplog_list";
    }
}
