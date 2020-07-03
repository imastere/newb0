package com.baomidou.ant.poem.service.impl;
import java.sql.SQLException;


import com.baomidou.ant.poem.exception.MyException;
import com.baomidou.ant.poem.mapper.TestExceptionDao;
import com.baomidou.ant.poem.service.TestExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("testExceptionService")
public class TestExceptionServiceImpl implements TestExceptionService {
    @Autowired
    private TestExceptionDao testExceptionDao;
    @Override
    public void servicemy() throws Exception {
        throw new MyException("Service中自定义异常");
    }
    @Override
    public void servicedb() throws Exception {
        throw new SQLException("Service中数据库异常");
    }
    @Override
    public void serviceno() throws Exception {
        throw new Exception("Service中未知异常");
    }
    @Override
    public void daomy() throws Exception {
        testExceptionDao.daomy();
    }
    @Override
    public void daodb() throws Exception {
        testExceptionDao.daodb();
    }
    public void daono() throws Exception{
        testExceptionDao.daono();
    }
}