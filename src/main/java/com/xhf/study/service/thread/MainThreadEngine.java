package com.xhf.study.service.thread;

import javafx.application.Platform;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 主线程用来执行操作UI的callable
 * @author xiahaifeng
 * @since 2023/9/8 14:53
 */
@Slf4j
public class MainThreadEngine {
    public MainThreadEngine() {
    }
    public static  <T> T call(Callable<T> callable) {
        try {
            if(Objects.isNull(callable)){
                throw new NullPointerException("callable不能为空");
            }
            String name = callable.getClass().getName();
            FutureTask<T> futureTask = new FutureTask<>(callable);
            Platform.runLater(futureTask);
            return futureTask.get();
        } catch (Exception e) {
            log.error("执行callable失败：" + e.getMessage(), e);
            return null;
        }
    }
}
