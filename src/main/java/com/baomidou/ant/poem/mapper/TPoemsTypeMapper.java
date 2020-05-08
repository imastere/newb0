package com.baomidou.ant.poem.mapper;

import com.baomidou.ant.poem.entity.TPoemsPoem;
import com.baomidou.ant.poem.entity.TPoemsType;
import com.baomidou.ant.poem.entity.TSysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */
public interface TPoemsTypeMapper extends BaseMapper<TPoemsType> {

    /**
     * 和Mybatis使用方法一致
     *
     * @param
     * @return
     */
    @Select("SELECT * FROM t_poems_poem")
    List<TPoemsType> selectAll();



    IPage<TSysUser> selectPage(Page<?> page);

}
