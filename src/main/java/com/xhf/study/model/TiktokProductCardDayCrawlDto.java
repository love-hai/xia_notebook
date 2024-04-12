package com.xhf.study.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiahaifeng
 * @since 2024/4/10 11:26
 */
@Data
public class TiktokProductCardDayCrawlDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    private String account;

    private String shopCode;

    private String shopProductId;

    private Integer exposureNumber;

    private Integer browseNumber;

    private Integer reDuplicatesBrowseNumber;

    private Integer reDuplicatesBuyerNumber;

    private BigDecimal clickRate;

    private BigDecimal conversionRate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modified;
}
