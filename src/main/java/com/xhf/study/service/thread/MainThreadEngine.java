package com.xhf.study.service.thread;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @projectName: lalang-browser
 * @package: com.lalang.browser.service
 * @className: MainThreadEngine
 * @descriptions: 用来执行callable
 * @author: xiahaifeng
 * @createDate: 2023/9/8 14:53
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/8 14:53
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
public class MainThreadEngine {
    Callable callable;

    public MainThreadEngine(Callable<Objects> callable){
        this.callable=callable;
    }

    /**
     * @Description:获取callable的返回值类型
     * @Param: []:[]
     * @return: java.lang.Object
     * @Author: xiahaifeng
     * @Date: 2023/9/8 14:58
     */
    public Type getCallableResult() {
        try {
            Type returnType = callable.getClass().getMethod("call").getGenericReturnType();
            return returnType;
        } catch (Exception e) {
            log.info("获取callable的返回值失败"+e.getMessage(),e);
            return null;
        }
    }

    public <T> T call() {
        FutureTask<T> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            return futureTask.get();
        } catch (Exception e) {
            log.error("执行callable失败：" + e.getMessage(), e);
            return null;
        }
    }
}
