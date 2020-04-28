package com.xiangyang.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.User;
import com.xiangyang.service.UserService;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(1l);
        user.setName("这个是测试mybatis-plus");
        userMapper.insert(user);
    }

    @Test
    public void te(){
//        User user = new User();
//        user.setId(3l);
//        user.setName("这个是测试mybatis-plus2");
//        userMapper.insert(user);
       System.out.println( userMapper.selectById(1l));
    System.out.println( userMapper.selectPage(new Page<User>(1,10),new QueryWrapper<User>().like("name","测试").orderByDesc("create_time")).getRecords());
    }

    @Test
    public void getUsers(){
        System.out.println(userMapper.getUser());
    }

}
