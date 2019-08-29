package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Bidrequest;
import com.gxa.p2p.common.mapper.BidrequestMapper;
import com.gxa.p2p.common.query.BorrowQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IBorrowService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/28 11:03
 * @Version 1.0
 */
@Service
public class BorrowServiceImpl implements IBorrowService {
    @Autowired
    private BidrequestMapper bidrequestMapper;


    @Override
    public PageResultSet queryForPage(BorrowQueryObject borrowQueryObject) {
        int count = bidrequestMapper.queryForCount();

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<Bidrequest> list = bidrequestMapper.queryForPage(borrowQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    borrowQueryObject.getCurrentPage(),
                    borrowQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(borrowQueryObject.getPageSize());
        }
        return pageResultSet;
    }

    @Override
    public void createbidrequest(Bidrequest bidrequest) {
       bidrequestMapper.insert(bidrequest);
    }
}
