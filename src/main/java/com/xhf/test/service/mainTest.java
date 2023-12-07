package com.xhf.test.service;

import com.xhf.test.model.IntWrapper;
import com.xhf.test.service.tool.MyFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: mainTest
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 14:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 14:20
 * @updateRemark:
 */
@Slf4j
public class mainTest {
    @Autowired
    private static ReadTime readTime;

    public static void main(String[] args) {

        MyFileUtils myFileUtils = new MyFileUtils();
        String fileName = "lalangBrowser-0.2.3.0.exe";
        myFileUtils.downloadFile("http://update.biz-export.com/"+fileName,"C:\\Users\\Admin\\Downloads",fileName);
    }

    private void test(IntWrapper a,int b){
        a.setValue(a.getValue()+1);
        b = 2;
        log.info("a:{},b:{}",a.getValue(),b);
    }
}
