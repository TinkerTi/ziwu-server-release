package cn.justin.ziwu.server.shiro;

import cn.justin.ziwu.server.mybatis.mapper.extended.ExtendedTUserMapper;
import cn.justin.ziwu.server.mybatis.model.generated.TUser;
import cn.justin.ziwu.server.services.UserService;
import org.glassfish.jersey.internal.guava.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("realmService")
public class RealmServiceImpl implements RealmService {

    @Resource
    ExtendedTUserMapper extendedTUserMapper;

    @Override
    public Map<String, Object> getUserUniqueIdentityAndPassword(String userName) {
        TUser user = extendedTUserMapper.getUserByEmail(userName);
        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", user.getEmail());
            map.put("password", user.getPassword());
            map.put("salt", user.getSalt());
            return map;
        }
        return null;
    }
}
