package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/21 15:20
 * @Version 1.0
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Override
    public List<Systemdictionaryitem> getedubg() {
        List<Systemdictionaryitem> list =systemdictionaryitemMapper.selectByEduBG();
        return list;
    }

    @Override
    public Userinfo getUserinfo(int id) {
        Userinfo userinfo=userinfoMapper.selectByPrimaryKey((long)id);
        return userinfo;
    }
}
