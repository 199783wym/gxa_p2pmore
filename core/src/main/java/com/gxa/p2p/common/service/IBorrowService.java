package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Bidrequest;
import com.gxa.p2p.common.query.BorrowQueryObject;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

/**
 * @Author: ym
 * @Date: 2019/8/28 10:10
 * @Version 1.0
 */
public interface IBorrowService {
    //进入页面时创建一个bidrequest
     void createbidrequest(Bidrequest bidrequest);
    PageResultSet queryForPage(BorrowQueryObject borrowQueryObject);

}
