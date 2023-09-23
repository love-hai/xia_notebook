package com.xhf.test.service.password;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @projectName: test
 * @package: com.xhf.test.service.password
 * @className: main
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 10:17
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 10:17
 * @updateRemark:
 */

public class main {
    public static void main(String[] args) {
        BCrypt.checkpw("@XHFxhf383818", "$2a$10$KeAVARaexyAdyq31pGBu3eTGakoCvxzDE4GWANwdAFGUVyt.hN6tG");
    }
}
