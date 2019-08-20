package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Account;
import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);

    int add(Account account);
}