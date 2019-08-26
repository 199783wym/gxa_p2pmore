package com.gxa.p2p.common.service;

/**
 * @Author: ym
 * @Date: 2019/8/26 11:16
 * @Version 1.0
 */
public interface IVerifyCodeService {
    void sendVerifyCode(String phoneNumber);

    boolean validate(String phoneNumber, String verifyCode);
}
