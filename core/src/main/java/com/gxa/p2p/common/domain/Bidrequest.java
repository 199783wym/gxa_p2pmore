package com.gxa.p2p.common.domain;

import com.alibaba.fastjson.JSONObject;
import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bidrequest {
    private Long id;

    private Integer version;

    private Byte bidrequesttype;

    private Byte bidrequeststate;

    private BigDecimal bidrequestamount;

    private BigDecimal currentrate;

    private Byte monthes2return;

    private Integer bidcount;

    private BigDecimal totalrewardamount;

    private BigDecimal currentsum=SysConstant.ZERO;

    private String title;

    private String description;

    private String note;

    private Date disabledate;

    private Long createuserId;

    private Byte disabledays;

    private BigDecimal minbidamount= SysConstant.MIN_BID_AMOUNT;

    private Date applytime;

    private Date publishtime;

    private Byte returntype;

    private LoginInfo createUser;// 借款人


    // 标的投标情况


    /*    private List<Bid> bids;// 针对该借款的投标*/


    //获取剩余还未投满的金额 (+:add  -:subtract  *:multiply  /:divide)
    public BigDecimal getRemainAmount() {
        return bidrequestamount.subtract(currentsum);
    }

    //获取标的进度条
    public BigDecimal getPersent() {
        return currentsum.divide(bidrequestamount, SysConstant.DISPLAY_SCALE, RoundingMode.HALF_UP);
    }

    //获取还款方式
    public String getReturnTypeDisplay() {
        return returntype == SysConstant.RETURN_TYPE_MONTH_INTEREST ? "按月到期" : "等额本息";
    }

    // 获取借款状态
    public String getBidRequestStateDisplay() {
        switch (bidrequeststate) {
            case SysConstant.BIDREQUEST_STATE_PUBLISH_PENDING:
                return "待发布";
            case SysConstant.BIDREQUEST_STATE_BIDDING:
                return "招标中";
            case SysConstant.BIDREQUEST_STATE_UNDO:
                return "已撤销";
            case SysConstant.BIDREQUEST_STATE_BIDDING_OVERDUE:
                return "流标";
            case SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_1:
                return "满标一审";
            case SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_2:
                return "满标二审";
            case SysConstant.BIDREQUEST_STATE_REJECTED:
                return "满标审核被拒";
            case SysConstant.BIDREQUEST_STATE_PAYING_BACK:
                return "还款中";
            case SysConstant.BIDREQUEST_STATE_COMPLETE_PAY_BACK:
                return "完成";
            case SysConstant.BIDREQUEST_STATE_PAY_BACK_OVERDUE:
                return "逾期";
            case SysConstant.BIDREQUEST_STATE_PUBLISH_REFUSE:
                return "发标拒绝";
            default:
                return "";
        }
    }


    public String getJsonString() {
        Map<String, Object> json = new HashMap<>();
//        json.put("id", id);
        json.put("username", createUser.getUsername());
        json.put("title", title);
        json.put("bidRequestAmount", bidrequestamount);
        json.put("currentRate", currentrate);
        json.put("monthes2Return", monthes2return);
        json.put("returnType", getReturnTypeDisplay());
        json.put("totalRewardAmount", totalrewardamount);
        return JSONObject.toJSONString(json);
    }

    public LoginInfo getCreateUser() {
        return createUser;
    }

    public void setCreateUser(LoginInfo createUser) {
        this.createUser = createUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Byte getBidrequesttype() {
        return bidrequesttype;
    }

    public void setBidrequesttype(Byte bidrequesttype) {
        this.bidrequesttype = bidrequesttype;
    }

    public Byte getBidrequeststate() {
        return bidrequeststate;
    }

    public void setBidrequeststate(Byte bidrequeststate) {
        this.bidrequeststate = bidrequeststate;
    }

    public BigDecimal getBidrequestamount() {
        return bidrequestamount;
    }

    public void setBidrequestamount(BigDecimal bidrequestamount) {
        this.bidrequestamount = bidrequestamount;
    }

    public BigDecimal getCurrentrate() {
        return currentrate;
    }

    public void setCurrentrate(BigDecimal currentrate) {
        this.currentrate = currentrate;
    }

    public Byte getMonthes2return() {
        return monthes2return;
    }

    public void setMonthes2return(Byte monthes2return) {
        this.monthes2return = monthes2return;
    }

    public Integer getBidcount() {
        return bidcount;
    }

    public void setBidcount(Integer bidcount) {
        this.bidcount = bidcount;
    }

    public BigDecimal getTotalrewardamount() {
        return totalrewardamount;
    }

    public void setTotalrewardamount(BigDecimal totalrewardamount) {
        this.totalrewardamount = totalrewardamount;
    }

    public BigDecimal getCurrentsum() {
        return currentsum;
    }

    public void setCurrentsum(BigDecimal currentsum) {
        this.currentsum = currentsum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getDisabledate() {
        return disabledate;
    }

    public void setDisabledate(Date disabledate) {
        this.disabledate = disabledate;
    }

    public Long getCreateuserId() {
        return createuserId;
    }

    public void setCreateuserId(Long createuserId) {
        this.createuserId = createuserId;
    }

    public Byte getDisabledays() {
        return disabledays;
    }

    public void setDisabledays(Byte disabledays) {
        this.disabledays = disabledays;
    }

    public BigDecimal getMinbidamount() {
        return minbidamount;
    }

    public void setMinbidamount(BigDecimal minbidamount) {
        this.minbidamount = minbidamount;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Byte getReturntype() {
        return returntype;
    }

    public void setReturntype(Byte returntype) {
        this.returntype = returntype;
    }
}