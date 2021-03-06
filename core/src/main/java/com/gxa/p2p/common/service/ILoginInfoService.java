package com.gxa.p2p.common.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/19 11:30
 * @Version 1.0
 */
public interface ILoginInfoService {
    int checkUsername(String usernmae);

    void register(String username, String password);

    boolean login(String username, String password, HttpServletRequest request, int usertype);
}
