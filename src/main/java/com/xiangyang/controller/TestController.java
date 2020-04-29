package com.xiangyang.controller;//package com.xiangyang.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.User;
import com.xiangyang.model.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;

//    @GetMapping("/test")
//    public IPage<UserVO> getUser(){
//        Page<User> page = new Page<>(1l,3l);
//        IPage<UserVO> iPage = userMapper.getUsers(page);
//        return iPage;
//    }
}
