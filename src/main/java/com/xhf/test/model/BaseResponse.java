package com.xhf.test.model;

import lombok.Data;

/**
 * @projectName: test<br>
 * @package: com.xhf.test.model<br>
 * @className: BaseResponse<br>
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2024/1/3 9:01
 * @updateUser: xiahaifeng
 * @updateDate: 2024/1/3 9:01
 * @updateRemark:
 */
@Data
public class BaseResponse<T> {
    private Integer status;
    private String message;
    private T bizData;
}
