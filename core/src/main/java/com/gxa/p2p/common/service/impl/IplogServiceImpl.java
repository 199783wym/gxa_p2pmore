package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/23 15:33
 * @Version 1.0
 */
@Service
public class IplogServiceImpl implements IIplogService {
    @Autowired
    private IplogMapper iplogMapper;

    @Override
    public PageResultSet selectIplog(IplogQueryObject iplogQueryObject) {
        int count = iplogMapper.queryForCount(iplogQueryObject);
        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<Iplog> list;
            list = iplogMapper.selectByDateAndState(iplogQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    iplogQueryObject.getCurrentPage(),
                    iplogQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(iplogQueryObject.getPageSize());
        }
        return pageResultSet;
    }
}
