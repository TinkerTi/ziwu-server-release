package cn.justin.ziwu.server.shiro;

import java.util.Map;

public interface RealmService {

    Map<String, Object> getUserUniqueIdentityAndPassword(String userName);
}
