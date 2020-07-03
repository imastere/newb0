//package com.baomidou.ant.poem.config;
//
//import com.baomidou.ant.poem.entity.ResultBean;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//@ResponseBody
//public class WebExceptionHandler {
//
//    private static final Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);
//
//    @ExceptionHandler
//    public ResultBean unknownAccount(Exception e) {
//        log.error("账号不存在", e);
//        return ResultBean.error(1, "账号不存在");
//    }
//
//    @ExceptionHandler
//    public ResultBean incorrectCredentials(Exception e) {
//        log.error("密码错误", e);
//        return ResultBean.error(-2, "密码错误");
//    }
//
//    @ExceptionHandler
//    public ResultBean unknownException(Exception e) {
//        log.error("发生了未知异常", e);
//        // 发送邮件通知技术人员.
//        return ResultBean.error(-99, "系统出现错误, 请联系网站管理员!");
//    }
//}