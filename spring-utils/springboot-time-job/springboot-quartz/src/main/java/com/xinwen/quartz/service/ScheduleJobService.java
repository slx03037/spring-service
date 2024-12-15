package com.xinwen.quartz.service;

import org.quartz.SchedulerException;

/**
 * @author shenlx
 * @description
 * @date 2024/9/20 17:15
 */
public interface ScheduleJobService {
    void initSchedule() throws SchedulerException;
}
