package com.xiangyang.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiangyang.esearch.ESClient;
import com.xiangyang.esearch.xiangyangDefaultEsClient;
import com.xiangyang.mapper.ShopMapper;
import com.xiangyang.mapper.TestUserMapper;
import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.Shop;
import com.xiangyang.model.TestUser;
import com.xiangyang.model.User;
import com.xiangyang.model.UserVO;
import com.xiangyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Resource
    private TestUserMapper testUserMapper;
    @Resource
    private ShopMapper shopMapper;
    @Autowired
    private ESClient esClient;
    @Test
    public void addShop() throws JsonProcessingException {
        List<User> users =userMapper.selectList(new QueryWrapper<>());
        System.out.println(users.size());
        xiangyangDefaultEsClient defaultEsClient = new xiangyangDefaultEsClient();
        List<Shop> shops = shopMapper.selectList(new QueryWrapper<Shop>());

        System.out.println("这个是获取的门店大小"+shops.size());
        for(Shop shop:shops){
            System.out.println("这个是门店id："+shop.getId());
            List<Shop.Dept> depts = new ArrayList<>();
            depts.add(new Shop.Dept(1,"部门名字"));
            depts.add(new Shop.Dept(2,"部门名字2"));
            shop.setDepts(depts);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(shop);
            esClient.indexDocument("shops",String.valueOf(shop.getId()),jsonString);
        }

    }

    @Test
    public void  getShop(){
        System.out.println(esClient.getDocument("shops","1178"));
    }

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
        Page<User> page = new Page<>(1l,3l);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u.id","10");
        IPage<UserVO> iPage = userMapper.getUsers(page,queryWrapper);
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getTotal());
        com.github.pagehelper.Page<User> pp= PageHelper.startPage(1,3);

        PageInfo aa = new PageInfo(userMapper.getUserList(pp));
        System.out.println("这个是使用pageInfo:"+aa.toString());
        System.out.println("这个是使用pageHelper"+aa.getList().toString());
    }

    @Test
    public void testaaa(){
        Map<String,String> map = new HashMap<>();
        map.put("name","测试1");
        map.put("id","5000");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.allEq(map);
        //condition 是否包含这个条件
        queryWrapper.allEq(true,map,true);
        List<User> users = userService.list(queryWrapper);
//        Map<String ,Object> responseMap =  userService.getMap(queryWrapper);
        System.out.println(users.toString());
        System.out.println("这个是有几条数据"+users.size());
    }

    @Test
    public void addTestUser(){
        TestUser testUser = new TestUser();
        testUser.setName("这个是mybatis_plus测试");
        testUserMapper.insert(testUser);
        System.out.println("这个是获取的testUserid:"+testUser.getId());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id");
        List<User> users = userService.list(queryWrapper);
        users.forEach(user -> System.out.println(user.toString()));
    }

    public static void main(String[] args) {
//        System.out.println(LocalDateUtil.getCurrentDate());
    }
}
