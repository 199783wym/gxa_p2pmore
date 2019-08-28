package com.gxa.p2p.common.domain;

import com.gxa.p2p.common.util.BitStatesUtils;
import lombok.Data;

@Data
public class Userinfo {
//    private boolean bindPhone;
//
//    public boolean isBindPhone() {
//        return bindPhone;
//    }
//
//    public void setBindPhone(boolean bindPhone) {
//        this.bindPhone = bindPhone;
//    }

    // 添加绑定的状态码
    public void addState(Long state) {

        bitstate = BitStatesUtils.addState(this.bitstate, state);
    }

    // 移除状态码
    public void  removeState(Long state) {

        bitstate = BitStatesUtils.removeState(this.bitstate, state);
    }

    // 判断是否已经绑定了手机
    public boolean getIsBindPhone() {
        boolean flag=BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_BIND_PHONE);
//        this.setBindPhone(flag);
        return flag;
    }
    public boolean getIsBindEmail() {
        boolean flag=BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_BIND_EMAIL);
//        this.setBindPhone(flag);
        return flag;
    }
    private Systemdictionaryitem educationbackgroundItem;
    private Systemdictionaryitem incomeGradeItem;
    private Systemdictionaryitem marriageItem;
    private Systemdictionaryitem kidCountItem;
    private Systemdictionaryitem houseConditionItem;
//    private Systemdictionaryitem userFileTypeItem;

    private Long id;

    private Integer version=1;

    private Long bitstate=0L;

    private String realname;

    private String idnumber;

    private String phonenumber;

    private Long incomegradeId;

    private Long marriageId;

    private Long kidcountId;

    private Long educationbackgroundId;

    private Integer authscore;

    private Long houseconditionId;

    private Long realauthid;

    private String email;
    // 添加绑定的状态码

    // 判断用户是否已经填写了基本资料
    public boolean getIsBasicInfo() {
        return BitStatesUtils.hasState(bitstate, BitStatesUtils.OP_USER_INFO);
    }
    //isBasicInfo

    public Systemdictionaryitem getEducationbackgroundItem() {
        return educationbackgroundItem;
    }

    public void setEducationbackgroundItem(Systemdictionaryitem educationbackgroundItem) {
        this.educationbackgroundItem = educationbackgroundItem;
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

    public Long getBitstate() {
        return bitstate;
    }

    public void setBitstate(Long bitstate) {
        this.bitstate = bitstate;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Long getIncomegradeId() {
        return incomegradeId;
    }

    public void setIncomegradeId(Long incomegradeId) {
        this.incomegradeId = incomegradeId;
    }

    public Long getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Long marriageId) {
        this.marriageId = marriageId;
    }

    public Long getKidcountId() {
        return kidcountId;
    }

    public void setKidcountId(Long kidcountId) {
        this.kidcountId = kidcountId;
    }

    public Long getEducationbackgroundId() {
        return educationbackgroundId;
    }

    public void setEducationbackgroundId(Long educationbackgroundId) {
        this.educationbackgroundId = educationbackgroundId;
    }

    public Integer getAuthscore() {
        return authscore;
    }

    public void setAuthscore(Integer authscore) {
        this.authscore = authscore;
    }

    public Long getHouseconditionId() {
        return houseconditionId;
    }

    public void setHouseconditionId(Long houseconditionId) {
        this.houseconditionId = houseconditionId;
    }

    public Long getRealauthid() {
        return realauthid;
    }

    public void setRealauthid(Long realauthid) {
        this.realauthid = realauthid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}