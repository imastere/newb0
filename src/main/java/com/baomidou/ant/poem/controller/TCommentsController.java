package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.TComments;
import com.baomidou.ant.poem.mapper.TCommentsMapper;
import com.baomidou.ant.poem.mapper.TPoemsBooksMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-17
 */
@RestController
public class TCommentsController  {

    @Resource
    TCommentsMapper tCommentsMapper;

    @GetMapping("/getcomments")
    public Object getCommentsbyId(HttpServletRequest request){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("poem_id",request.getParameter("poem_id"));
        return tCommentsMapper.selectList(queryWrapper);
    }



    @PostMapping("/addcomment")
    public Object addcomment(HttpServletRequest request){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        TComments comment = new TComments();
        comment.setPoem_id(request.getParameter("poem_id"));
        comment.setContent(request.getParameter("content"));
        comment.setUser_name(request.getParameter("user_name"));
        comment.setUser_avatar(request.getParameter("user_avatar"));
        comment.setCreate_time(date);
        System.out.println(date);
        tCommentsMapper.insert(comment);
        return comment;
    }



}
