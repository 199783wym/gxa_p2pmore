package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Bidrequest;
import java.util.List;

public interface BidrequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bidrequest record);

    Bidrequest selectByPrimaryKey(Long id);

    List<Bidrequest> selectAll();

    int updateByPrimaryKey(Bidrequest record);
}