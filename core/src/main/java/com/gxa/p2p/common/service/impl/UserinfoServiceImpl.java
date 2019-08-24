package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserinfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private Userinfo getCurrentUserInfo(Long id) {
        return   userinfoMapper.selectByPrimaryKey(id);
    }
}
