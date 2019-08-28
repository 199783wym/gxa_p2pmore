package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ym
 * @Date: 2019/8/20 15:26
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account selectAccountById(int id) {

        return accountMapper.selectByPrimaryKey(id);
    }
}
