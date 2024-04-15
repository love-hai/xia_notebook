package com.xhf.jdk17Study.controller;

import com.xhf.jdk17Study.model.MyIp;
import com.xhf.jdk17Study.service.remote.IpQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：ShopeeV2TokenClientController
 * PackageName：com.lalang.core.controller
 * Description：
 *
 * @author wushang.wang
 * Date：Create in 2021/8/28 15:15
 */
@RestController
@Slf4j
@RequestMapping(value = "/ip")
public class QueryIpController {
    @Autowired
    private IpQueryService ipQueryService;
    @PostMapping(value = "/my")
    public void pushShopTokenToClient() {
       MyIp myIp = ipQueryService.getMyNetIp();
       log.info("myIp:{}",myIp);
    }

    public static void main(String[] args){
        IpQueryService ipQueryService=new IpQueryService();
        MyIp myIp = ipQueryService.getMyNetIp();
        log.info("myIp:{}",myIp);
    }
}
