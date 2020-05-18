//package com.baomidou.ant.poem.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * Created by toutou on 2018/10/27.
// */
//@Slf4j
//@Component
//@WebFilter(filterName = "filter",urlPatterns = "/*")
//public class AllFilterConfig implements Filter{
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // TODO Auto-generated method stub
//
//        HttpServletRequest request1 = (HttpServletRequest) request;
//        if (request1.getHeader("Access-Control-Allow-Origin")!=null){
//            if (request1.getHeader("Access-Control-Allow-Origin").equals("*")){
//
//                log.info("通过");
//            }else {
//                chain.doFilter(request, response);
//                log.info("拦截");
//            }
//        }
//        if (request1.getHeader("access-control-allow-origin")!=null){
//            if (request1.getHeader("access-control-allow-origin").equals("*")){
//
//                log.info("通过");
//            }else {
//                chain.doFilter(request, response);
//                log.info("拦截");
//            }
//        }
//
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
