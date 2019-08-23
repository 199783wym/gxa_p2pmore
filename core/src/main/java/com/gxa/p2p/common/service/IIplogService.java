package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/23 15:32
 * @Version 1.0
 */
public interface IIplogService {
    public PageResultSet selectAll(IplogQueryObject iplogQueryObject);
}
