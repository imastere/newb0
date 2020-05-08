package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.TPoemsBooks;
import com.baomidou.ant.poem.entity.TUserInfo;
import com.baomidou.ant.poem.mapper.TUserInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-03
 */
@RestController
public class TUserInfoController {
    @Resource
    TUserInfoMapper tUserInfoMapper;

    @GetMapping("/api/currentUser")
    public Object currentUser(HttpSession session) {
        HashMap<Object, Object> map = new HashMap();
        if (session.getAttribute("userid")!=null){
        Integer userid = (Integer) session.getAttribute("userid");
        System.out.println("userid"+userid);
        QueryWrapper queryWrapper  =new QueryWrapper();
        queryWrapper.eq("userid",userid);
        TUserInfo tUserInfo = tUserInfoMapper.selectOne(queryWrapper);
        session.setAttribute("user",tUserInfo);
        session.setAttribute("owner",tUserInfo.getName());
        return tUserInfo;
        }else{
            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setName("guest");
            return tUserInfo;
        }

    }



}
