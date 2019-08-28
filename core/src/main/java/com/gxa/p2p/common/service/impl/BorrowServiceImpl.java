package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Bidrequest;
import com.gxa.p2p.common.mapper.BidrequestMapper;
import com.gxa.p2p.common.service.IBorrowService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void createbidrequest(Bidrequest bidrequest) {
       bidrequestMapper.insert(bidrequest);
    }
}
