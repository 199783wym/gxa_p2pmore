package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/21 15:18
 * @Version 1.0
 */
public interface IUserinfoService {
    Userinfo getUserinfo(int id);
    List<Systemdictionaryitem> getUserInformation(String info);

    void updateBasicInfo(Userinfo userInfo);

    /**
     *
     * 用户绑定手机
     *  @param phoneNumber
     * @param verifyCode
     * @param request
     */
    void bindPhone(String phoneNumber, String verifyCode, HttpServletRequest request);

    /**
     * 绑定邮箱
     *
     * @param uuid
     */
    void bindEmail(String uuid);
    Userinfo getCurrentUserInfo(Long userinfo);
}
