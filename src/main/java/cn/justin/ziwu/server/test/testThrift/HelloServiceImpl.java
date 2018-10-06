package cn.justin.ziwu.server.test.testThrift;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface{

    @Override
    public String sayHello(String username) throws TException {
        System.out.println("server hello!");
        return " hello client!";
    }
}
