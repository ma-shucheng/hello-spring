package com.shuke.hello.spring;

import com.shuke.hello.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    //实例化日志对象Logger(slf4j)，饿汉模式创建，因为不确定使用Log4j还是Logback，就用工厂模式创建
    private static final Logger logger = LoggerFactory.getLogger(Mytest.class);
    public static void main(String[] args) {
        //硬编码耦合之前的接口
//        UserService userService = new UserServiceImpl();

        //通过Spring容器来调用对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.sayhi();

        logger.info("info 级别的日志");
        logger.debug("debug 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");

        String message = "测试";
        String message2 = "测试2";

        logger.info("message is {} {}",message,message2);
    }
}
