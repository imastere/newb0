package com.baomidou.ant.poem.config;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component

public class AopConfig {
    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Pointcut("execution(public * com.baomidou.ant.poem.controller.TSysUserController.*(..)))")
    public void BrokerAspect(){

    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("BrokerAspect()")
    public void doBefore(){
        logger.info("用户正在准备登陆");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerAspect()")
    public void doAfter(){
        logger.info("用户正在登陆！");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("BrokerAspect()")
    public void doAfterReturning(){
        logger.info("用户登陆成功");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("BrokerAspect()")
    public void doAfterThrowing(){
        logger.info("异常通知：退出登陆");
    }
}
