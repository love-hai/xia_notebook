package com.xhf.test.service.netty.thrift;

import com.ljheee.thrift.service.defn.netty.HelloWolrdService;
import com.ljheee.thrift.service.defn.netty.UserInfo;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class ThriftClient {

    public static void main(String[] args) throws TTransportException {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8484), 600);

        TProtocol protocol = new TCompactProtocol(transport);
        HelloWolrdService.Client client = new HelloWolrdService.Client(protocol);

        try {
            transport.open();
            UserInfo person = client.getUserInfo("张三", "123456");
            client.saveUserInfo(person);
            UserInfo person1 = new UserInfo();
            person1.setUsername("李四");
            person1.setPassword("123456");
            person1.setRemark("李四的密码是123456");
            client.saveUserInfo(person1);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}