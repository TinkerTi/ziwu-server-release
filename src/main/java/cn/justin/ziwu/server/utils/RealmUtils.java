package cn.justin.ziwu.server.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.SimpleByteSource;

public class RealmUtils {

    public static String genPasswordSalt() {
        return IdentifierUtils.getLongUid();
    }

    public static String genPassword(String password, String salt) {
        SimpleHash hash = new SimpleHash("SHA-1",
                new SimpleByteSource(password),
                new SimpleByteSource(salt),
                1);

        return hash.toHex();
    }

    public static String genPassword(String s) {
    	String defaultPwd = "000000";
        if (s != null) {
        	return s.length() >= 6 ? s.substring(s.length()-6, s.length()) : defaultPwd.substring(0, 6-s.length()) + s;
        } else {
            return defaultPwd;
        }
    }
}
