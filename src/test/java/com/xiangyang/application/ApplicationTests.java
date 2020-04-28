package com.xiangyang.application;

import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.User;
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

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(1l);
        user.setName("这个是测试mybatis-plus");
        userMapper.insert(user);
    }

}
