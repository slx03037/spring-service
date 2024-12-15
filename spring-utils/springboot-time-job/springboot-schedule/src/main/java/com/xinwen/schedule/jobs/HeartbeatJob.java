package com.xinwen.schedule.jobs;

import com.xinwen.schedule.entity.Additional;
import com.xinwen.schedule.entity.RegistryDO;
import com.xinwen.schedule.mapper.bellon.RegistryMapper;
import com.xinwen.schedule.mapper.local.AdditionalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-04 17:01
 **/
@Component
public class HeartbeatJob {
    private static final Logger logger = LoggerFactory.getLogger(HeartbeatJob.class);

    @Resource
    private RegistryMapper registryMapper;

    @Resource
    private AdditionalMapper additionalMapper;

    /**
     * 检查状态1
     */
    @Scheduled(cron = "0 30 12 * * ?")
    public void checkState1() {
        logger.info(">>>>> cron中午12:30上传检查开始....");
        logger.info(">>>>> cron中午12:30上传检查完成....");
    }

    /**
     * 检查状态2
     */
    @Scheduled(cron = "0 0 18 * * ?")
    public void checkState2() {
        logger.info(">>>>> cron晚上18:00上传检查开始....");
        logger.info(">>>>> cron晚上18:00上传检查完成....");
    }

    /**
     * 检查状态2
     */
    @Scheduled(cron = "10 * * * * ?")
    public void checkState3() {
        logger.info(">>>>> 每10s执行一次....");
        logger.info(">>>>> 执行结束....");
    }

    @Scheduled(cron = "11 32 11 * * ?")
    public void dataMigration(){
        logger.warn("开始执行------------------------------");
        Long startTime=System.currentTimeMillis();
        int offset =0;
        int pageSize=50;
        while(true){
            List<Additional> additionals = additionalMapper.selectByPrimaryKey(offset, pageSize);
            if(CollectionUtils.isEmpty(additionals)){
                break;
            }
            List<RegistryDO> registryDOS=new ArrayList<>(additionals.size());
            additionals.stream().forEach(add->{
                RegistryDO registry = createRegistry(add);
                if(null !=registry){
                    registryDOS.add(registry);
                }
            });
            registryMapper.insert(registryDOS);
            if(additionals.size()<50){
                break;
            }else {
                offset+=pageSize;
            }
        }
        logger.warn("耗时：{}",System.currentTimeMillis()-startTime);
    }

    private RegistryDO createRegistry(Additional additional) {
        try{
        RegistryDO registryDO = new RegistryDO();
        int i = additional.getFcartype().equals("电动车(两轮)") ? 0 : 1;
        registryDO.setUseType(i);
        registryDO.setPlateNo("眉山" + additional.getFCarNumber());
        registryDO.setPlateType(1);
        registryDO.setVehicleUse(2);
        Date date = new Date(additional.getFcreatetime());
        registryDO.setRegisterTime(date);
        Date buyDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(additional.getFbuydate() + " 00:00:00");
        registryDO.setBuyTime(buyDate);
        registryDO.setVin(additional.getFframenum());
        registryDO.setOwnerName(additional.getFusername());
        registryDO.setSex(0);
        registryDO.setCardId(additional.getFusercer());
        registryDO.setPhoneNum(additional.getFbckphone());
        registryDO.setInsuranceCompanyId(additional.getFinsurecompany());
        registryDO.setIsTheftInsurance(1);
        registryDO.setIsTripleLiabilityInsurance(1);
        registryDO.setIsLowIncome(1);
        registryDO.setIsAdditionalDriverInsurance(1);
        registryDO.setInsuranceYears(additional.getFperiodtime());
        registryDO.setVehicleStatus(1);
        registryDO.setAreaName("彭山区");
        registryDO.setBelongPlace("3");
        registryDO.setCreateName("meishan01");
        registryDO.setCreateTime(new Date());
        registryDO.setUpdateName("meishan01");
        registryDO.setUpdateTime(new Date());
        return registryDO;
     }catch (Exception e){
            logger.error("报错信息:{}",e.getMessage());
        }
        return null;
    }
}
