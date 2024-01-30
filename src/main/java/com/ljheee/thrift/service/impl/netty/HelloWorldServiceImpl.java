package com.ljheee.thrift.service.impl.netty;

import com.ljheee.thrift.service.defn.netty.HelloWolrdService;
import com.ljheee.thrift.service.defn.netty.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
@Slf4j
public class HelloWorldServiceImpl implements HelloWolrdService.Iface {

    @Override
    public UserInfo getUserInfo(String username, String password) throws TException {
        UserInfo userInfo = new UserInfo();
        log.info("假装查找数据库，返回用户信息");
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setRemark("remark");
        log.info("返回用户信息"+userInfo.toString());
        return userInfo;
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) throws TException {
        System.out.println("saveUserInfo:" + userInfo.toString());
    }
}
