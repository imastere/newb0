package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.Paper;
import com.baomidou.ant.poem.entity.TTopicOperate;
import com.baomidou.ant.poem.entity.TTopics;
import com.baomidou.ant.poem.mapper.TTopicOperateMapper;
import com.baomidou.ant.poem.mapper.TTopicsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-07
 */
@RestController
public class TTopicOperateController {
    @Resource
    TTopicsMapper tTopicsMapper;

    @Resource
    TTopicOperateMapper tTopicOperateMapper;


    @GetMapping("/getTimeAxisList")
    public Object getmyTopicList(HttpServletRequest request) {
        String user = request.getParameter("user");
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("owner",session.getAttribute("owner"));
//        System.out.println("owner"+session.getAttribute("owner"));
        queryWrapper.eq("user", user);
        HashMap map = new HashMap();
        map.put("code", 0);
        map.put("message", "操作成功");
        HashMap datamap = new HashMap();
        List<TTopicOperate> tTopicOperates = tTopicOperateMapper.selectList(queryWrapper);
        List<Paper> papers = new ArrayList<>();
        for (int i = 0; i < tTopicOperates.size(); i++) {
            TTopicOperate ttoi = tTopicOperates.get(i);
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("id", ttoi.getTopicid());
            TTopics tTopic = tTopicsMapper.selectOne(queryWrapper1);
            Paper paperi = new Paper();
            paperi.setOperate(ttoi.getOperate());
            paperi.setTitle(tTopic.getTitle());
            paperi.set_id(tTopic.getId().toString());
            paperi.setDecs(tTopic.getDescription());
            HashMap metahashMap = new HashMap();
            metahashMap.put("view", tTopic.getNewUser());
            metahashMap.put("like", tTopic.getStart());
            metahashMap.put("comments", tTopic.getMessage());
            paperi.setMeta(metahashMap);
            paperi.setCreate_time(null);
            paperi.setImg_url(tTopic.getAvatar());
            paperi.setDecs(tTopic.getDescription());
            System.out.println(paperi);
            System.out.println(i);

                papers.add(paperi);
        }
        datamap.put("list", papers);
        datamap.put("count", tTopicOperates.size());
        map.put("data", datamap);
        return map;
    }





}
