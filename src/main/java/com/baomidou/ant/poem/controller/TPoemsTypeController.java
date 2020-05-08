package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.ResultInfo;
import com.baomidou.ant.poem.entity.TPoemsType;
import com.baomidou.ant.poem.mapper.TPoemsTypeMapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/poem/t-poems-type")
public class TPoemsTypeController {
    ResultInfo resultInfo = new ResultInfo();

    @Resource
    TPoemsTypeMapper tPoemsTypeMapper;

    @GetMapping("/search/all")
    public ResultInfo getPoem(@Param("page") int pagecount) {
        Page<TPoemsType> page = new Page<>(pagecount, 5);
        tPoemsTypeMapper.selectPage(page, null);


        Map<String, Object> map = new HashMap<>();
        int count = page.getRecords().size();
        map.put("page", pagecount);
        map.put("count", count);
        map.put("list", page.getRecords());

        resultInfo.setStatus(200);
        resultInfo.setMsg("第" + pagecount + "页数据");
        resultInfo.setData(map);
        return resultInfo;

    }


}
