package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.ResultInfo;
import com.baomidou.ant.poem.entity.TPoemsPoem;
import com.baomidou.ant.poem.entity.TPoemsType;
import com.baomidou.ant.poem.mapper.TPoemsPoemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */
@RestController
public class TPoemsPoemController{
    ResultInfo resultInfo = new ResultInfo();
    @Resource
    TPoemsPoemMapper tpoemsPoemMapper;

    @PostMapping("/poem/create")
    public ResultInfo addPoem(TPoemsPoem poem){
        tpoemsPoemMapper.insert(poem);
        resultInfo.setStatus(200);
        resultInfo.setMsg("添加成功");
        return resultInfo;
    }

    @DeleteMapping("/poem/delete")
    public ResultInfo deletePoem(@Param("id") Long id){
        tpoemsPoemMapper.deleteById(id);
        resultInfo.setStatus(200);
        resultInfo.setMsg("删除成功");
        return resultInfo;
    }

    @PutMapping("/poem/update")
    public ResultInfo updatePoem(TPoemsPoem poem){
        resultInfo.setStatus(200);
        tpoemsPoemMapper.updateById(poem);
        resultInfo.setMsg("更新成功");
        return resultInfo;
    }

    @GetMapping("/search/name")
    public ResultInfo getPoem(@Param("pagecount") int pagecount,@Param("name")String name){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);

        Page<TPoemsPoem> page = new Page<>(pagecount, 5);
        tpoemsPoemMapper.selectPage(page, queryWrapper);
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



    @GetMapping("/getPoemList")
    public ResultInfo getPoemList(){
        resultInfo.setMsg("查询成功");
        resultInfo.setStatus(200);
        Page<TPoemsPoem> page = new Page<>(1, 10);
        resultInfo.setData(tpoemsPoemMapper.selectPage(page,null).getRecords());
        return resultInfo;

    }

}
