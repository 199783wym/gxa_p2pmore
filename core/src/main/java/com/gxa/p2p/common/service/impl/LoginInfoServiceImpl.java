package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.mapper.LoginInfoMapper;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ym
 * @Date: 2019/8/19 11:31
 * @Version 1.0
 */
@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper logininfoMapper;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }

    @Override
    public boolean login(String username, String password) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo = logininfoMapper.selectLoiginInfoByUsername(username);
        if(loginInfo.getState()==0 && loginInfo.getPassword().equals(password)){
            UserContext.putLoginInfo(loginInfo);
            return true;
        }
        return false;

    }

    @Override
    public void register(String username, String password) {
        /*
         * 逻辑思路
         * 1. 判断用户名是否存在
         * 2. 如果不存在,设值并保存这个对象
         * 3. 如果存在,直接抛错
         *
         */
        int count = checkUsername(username);
        System.out.println("111");
        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            logininfoMapper.insert(li);
        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }

    }
}