package com.xiangyang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiangyang.model.User;
import com.xiangyang.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select u.id uId,u.name uName,tu.id tId,tu.name tName" +
            " from user0 u left join test_user tu on u.id =tu.id where u.id=1")
    List<UserVO> getUser();

}
