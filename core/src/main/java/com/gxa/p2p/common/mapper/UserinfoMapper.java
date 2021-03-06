package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Userinfo;
import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);

    int add(Userinfo userinfo);

    void update(Userinfo userInfo);
}