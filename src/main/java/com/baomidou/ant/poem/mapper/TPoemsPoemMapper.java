package com.baomidou.ant.poem.mapper;

import com.baomidou.ant.poem.entity.TPoemsPoem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */
public interface TPoemsPoemMapper extends BaseMapper<TPoemsPoem> {

    /**
     * 和Mybatis使用方法一致
     * @param name
     * @return
     */
    @Select("SELECT * FROM t_poems_poem where name = #{name}")
    List<TPoemsPoem> selectByName(@Param("name") String name);



}
