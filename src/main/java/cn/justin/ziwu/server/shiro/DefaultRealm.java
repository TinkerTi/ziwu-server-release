package cn.justin.ziwu.server.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Map;


public class DefaultRealm extends AuthorizingRealm{

    private static final String DEFAULT_PWD_KEY = "password";
    private static final String DEFAULT_IDENTITY_KEY = "username";
    private static final String DEFAULT_SALT_KEY = "salt";

    @Resource
    RealmService realmService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Map<String, Object> info = null;

        if (authenticationToken instanceof UsernamePasswordToken) {
            UsernamePasswordToken authToken = (UsernamePasswordToken) authenticationToken;
            info = realmService.getUserUniqueIdentityAndPassword(authToken.getUsername());
        }
        boolean flag = info == null || info.isEmpty() || info.get(DEFAULT_IDENTITY_KEY) == null
                || info.get(DEFAULT_PWD_KEY) == null;
        if (!flag) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    info.get(DEFAULT_IDENTITY_KEY), info.get(DEFAULT_PWD_KEY), getName());
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(info.get(DEFAULT_SALT_KEY)));
            return simpleAuthenticationInfo;
        } else {
            // 没有找到账号
            throw new UnknownAccountException("UnknownAccountException");
        }
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
