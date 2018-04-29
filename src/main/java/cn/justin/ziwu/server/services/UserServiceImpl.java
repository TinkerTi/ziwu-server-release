package cn.justin.ziwu.server.services;


import cn.justin.ziwu.server.mybatis.mapper.extended.ExtendedTUserMapper;
import cn.justin.ziwu.server.mybatis.mapper.generated.TUserMapper;
import cn.justin.ziwu.server.mybatis.model.generated.TUser;
import cn.justin.ziwu.server.pojos.InputLoginData;
import cn.justin.ziwu.server.pojos.InputRegisterData;
import cn.justin.ziwu.server.pojos.RestResult;
import cn.justin.ziwu.server.pojos.RestResultCode;
import cn.justin.ziwu.server.utils.IdentifierUtils;
import cn.justin.ziwu.server.utils.RealmUtils;
import cn.justin.ziwu.server.utils.StringUtils;
import com.sun.jndi.dns.ResourceRecord;
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
            return RestResult.generateResult(RestResultCode.CODE_EMAIL_EXISTS);
        }
        user = new TUser();
        user.setName(data.getName());
        user.setPortrait(data.getPortrait());
        String salt = RealmUtils.genPasswordSalt();
        user.setSalt(salt);
        String password = RealmUtils.genPassword(data.getPassword(), salt);
        user.setPassword(password);
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        extendedTUserMapper.insert(user);
        return RestResult.Success();
    }

    @Override
    public RestResult login(InputLoginData data) {
        if(TextUtils.isEmpty(data.getPassword())){
            return RestResult.generateResult(RestResultCode.CODE_INVALID_PARAM);
        }
        TUser user = extendedTUserMapper.getUserByEmail(data.getEmail());
        String salt = user.getSalt();
        String password = RealmUtils.genPassword(data.getPassword(), salt);
        if (password.equals(user.getPassword())) {
            return RestResult.Success();
        }
        return RestResult.generateResult(RestResultCode.CODE_USENAME_PASSWORD_NOT_MATCH);
    }
}
