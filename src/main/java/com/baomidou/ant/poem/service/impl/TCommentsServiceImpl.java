package com.baomidou.ant.poem.service.impl;

import com.baomidou.ant.poem.entity.TComments;
import com.baomidou.ant.poem.mapper.TCommentsMapper;
import com.baomidou.ant.poem.service.ITCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-17
 */
@Service
public class TCommentsServiceImpl extends ServiceImpl<TCommentsMapper, TComments> implements ITCommentsService {

}
