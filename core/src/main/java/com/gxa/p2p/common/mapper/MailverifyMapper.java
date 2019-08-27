package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Mailverify;
import java.util.List;

public interface MailverifyMapper {
    Mailverify selectByUUID(String uuid);

    int deleteByPrimaryKey(Long id);

    int insert(Mailverify record);

    Mailverify selectByPrimaryKey(Long id);

    List<Mailverify> selectAll();

    int updateByPrimaryKey(Mailverify record);
}