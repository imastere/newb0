package com.baomidou.ant.poem.service.impl;

import com.baomidou.ant.poem.entity.TUserInfo;
import com.baomidou.ant.poem.mapper.TUserInfoMapper;
import com.baomidou.ant.poem.service.ITUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-03
 */
@Service
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements ITUserInfoService {

//    TUserInfoMapper tUserInfoMapper;
//
//    public Object currentUser(HttpSession session, HttpServletResponse response) {
//        HashMap<Object, Object> map = new HashMap();
//        if (session.getAttribute("userid") != null) {
//            Integer userid = (Integer) session.getAttribute("userid");
//            System.out.println("userid" + userid);
//            QueryWrapper queryWrapper = new QueryWrapper();
//            queryWrapper.eq("userid", userid);
//            TUserInfo tUserInfo = tUserInfoMapper.selectOne(queryWrapper);
//            session.setAttribute("user", tUserInfo);
//            session.setAttribute("owner", tUserInfo.getName());
//            return tUserInfo;
//        } else {
////            response.sendRedirect("/user/login");
//            TUserInfo tUserInfo = new TUserInfo();
//            tUserInfo.setName("guest");
//            return tUserInfo;
//        }
//    }




}
