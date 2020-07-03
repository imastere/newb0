package com.baomidou.ant.poem.controller;

import com.baomidou.ant.poem.entity.TSysUser;
import com.baomidou.ant.poem.entity.TTopics;
import com.baomidou.ant.poem.mapper.TTopicsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        //返回审核通过的
        queryWrapper.eq("status","1");

        Page<TTopics> page = new Page<>(1, 5);
//        return tTopicsMapper.selectPage(page,null);
        return tTopicsMapper.selectList(queryWrapper);
    }

    @PostMapping("/api/forms")
    @Transactional
    public Object addTopic(HttpSession session, @RequestBody TTopics tTopics){
        tTopics.setOwner((String) session.getAttribute("owner"));
        tTopics.setStatus(0);
        System.out.println(tTopics);
        tTopicsMapper.insert(tTopics);

        /**
         * 事务管理 @Transactional
         * @Transactional 注解，使用默认配置，抛出异常之后，事务会自动回滚，数据不会插入到数据库。
         */
        if (tTopics.getContent().length()<=3) {
            throw new RuntimeException("save 失败");
        }


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



    @GetMapping("/api/query/investigate")
    public Object getInvertigate(HttpServletRequest request) throws UnsupportedEncodingException {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int current = Integer.parseInt(request.getParameter("current"));
        Page<TTopics> page = new Page<>(current, pageSize);

        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("status",0);

        tTopicsMapper.selectPage(page,queryWrapper);
        HashMap<String,Object> map = new HashMap<>();
        map.put("data", page.getRecords());
        map.put("total", page.getTotal());
        map.put("pageSize", pageSize);
        map.put("current", current);
        return map;
    }


    @PostMapping("/api/passInvestigateTopic")
    public Object passInvestigateTopic(HttpSession session, @RequestBody Map<String, String> reqmap) {
        int id = Integer.parseInt(reqmap.get("id"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        TTopics topic = tTopicsMapper.selectOne(queryWrapper);
        topic.setStatus(1);
        tTopicsMapper.updateById(topic);
        HashMap<String, String> resmap = new HashMap<>();
        resmap.put("message", "ok");
        return resmap;
    }

    @PostMapping("/api/banInvestigateTopic")
    public Object banInvestigateTopic(HttpSession session, @RequestBody Map<String, String> reqmap) {
        int id = Integer.parseInt(reqmap.get("id"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        TTopics topic = tTopicsMapper.selectOne(queryWrapper);
        topic.setStatus(2);
        tTopicsMapper.updateById(topic);
        HashMap<String, String> resmap = new HashMap<>();
        resmap.put("message", "ok");
        return resmap;
    }



    @PostMapping("/addTopic")
    public Object addTopic(HttpServletRequest request){
        TTopics topic = new TTopics();

        topic.setOwner(request.getParameter("owner"));
        topic.setTitle(request.getParameter("title"));
        topic.setAvatar(request.getParameter("avatar"));
        topic.setStatus(0);
        topic.setLogo(request.getParameter("logo"));
        topic.setHref(request.getParameter("href"));

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        topic.setCreatedAt(df.format(new Date()));

        topic.setDescription(request.getParameter("description"));
        topic.setStart(0);
        topic.setLikenum(0);
        topic.setMessage(0);
        topic.setContent(request.getParameter(request.getParameter("content")));
        topic.setPublictype(1);

        tTopicsMapper.insert(topic);
        return topic;
    }





















}
