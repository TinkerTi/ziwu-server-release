package cn.justin.ziwu.server.services;


import cn.justin.ziwu.server.exception.TestException;
import cn.justin.ziwu.server.mybatis.mapper.extended.ExtendedTUserMapper;
import cn.justin.ziwu.server.mybatis.model.generated.TUser;
import cn.justin.ziwu.server.pojos.*;
import cn.justin.ziwu.server.shiro.ShiroUtils;
import cn.justin.ziwu.server.utils.IdentifierUtils;
import cn.justin.ziwu.server.utils.RealmUtils;
import cn.justin.ziwu.server.utils.StringUtils;
import org.apache.http.util.TextUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    ExtendedTUserMapper extendedTUserMapper;

    public void printTest() {
        System.out.println("test user service impl");
    }
    @Override
    public RestResult register(InputRegisterData data) {
        if (data != null) {
            throw new TestException();
        }
        TUser user = null;
        String email = data.getEmail();
        if (TextUtils.isEmpty(email)) {
            return RestResult.generateResult(RestResultCode.CODE_EMPTY_EMAIL);
        }
        if (!StringUtils.isPasswordValid(data.getPassword())) {
            return RestResult.generateResult(RestResultCode.CODE_INVALID_PASSWORD);
        }
        //todo 检查手机号是否合法，
        user = extendedTUserMapper.getUserByEmail(data.getEmail());
        if (user != null) {
            return RestResult.generateResult(RestResultCode.CODE_EMAIL_EXISTS);
        }
        user = new TUser();
        String uid = IdentifierUtils.genUid();
        user.setUid(uid);
        user.setName(data.getName());
        user.setPortrait(data.getPortrait());
        String salt = RealmUtils.genPasswordSalt();
        user.setSalt(salt);
        String password = RealmUtils.genPassword(data.getPassword(), salt);
        user.setPassword(password);
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        extendedTUserMapper.insert(user);

        OutputUserInfo registerInfo = new OutputUserInfo();
        registerInfo.setUid(uid);
        registerInfo.setName(user.getName());
        registerInfo.setEmail(user.getEmail());
        registerInfo.setPhone(user.getPhone());
        registerInfo.setPortrait(user.getPortrait());
        return RestResult.success(registerInfo);
    }

    @Override
    public RestResult login(InputLoginData data) {
        if (TextUtils.isEmpty(data.getPassword())) {
            return RestResult.generateResult(RestResultCode.CODE_INVALID_PARAM);
        }

        TUser user = extendedTUserMapper.getUserByEmail(data.getEmail());
        UsernamePasswordToken token = new UsernamePasswordToken(data.getEmail(), data.getPassword());
        RestResultCode code = RestResultCode.CODE_SUCCESS;
        try {
            ShiroUtils.getSubject().login(token);
            ShiroUtils.setAttribute(ShiroUtils.USER_ID, user.getId());
            ShiroUtils.setAttribute(ShiroUtils.USER_UID, user.getUid());
        } catch (UnknownAccountException e) {
            code = RestResultCode.CODE_USER_NOT_FOUND;
        }
        OutputUserInfo outputUserInfo = new OutputUserInfo();
        outputUserInfo.setName(user.getName());
        outputUserInfo.setEmail(user.getEmail());
        outputUserInfo.setPortrait(user.getPortrait());
        outputUserInfo.setUid(user.getUid());
        return RestResult.generateResult(code).setResult(outputUserInfo);
    }

    @Override
    public RestResult logout() {
        org.apache.shiro.subject.Subject subject = ShiroUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return RestResult.success();
    }
}
