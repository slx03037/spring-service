package com.xinwen.quartz.listener;

import com.xinwen.quartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author shenlx
 * @description
 * @date 2024/9/20 17:14
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {
    @Autowired
    ScheduleJobService scheduleJobService;

    @Override
    public void run(String... arg0) throws Exception {
        try {
            //初始化
            scheduleJobService.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
