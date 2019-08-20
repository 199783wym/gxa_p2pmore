package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Account;

/**
 * @Author: ym
 * @Date: 2019/8/20 15:25
 * @Version 1.0
 */
public interface IAccountService {
    Account selectAccountById(int id);
}
