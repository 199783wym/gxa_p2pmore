package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.LoginInfoMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/19 11:31
 * @Version 1.0
 */
@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper logininfoMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
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
    public boolean login(String username, String password, HttpServletRequest request, int usertype) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo = logininfoMapper.selectLoiginInfoByUsername(username,password,usertype);
        if(loginInfo!=null){
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
        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            logininfoMapper.insert(li);
            //添加account表
            Integer id=li.getId().intValue();
            Account account =new Account();
            account.setId(id);
            accountMapper.add(account);

            //添加userinfo表
            Userinfo userinfo = new Userinfo();
            userinfo.setId(li.getId());
            userinfo.setPhonenumber("15883670409");
            userinfoMapper.add(userinfo);

        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }

    }
}