package cn.justin.ziwu.server.test.Jmx;

import cn.justin.ziwu.server.test.testThrift.HelloServiceImpl;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class JmxAgent {

    public static void main(String[] args) {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        String domainName = "myMBean";
        try {
//            ObjectName objectName = new ObjectName(domainName + ":name=helloWorld");
//            mBeanServer.registerMBean(new HelloServiceImpl(), objectName);
//
//            ObjectName adapterName = new ObjectName(domainName+":name=htmladapter,port=8082");
//            HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//            adapter.start();
//            mBeanServer.registerMBean(adapter,adapterName);
//
//            int rmiPort = 1099;
//            Registry registry = LocateRegistry.createRegistry(rmiPort);
//
//            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
//            JMXConnectorServer jmxConnector = JMXConnectorServerFactory
//                .newJMXConnectorServer(url, null, mBeanServer);
//            jmxConnector.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
