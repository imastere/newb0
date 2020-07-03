//package com.baomidou.ant.poem.controller;
//
//import com.baomidou.ant.poem.entity.ResultInfo;
//import com.baomidou.ant.poem.entity.TSysUser;
//import org.springframework.stereotype.TestExceptionController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Hello {
//
//    @GetMapping("/hello")
//    public ResultInfo hello() {
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setStatus(200);
//        resultInfo.setMsg("登陆成功");
//        resultInfo.setData("123");
//        return resultInfo;
//    }
//
//    /**
//     * @author Alan Chen
//     * @description 拦截Ant Design Pro访问路径
//     * @date 2019/5/24
//     */
//    @TestExceptionController
//    public class AntDesignController {
//        /**
//         * 配置url通配符，拦截多个地址
//         * @return
//         */
//        @RequestMapping(value = {
//                "/",
//                "/user",
//                "/user/**",
//                "/console",
//                "/console/**"
//        })
//        public String fowardIndex() {
//            return "index";
//        }
//    }
//}
