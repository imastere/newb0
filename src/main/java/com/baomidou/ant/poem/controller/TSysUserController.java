package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.ResultInfo;
import com.baomidou.ant.poem.entity.TPoemsBooks;
import com.baomidou.ant.poem.entity.TPoemsPoem;
import com.baomidou.ant.poem.entity.TSysUser;
import com.baomidou.ant.poem.mapper.TSysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */

@RestController
@Slf4j
public class TSysUserController {
    @Resource
    TSysUserMapper tSysUserMapper;
    ResultInfo resultInfo = new ResultInfo();
    Logger logger = LoggerFactory.getLogger(TSysUserController.class);

    //    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/userlogin")
    public ResultInfo loginUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        TSysUser user = tSysUserMapper.selectByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                resultInfo.setStatus(200);
                logger.info(username+"登陆");
                resultInfo.setMsg("欢迎" + username + "登陆");
                resultInfo.setData(user);
            } else {
                resultInfo.setStatus(400);
                resultInfo.setMsg("登陆失败请校验输入的是否正确");
            }
        } else {
            resultInfo.setStatus(400);
            resultInfo.setMsg("登陆失败请校验输入的是否正确");
        }
        System.out.println(username + "登陆");
        return resultInfo;

    }


    //注册
    @PostMapping("/register")
    public ResultInfo registerUser(HttpServletRequest request) {
        String email = request.getParameter("email");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(password);
        TSysUser tSysUser = new TSysUser();
        tSysUser.setEmail(email);
        tSysUser.setUsername(account);
        tSysUser.setPassword(password);
        tSysUserMapper.insert(tSysUser);
        resultInfo.setStatus(200);
        resultInfo.setMsg("注册成功");
        logger.info(account+"注册 ");
        return resultInfo;
    }

    @PostMapping("/login")
    public ResultInfo login(@RequestBody Map<String, String> map) {
        String email = map.get("email");
        String password = map.get("password");
        TSysUser tSysUser = new TSysUser();
        tSysUser.setEmail(email);
        tSysUser.setPassword(password);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("email", email);
        queryWrapper.eq("password", password);
        if (tSysUserMapper.selectOne(queryWrapper) != null) {
            resultInfo.setStatus(200);
            resultInfo.setMsg("登陆成功");
            return resultInfo;
        } else {
            resultInfo.setStatus(400);
            resultInfo.setMsg("登陆失败");
            return resultInfo;
        }

    }


    @PutMapping("/update")
    public ResultInfo updateUser(TSysUser user) {
        tSysUserMapper.updateById(user);
        resultInfo.setMsg("更新用户信息成功");
        resultInfo.setData(user);
        return resultInfo;

    }


    @PostMapping("/api/login/account")
    public Object login(HttpSession session, @RequestBody Map<String, String> user, HttpServletRequest request) {
        Enumeration em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        String username = user.get("userName");
        String password = user.get("password");
        System.out.println("username:"+username);
        String type = user.get("type");
        HashMap<Object, Object> map = new HashMap();
        TSysUser loginuser = tSysUserMapper.selectByUsername(username);
        if (loginuser!=null) {
            if (loginuser.getPassword().equals(password)) {
                if (loginuser.getStatus().equals(1)) {
                    map.put("status", "ok");
                    map.put("type", "account");
                    map.put("currentAuthority", "admin");
                    session.setAttribute("username", username);
                    session.setAttribute("power", "admin");
                    session.setAttribute("userid", loginuser.getId());
                } else if (loginuser.getStatus().equals(2)) {
                    map.put("status", "ok");
                    map.put("type", "account");
                    map.put("currentAuthority", "user");
                    session.setAttribute("power", "user");
                    session.setAttribute("username", username);
                }
            } else {
                map.put("status", "error");
                map.put("type", "account");
                map.put("currentAuthority", "guest");
            }
        }else {
            map.put("status", "error");
            map.put("type", "account");
            map.put("currentAuthority", "guest");
        }
        return map;
    }


    @GetMapping("/api/login/outLogin")
    public Object outLogin() {
        HashMap<Object, Object> map = new HashMap();
        map.put("data", "{}");
        map.put("success", "true");
        return map;
    }

    @GetMapping("/api/500")
    public Object fiveoo() {
        HashMap<Object, Object> map = new HashMap();
        map.put("timestamp", "1513932555104");
        map.put("status", 500);
        map.put("message", "error");
        map.put("path", "/base/category/list");
        return map;
    }

    @GetMapping("/api/404")
    public Object fourofour() {
        HashMap<Object, Object> map = new HashMap();
        map.put("timestamp", "1513932643431");
        map.put("status", 404);
        map.put("error", "Unauthorized");
        map.put("message", "Not Found");
        map.put("path", "/base/category/list/2121212");
        return map;
    }

    @GetMapping("/api/403")
    public Object fourotree() {
        HashMap<Object, Object> map = new HashMap();
        map.put("timestamp", "1513932555104");
        map.put("status", 403);
        map.put("error", "Unauthorized");
        map.put("message", "Unauthorized");
        map.put("path", "/base/category/list");
        return map;
    }

    @GetMapping("/api/401")
    public Object fouroone() {
        HashMap<Object, Object> map = new HashMap();
        map.put("timestamp", "1513932555104");
        map.put("status", 401);
        map.put("error", "Unauthorized");
        map.put("message", "Unauthorized");
        map.put("path", "/base/category/list");
        return map;
    }

    @GetMapping("/api/query/user")
    public Object getBooks(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int current = Integer.parseInt(request.getParameter("current"));

        Page<TSysUser> page = new Page<>(current, pageSize);
        if (session.getAttribute("power").equals("admin")) {
            if (request.getParameter("username") == null && request.getParameter("email") == null) {
                tSysUserMapper.selectPage(page, null);
            } else if (request.getParameter("username") != null && request.getParameter("email") == null) {
                String name = URLDecoder.decode(request.getParameter("username"), "GBK");
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("username", name);
                tSysUserMapper.selectPage(page, queryWrapper);
            } else if (request.getParameter("username") == null && request.getParameter("email") != null) {
                String email = URLDecoder.decode(request.getParameter("email"), "GBK");
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("email", email);
                tSysUserMapper.selectPage(page, queryWrapper);
            } else {
                String username = URLDecoder.decode(request.getParameter("username"), "GBK");
                String email = URLDecoder.decode(request.getParameter("email"), "GBK");
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("username", username);
                queryWrapper.eq("email", email);
                tSysUserMapper.selectPage(page, queryWrapper);
            }
            HashMap<Object, Object> map = new HashMap();
            map.put("data", page.getRecords());
            map.put("total", page.getTotal());
            map.put("pageSize", pageSize);
            map.put("current", current);
            return map;
        } else
            return null;
    }

    @PostMapping("/api/giveadmin/user")
    public Object giveAdmintoUser(HttpSession session, @RequestBody Map<String, String> reqmap) {
        int id = Integer.parseInt(reqmap.get("id"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        TSysUser tSysUser = tSysUserMapper.selectOne(queryWrapper);
        tSysUser.setStatus(1);
        tSysUserMapper.updateById(tSysUser);
        HashMap<String, String> resmap = new HashMap<>();
        resmap.put("message", "ok");
        return resmap;
    }

    @PostMapping("/api/setUserGeneral/user")
    public Object setUserGeneral(HttpSession session, @RequestBody Map<String, String> reqmap) {
        int id = Integer.parseInt(reqmap.get("id"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        TSysUser tSysUser = tSysUserMapper.selectOne(queryWrapper);
        tSysUser.setStatus(2);
        tSysUserMapper.updateById(tSysUser);
        HashMap<String, String> resmap = new HashMap<>();
        resmap.put("message", "ok");
        return resmap;
    }

    @PostMapping("/api/setUserBan/user")
    public Object setUserBan(HttpSession session, @RequestBody Map<String, String> reqmap) {
        int id = Integer.parseInt(reqmap.get("id"));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        TSysUser tSysUser = tSysUserMapper.selectOne(queryWrapper);
        tSysUser.setStatus(0);
        tSysUserMapper.updateById(tSysUser);
        HashMap<String, String> resmap = new HashMap<>();
        resmap.put("message", "ok");
        return resmap;
    }


}
