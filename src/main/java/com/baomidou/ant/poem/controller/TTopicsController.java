package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.TPoemsBooks;
import com.baomidou.ant.poem.entity.TTopics;
import com.baomidou.ant.poem.entity.TUserInfo;
import com.baomidou.ant.poem.mapper.TTopicsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-02
 */
@RestController
public class TTopicsController {
    @Resource
    TTopicsMapper tTopicsMapper ;



    @GetMapping("/api/fake_list")
    public Object getTopicList(HttpServletRequest request){

        QueryWrapper queryWrapper = new QueryWrapper();
        /*int pageSize = Integer.parseInt(request.getParameter("pageSize"));*/
//        int count = Integer.parseInt(request.getParameter("count"));


        Page<TTopics> page = new Page<>(1, 5);
//        return tTopicsMapper.selectPage(page,null);
        return tTopicsMapper.selectList(null);
    }

    @PostMapping("/api/forms")
    public Object addTopic(HttpSession session, @RequestBody TTopics tTopics){
        tTopics.setOwner((String) session.getAttribute("owner"));
        System.out.println(tTopics);
        tTopicsMapper.insert(tTopics);
        HashMap<String,String> map = new HashMap<>();
        map.put("messgae","Ok");
        return map;
    }


    @GetMapping("/api/mytopic_list")
    public Object getmyTopicList(HttpSession session){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("owner",session.getAttribute("owner"));
        System.out.println("owner"+session.getAttribute("owner"));
        return tTopicsMapper.selectList(queryWrapper);
    }












}
