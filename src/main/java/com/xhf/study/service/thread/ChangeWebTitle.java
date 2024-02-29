package com.xhf.study.service.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @projectName: lalang-browser
 * @package: com.lalang.browser.task.callable.base
 * @className: ChangeWebTitle
 * @descriptions: 更改当前网页的标题
 * @author: xiahaifeng
 * @createDate: 2023/9/8 14:43
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/8 14:43
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
public class ChangeWebTitle implements Callable<Boolean> {
    private String title;
    public ChangeWebTitle(String title){
        this.title=title;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            String script="document.title='"+title+"';";
            log.info(script);
            log.info("执行更改网页标题的js语句成功");
            return true;
        }catch (Exception e){
            log.error("执行更改网页标题的js语句失败失败"+e.getMessage(),e);
            return false;
        }

    }
}
