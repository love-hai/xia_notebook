package com.xhf.jdk17Study.service.remote;

import com.xhf.jdk17Study.model.MyIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiahaifeng
 * @since 2024/4/13 9:52
 */
@Slf4j
@Service
public class IpQueryService {
    @Autowired
    private OtherApiService otherApiService;

    public MyIp getMyNetIp() {
        try {
            MyIp myIp = otherApiService.queryMyNetIp().getBizData();
            if (null == myIp) {
                log.error("获取ip失败");
                return null;
            }
            if (myIp.getStatus().equals("success")) {
                return myIp;
            }
        } catch (Exception e) {
            log.error("获取ip失败", e);
        }
        return null;
    }
}
