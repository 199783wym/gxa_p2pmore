package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Mailverify;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;

import com.gxa.p2p.common.mapper.MailverifyMapper;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.service.IVerifyCodeService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.DateUtil;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/21 15:20
 * @Version 1.0
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Autowired
    IVerifyCodeService iVerifyCodeService;

    @Autowired
    MailverifyMapper mailverifyMapper;


    @Override
    public List<Systemdictionaryitem> getUserInformation(String info) {
        List<Systemdictionaryitem> list =systemdictionaryitemMapper.selectByInfo(info);
        return list;
    }

    @Override
    public Userinfo getUserinfo(int id) {
        Userinfo userinfo=userinfoMapper.selectByPrimaryKey((long)id);
        return userinfo;
    }

    @Override
    public void updateBasicInfo(Userinfo userInfoVo) {
        try {

            // 获取需要保存userinfo对象（数据库原始对象）
//            LoginInfo loginInfo = UserContext.getLoginInfo();
            Userinfo userInfo = getCurrentUserInfo(UserContext.getLoginInfo().getId());

            //将页面提交的数据 设置到原有userinfo对象中
            userInfo.setEducationbackgroundItem(userInfoVo.getEducationbackgroundItem());
            userInfo.setKidCountItem(userInfoVo.getKidCountItem());
            userInfo.setIncomeGradeItem(userInfoVo.getIncomeGradeItem());
            userInfo.setHouseConditionItem(userInfoVo.getHouseConditionItem());
            userInfo.setMarriageItem(userInfoVo.getMarriageItem());

            // 设置状态码
            if ( !userInfo.getIsBasicInfo()) {
                userInfo.addState(BitStatesUtils.OP_USER_INFO);
            }

            // 更新个人资料
            updateUserInfo(userInfo);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("个人资料保存出错");

        }

    }

    private void updateUserInfo(Userinfo userInfo) {

        userinfoMapper.update(userInfo);
    }

    public Userinfo getCurrentUserInfo(Long id) {
        return   userinfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public void bindPhone(String phoneNumber, String verifyCode, HttpServletRequest request) {
        // 先做验证码的校验 (一般关于验证码的都交给验证码相关服务)
        if (iVerifyCodeService.validate(phoneNumber,verifyCode)) {
            //如果校验成功,给当前用户绑定手机号和状态码
            Userinfo userInfo = getCurrentUserInfo(UserContext.getLoginInfo().getId());
            //先判断当前用户是否已经绑定了手机
            if ( !userInfo.getIsBindPhone()) { //表示当前没有绑定手机
                //给当前用户添加状态码和手机号
                userInfo.setPhonenumber(phoneNumber);
                userInfo.addState(BitStatesUtils.OP_BIND_PHONE);
                updateUserInfo(userInfo);
            }
        }else{
            throw new RuntimeException("绑定失败");
        }
    }

    public void bindEmail(String uuid) {
        //根据uuid查村mailVerify对象
        Mailverify mailVerify = mailverifyMapper.selectByUUID(uuid);
        if (null != mailVerify
                && DateUtil.getBetweenSecond(mailVerify.getSendtime(), new Date()) < SysConstant.EMAIL_VALID_DAY * 24 * 3600 ) {
            //如果有 且在有效期内 的用户没有绑定邮箱
            Userinfo userInfo = userinfoMapper.selectByPrimaryKey(mailVerify.getLogininfoId());
            if ( !userInfo.getIsBindEmail()) {
                //添加邮箱状态码  设置email属性
                userInfo.addState(BitStatesUtils.OP_BIND_EMAIL);
                userInfo.setEmail(mailVerify.getEmail());
                updateUserInfo(userInfo);
            }
        }else{
            throw new RuntimeException("验证邮箱地址错误!");
        }
    }


}
