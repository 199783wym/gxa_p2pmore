package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.LoginInfo;
import java.util.List;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Long id);



    LoginInfo selectByPrimaryKey(Long id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);

    int selectCountByUsername(String username);

    /**
     * 新用户注册
     *
     * @param loginInfo
     *
     */
    int insert(LoginInfo loginInfo);

}