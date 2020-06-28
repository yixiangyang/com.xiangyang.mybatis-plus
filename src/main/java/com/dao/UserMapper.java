package com.dao;

import com.dao.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}