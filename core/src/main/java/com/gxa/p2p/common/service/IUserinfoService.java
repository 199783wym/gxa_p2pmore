package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;

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
}
