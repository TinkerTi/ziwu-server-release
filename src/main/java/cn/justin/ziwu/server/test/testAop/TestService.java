package cn.justin.ziwu.server.test.testAop;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void add(){
        System.out.println("UserService add()");
    }

}
