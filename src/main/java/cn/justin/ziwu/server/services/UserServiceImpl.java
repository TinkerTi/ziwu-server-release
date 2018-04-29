package cn.justin.ziwu.server.services;


import cn.justin.ziwu.server.mybatis.mapper.extended.ExtendedTUserMapper;
import cn.justin.ziwu.server.mybatis.mapper.generated.TUserMapper;
import cn.justin.ziwu.server.mybatis.model.generated.TUser;
import cn.justin.ziwu.server.pojos.InputLoginData;
import cn.justin.ziwu.server.pojos.InputRegisterData;
import cn.justin.ziwu.server.pojos.RestResult;
import cn.justin.ziwu.server.pojos.RestResultCode;
import cn.justin.ziwu.server.utils.StringUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    ExtendedTUserMapper extendedTUserMapper;

    @Override
    public RestResult register(InputRegisterData data) {
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

        }
        user = new TUser();
        user.setName(data.getName());
        user.setPortrait(data.getPortrait());
        user.setPassword(data.getPassword());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
//        extendedTUserMapper.insert(user);
        return null;
    }

    @Override
    public RestResult login(InputLoginData data) {
        return null;
    }
}
