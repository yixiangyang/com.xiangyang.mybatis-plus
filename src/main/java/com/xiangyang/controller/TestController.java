package com.xiangyang.controller;//package com.xiangyang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiangyang.exception.CodeException;
import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.User;
import com.xiangyang.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class TestController {

    @Resource
    private UserMapper userMapper;

    @Value( "${server.port}" )
    String port;

    @GetMapping("hi")
    public String hi(String name) {
        log.debug( "debug log..." );
        log.info( "info log..." );
        log.warn( "warn log..." );
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/test")
    public PageInfo getUser(){
        com.github.pagehelper.Page<User> pp= PageHelper.startPage(1,3);
        throw new CodeException("s101","消息");
//        PageInfo aa = new PageInfo(userMapper.getUserList(pp));
//        return aa;
    }

    @GetMapping("/test1")
    public Future<IPage<UserVO>>  getUser1() throws InterruptedException {
        Page<User> page = new Page<>(1l,3l);
        QueryWrapper queryWrapper = new QueryWrapper<>();

        IPage<UserVO> iPage = userMapper.getUsers(page,queryWrapper);
        return new AsyncResult<IPage<UserVO>>(iPage);
    }
}
