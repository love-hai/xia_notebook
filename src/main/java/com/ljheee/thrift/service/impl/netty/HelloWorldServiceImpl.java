package com.ljheee.thrift.service.impl.netty;

import com.ljheee.thrift.service.defn.netty.HelloWolrdService;
import com.ljheee.thrift.service.defn.netty.UserInfo;
import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWolrdService.Iface {

    @Override
    public UserInfo getUserInfo(String username, String password) throws TException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setRemark("remark");
        return userInfo;
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) throws TException {
        System.out.println("saveUserInfo:" + userInfo.toString());
    }
}
