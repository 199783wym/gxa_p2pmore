package com.gxa.p2p.common.domain;

import lombok.Data;

@Data
public class LoginInfo {
    public static final byte STATE_NORMAL = 0;
    public static final int USER_MGR =0;
    public static final int USER_WEB=1;
    private int usertype=0;//用户类型（前台、后台）
    private Long id;

    private String username ;

    private String password;

    private Byte state;
    
    private Boolean admin;


}