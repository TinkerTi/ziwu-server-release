package cn.justin.ziwu.server.test.testAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestService userService = (TestService) ctx.getBean("testService");
        userService.add();
    }

}
