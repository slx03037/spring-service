package com.xinwen.start;

import com.xinwen.start.node01.instantiationawarebeanpostprocessor.d1.ExampleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

/**
 * @author shenlx
 * @description
 * @date 2025/2/26 14:40
 */
@Slf4j
@SpringBootTest
public class ApplicationTest {

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.xinwen.start");

        ExampleController bean = context.getBean(ExampleController.class);
        //AbstractApplicationContext
        Assert.isTrue("fanfu".equals(bean.getCreator()), "属性替换失败");
        log.info("----" + bean.getCreator());
    }
}
