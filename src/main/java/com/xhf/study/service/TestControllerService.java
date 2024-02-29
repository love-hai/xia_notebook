package com.xhf.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: testController
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/5 15:09
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/5 15:09
 * @updateRemark:
 * @version: v1.0
 */
@FeignClient(name = "integration-service", url = "http://127.0.0.1:8082", configuration = MyFeignConfig.class)
public interface TestControllerService {
    @GetMapping(value = "/shopee-merchant-item/get-global-item-id-by-merchant-id", produces = MediaType.APPLICATION_JSON_VALUE)
    String getListGolobalItemIdByMerchantId(@RequestParam("merchantId") Integer merchantId, @RequestParam("pageSize") int pageSize);
}
