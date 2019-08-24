package com.gxa.p2p.common.query;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: ym
 * @Date: 2019/8/23 15:50
 * @Version 1.0
 */
@Data
public class IplogQueryObject extends QueryObject {
    private Byte state;
    private Date beginDate;
    private Date endDate;



    public IplogQueryObject(){
        setPageSize(15);
        String dateString = null;
        String dateString1 = null;
//        try {
//            beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
//            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        state=-1;
    };


    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
