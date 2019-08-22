package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/21 15:10
 * @Version 1.0
 */
@Controller
public class UserInfoController {
    @Autowired
    IUserinfoService iUserinfoService;
    @RequestMapping("userInfo")
    public String userInfo(
            HttpServletRequest request,
            Model model){
        LoginInfo li=(LoginInfo)request.getSession().getAttribute("loginInfo");
        int id =li.getId().intValue();
        model.addAttribute("userinfo",iUserinfoService.getUserinfo(id));
        model.addAttribute("educationBackgrounds",iUserinfoService.getUserInformation("educationBackground"));
        model.addAttribute("incomeGrades",iUserinfoService.getUserInformation("incomeGrade"));
        model.addAttribute("marriages",iUserinfoService.getUserInformation("marriage"));
        model.addAttribute("kidCounts",iUserinfoService.getUserInformation("kidCount"));
        model.addAttribute("houseConditions",iUserinfoService.getUserInformation("houseCondition"));
//        model.addAttribute("userFileTypes",iUserinfoService.getUserInformation("userFileType"));
        return "userInfo";
    }
    @RequestMapping("userInfo_save")
    @ResponseBody
    public JSONResult userInfoSave(Userinfo userInfo) {

        JSONResult json = new JSONResult();
        try {
            iUserinfoService.updateBasicInfo(userInfo);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }



}
