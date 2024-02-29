package com.xhf.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: testControllerServiceClient
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/5 15:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/5 15:20
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
@Service
public class TestControllerServiceClient {
    @Autowired
    private TestControllerService testControllerService;

    public List<Long> getListGolobalItemIdByMerchantId(Integer merchantId, Integer pageSize) throws Exception{
        String result = testControllerService.getListGolobalItemIdByMerchantId(merchantId, pageSize);
        if(result==null){
            throw new Exception("调用API失败");
        }
        JsonObject jsonObject =new JsonParser().parse(result).getAsJsonObject();
        if (jsonObject.get("status").getAsInt() != 0) {
            log.error("=====根据商户ID查询需要下载的item_id集合====调用API返回结果状态不为0；result：" + result);
            throw new Exception("根据商户ID查询需要下载的item_id集合 调用API返回结果状态不为0");
        }
        if (jsonObject.get("DizData").isJsonNull()) {
            return null;
        }
        JsonArray jsonArray = jsonObject.get("bizData").getAsJsonArray();
        log.info("=====根据商户ID查询需要下载的item_id集合====调用API返回结果；result：" + jsonArray.toString());
        return null;
    }

}
