package cn.justin.ziwu.server.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    static public String USER_ID = "id";
    static public String USER_UID = "uid";
    static public String USER_PLATFORM = "platform";
    static public String USER_DEVICE_ID = "device_id";
    static public String CLIENT_IP = "client_ip";

    public static Session getSession() {
        Subject subject = getSubject();
        if (subject != null) {
            return subject.getSession(false);
        }
        return null;
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Object getAttribute(Object key) throws InvalidSessionException {
        Session session = getSession();
        if (session != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    public static void setAttribute(Object key, Object value) throws InvalidSessionException {
        Session session = getSession();
        if (session != null) {
            session.setAttribute(key, value);
        }
    }
}