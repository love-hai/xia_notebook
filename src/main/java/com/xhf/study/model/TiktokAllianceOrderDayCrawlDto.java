package com.xhf.study.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiahaifeng
 * @since 2024/4/10 13:15
 */
@Data
public class TiktokAllianceOrderDayCrawlDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Long batchId;

    private String account;

    private String shopCode;

    private String shopProductId;

    private String skuId;

    private String orderId;

    private BigDecimal estimateAllianceCommission;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modified;
}
