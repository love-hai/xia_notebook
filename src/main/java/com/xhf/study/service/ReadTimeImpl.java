package com.xhf.study.service;

import java.util.Date;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: readTimeimpl
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/12/4 13:45
 * @updateUser: xiahaifeng
 * @updateDate: 2023/12/4 13:45
 * @updateRemark:
 */

public class ReadTimeImpl implements ReadTime {
    public Date getTime(Long time) {
        if (time == null) {
            return new Date();
        }else {
            return new Date(time);
        }
    }
}
