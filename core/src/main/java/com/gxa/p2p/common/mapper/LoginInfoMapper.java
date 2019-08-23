package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import org.apache.ibatis.annotations.Param;

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

    LoginInfo selectLoiginInfoByUsername(@Param("username")String usernam,
                                         @Param("password")String password,
                                         @Param("usertype")int usertype);

    /**
     * 查询数据的数量
     *
     * @return
     */
    int queryForCount();


    /**
     * 查询当前页数据（分页查询）
     *
     * @return
     */
    List<LoginInfo> queryForPage(LoginInfoQueryObject loginInfoQueryObject);

}