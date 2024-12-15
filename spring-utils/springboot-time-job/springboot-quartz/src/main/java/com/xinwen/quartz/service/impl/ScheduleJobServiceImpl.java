package com.xinwen.quartz.service.impl;//package com.xinwen.quartz.com.xinwen.mybatis.node01.service.impl;
//
//import com.xinwen.quartz.com.xinwen.mybatis.node01.mapper.JobsMapper;
//import com.xinwen.quartz.com.xinwen.mybatis.node01.mapper.QuartzManager;
//import com.xinwen.quartz.com.xinwen.mybatis.node01.service.ScheduleJobService;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author shenlx
// * @description
// * @date 2024/9/20 17:15
// */
//@Service
//public class ScheduleJobServiceImpl implements ScheduleJobService {
//    @Autowired
//    private JobsMapper jobsMapper;
//
//    @Autowired
//    QuartzManager quartzManager;
//
//    @Override
//    public void initSchedule() throws SchedulerException {
//        // 这里获取任务信息数据
//        List<Map> jobList = jobsMapper.list();
//        for (Map map : jobList) {
//            if (JobStatusEnum.RUNNING.getCode().equals(map.get("state"))) {
//                quartzManager.addJob(map);
//            }
//        }
//    }
//}
