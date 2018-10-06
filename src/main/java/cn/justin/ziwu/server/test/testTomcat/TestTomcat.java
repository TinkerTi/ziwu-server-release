package cn.justin.ziwu.server.test.testTomcat;

import java.io.File;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TestTomcat {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        File appDir = new File("/Users/tiankui/Library/tomcat/webapps/examples");
        tomcat.addWebapp(null, "/examples", appDir.getAbsolutePath());
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
