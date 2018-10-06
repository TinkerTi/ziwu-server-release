package cn.justin.ziwu.server.test.testBean;

import cn.justin.ziwu.server.resources.UserResource;
import cn.justin.ziwu.server.services.UserService;
import cn.justin.ziwu.server.services.UserServiceImpl;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestBean {

    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(
            new ClassPathResource("applicationContext.xml"));
        UserResource userResource=(UserResource) xmlBeanFactory.getBean("userResource");
        userResource.printTest();
    }


}
