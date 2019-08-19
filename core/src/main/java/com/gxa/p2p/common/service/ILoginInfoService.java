package com.gxa.p2p.common.service;

/**
 * @Author: ym
 * @Date: 2019/8/19 11:30
 * @Version 1.0
 */
public interface ILoginInfoService {
    int checkUsername(String usernmae);

    void register(String username, String password);

}
