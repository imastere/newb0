package com.baomidou.ant.poem.mapper;

import com.baomidou.ant.poem.entity.TPoemsPoem;
import com.baomidou.ant.poem.entity.TSysUser;
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
public interface TSysUserMapper extends BaseMapper<TSysUser> {



    /**
     * 和Mybatis使用方法一致
     * @param username
     * @return
     */
    @Select("SELECT * FROM t_sys_user where username = #{username}")
    TSysUser selectByUsername(@Param("username") String username);




}
