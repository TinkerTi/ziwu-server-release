package cn.justin.ziwu.server.test.Jmx;

public class HelloMBeanImpl implements HelloMBean{

    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("printHello,name: "+name);
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("printHello,whoName: "+whoName);
    }
}
