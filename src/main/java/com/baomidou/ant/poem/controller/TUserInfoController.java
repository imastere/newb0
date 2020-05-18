package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.TPoemsBooks;
import com.baomidou.ant.poem.entity.TUserInfo;
import com.baomidou.ant.poem.mapper.TUserInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-03
 */
@RestController
public class TUserInfoController {
    @Resource
    TUserInfoMapper tUserInfoMapper;

    @GetMapping("/api/currentUser")
    public Object currentUser(HttpSession session, HttpServletResponse response) throws IOException {
        HashMap<Object, Object> map = new HashMap();
        if (session.getAttribute("userid") != null) {
            Integer userid = (Integer) session.getAttribute("userid");
            System.out.println("userid" + userid);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("userid", userid);
            TUserInfo tUserInfo = tUserInfoMapper.selectOne(queryWrapper);
            session.setAttribute("user", tUserInfo);
            session.setAttribute("owner", tUserInfo.getName());
            return tUserInfo;
        } else {
//            response.sendRedirect("/user/login");
            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setName("guest");
            return tUserInfo;
        }
    }





    @PostMapping("/accountsettings")
    public Object accountsettings(HttpSession session,@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Model m) {
        try {
            System.out.println("上传图片");
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String randomname =  File.separator + fileName;
            String destFileName = request.getServletContext().getRealPath("") + "uploade" + randomname;
            System.out.println(destFileName);
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            m.addAttribute("fileName", fileName);

            Integer userid = (Integer) session.getAttribute("userid");
            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setAvatar("http://localhost:8001/uploade/"+randomname);
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("userid",userid);
            tUserInfoMapper.update(tUserInfo,updateWrapper);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImg";
    }



}
