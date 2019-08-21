package com.gxa.p2p.common.domain;

import lombok.Data;

@Data
public class LoginInfo {
    public static final byte STATE_NORMAL = 0;
    private Long id;

    private String username ;

    private String password;

    private Byte state;

    private Byte usertype;

    private Boolean admin;


}