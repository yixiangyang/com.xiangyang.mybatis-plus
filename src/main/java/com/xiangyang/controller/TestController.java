package com.xiangyang.controller;//package com.xiangyang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @GetMapping("/test")
    public PageInfo getUser(){
        com.github.pagehelper.Page<User> pp= PageHelper.startPage(1,3);

        PageInfo aa = new PageInfo(userMapper.getUserList(pp));
        return aa;
    }

    @GetMapping("/test1")
    public IPage<UserVO> getUser1(){
        Page<User> page = new Page<>(1l,3l);
        QueryWrapper queryWrapper = new QueryWrapper<>();

        IPage<UserVO> iPage = userMapper.getUsers(page,queryWrapper);
        return iPage;
    }
}
