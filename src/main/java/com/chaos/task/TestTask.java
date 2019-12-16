package com.chaos.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务业务类
 */
@Component
public class TestTask {

    @Scheduled(fixedRate = 2000)
    public void sum(){
        System.out.println("当前时间：" + new Date());
    }

}
