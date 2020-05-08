package com.baomidou.ant.poem.controller;


import com.baomidou.ant.poem.entity.ResultInfo;
import com.baomidou.ant.poem.entity.TPoemsBooks;
import com.baomidou.ant.poem.entity.TPoemsType;
import com.baomidou.ant.poem.mapper.TPoemsBooksMapper;
import com.baomidou.ant.poem.mapper.TPoemsTypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Array;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-21
 */
@RestController
public class TPoemsBooksController {

    public static int thepageSize;

    ResultInfo resultInfo = new ResultInfo();

    @Resource
    TPoemsBooksMapper tPoemsBooksMapper;

    @GetMapping("/book/search/all")
    public ResultInfo getBook(@Param("page") int pagecount) {
        Page<TPoemsBooks> page = new Page<>(pagecount, 5);
        tPoemsBooksMapper.selectPage(page, null);
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


    @GetMapping("/api/query/book")
    public Object getBooks(HttpServletRequest request) throws UnsupportedEncodingException {
//            @RequestParam("current") int currtent, @RequestParam("pageSize") int pageSize
//                           ,@RequestParam("name") String name, @RequestParam("author") String author
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int current = Integer.parseInt(request.getParameter("current"));
        thepageSize = pageSize;
        Page<TPoemsBooks> page = new Page<>(current, pageSize);
        if (request.getParameter("name")==null&&request.getParameter("author")==null){
            tPoemsBooksMapper.selectPage(page, null);

        }else if (request.getParameter("name")!=null&&request.getParameter("author")==null){
            String name = URLDecoder.decode(request.getParameter("name"),"GBK");
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("name", name);
            tPoemsBooksMapper.selectPage(page, queryWrapper);
        }else if(request.getParameter("name")==null&&request.getParameter("author")!=null){
            String name = null;
            String author = URLDecoder.decode(request.getParameter("author"),"GBK");
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("author", author);
            tPoemsBooksMapper.selectPage(page, queryWrapper);
        }else {
            String name = URLDecoder.decode(request.getParameter("name"),"GBK");
            String author = URLDecoder.decode(request.getParameter("author"),"GBK");
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("name", name);
            queryWrapper.eq("author", author);
            tPoemsBooksMapper.selectPage(page, queryWrapper);
        }
        HashMap<Object, Object> map = new HashMap();
        map.put("data", page.getRecords());
        map.put("total", page.getTotal());
        map.put("pageSize", pageSize);
        map.put("current", current);
        return map;
    }

    @PostMapping("/api/add/book")
    public Object addBook(@RequestBody Map<String, String> reqmap) throws ParseException {
        System.out.println(reqmap + "123");
        TPoemsBooks book = new TPoemsBooks();
        book.setName(reqmap.get("name"));
        book.setAuthor(reqmap.get("author"));
        book.setMemo(reqmap.get("memo"));
        book.setPublisher(reqmap.get("publisher"));


        String publishtime = reqmap.get("publishtime");
        System.out.println("publishtime:" + publishtime);
        String[] split = publishtime.split("\\.");
        System.out.println(split.length);
        String newJDate = split[0].replaceAll("T", " ");
        System.out.println("newJdata:" + newJDate);

//        String dateString = "2019-04-30 15:59:10";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(newJDate);
        System.out.println("data:" + date);
        Timestamp timestamp = new Timestamp(date.getTime());
        book.setPublishtime(timestamp);
        System.out.println(book + "2222");
        book.setStudyphase(reqmap.get("studyphase"));
        book.setMemo(reqmap.get("memo"));

        System.out.println(book);
        tPoemsBooksMapper.insert(book);
        HashMap<Object, Object> mesmap = new HashMap();
        HashMap<Object, Object> map = new HashMap();
        Page<TPoemsBooks> page = new Page<>(1, thepageSize);
        tPoemsBooksMapper.selectPage(page, null);
        map.put("list", page.getRecords());
        mesmap.put("total", page.getTotal());
        map.put("pagination", mesmap);
        return map;

    }

    @PostMapping("/api/remove/book")
    public void removeBooks(@RequestBody Map<String, Object> reqmap) {
        System.out.println(reqmap.get("key"));
        System.out.println(reqmap.get("key").getClass());
        ArrayList list = new ArrayList();
        list = (ArrayList) reqmap.get("key");
        for (Object i : list) {
            tPoemsBooksMapper.deleteById(((int) i));
            System.out.println((int) i);
        }
    }

    @PostMapping("/api/update/book")
    public Object updateBooks(@RequestBody Map<String, String> reqmap) throws ParseException {
        TPoemsBooks book = new TPoemsBooks();
        book.setId(Integer.parseInt(reqmap.get("id")));
        System.out.println("id"+book.getId());
        book.setName(reqmap.get("name"));
        book.setAuthor(reqmap.get("author"));
        book.setMemo(reqmap.get("memo"));
        book.setPublisher(reqmap.get("publisher"));


        String publishtime = reqmap.get("publishtime");
        System.out.println("publishtime:" + publishtime);
        String[] split = publishtime.split("\\.");
        System.out.println(split.length);
        String newJDate = split[0].replaceAll("T", " ");
        System.out.println("newJdata:" + newJDate);

//        String dateString = "2019-04-30 15:59:10";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(newJDate);
        System.out.println("data:" + date);
        Timestamp timestamp = new Timestamp(date.getTime());
        book.setPublishtime(timestamp);
        book.setStudyphase(reqmap.get("studyphase"));
        System.out.println("studyphase"+reqmap.get("studyphase"));

        book.setMemo(reqmap.get("memo"));
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id",book.getId());
        tPoemsBooksMapper.update(book,updateWrapper);
        HashMap<Object, Object> mesmap = new HashMap();
        HashMap<Object, Object> map = new HashMap();
        Page<TPoemsBooks> page = new Page<>(1, thepageSize);
        tPoemsBooksMapper.selectPage(page, null);
        map.put("list", page.getRecords());
        mesmap.put("total", page.getTotal());
        map.put("pagination", mesmap);
        return map;
    }

}
