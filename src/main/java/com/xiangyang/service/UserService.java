package com.xiangyang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiangyang.model.User;

public interface UserService extends IService<User> {
    public void addUser(User user);

}
