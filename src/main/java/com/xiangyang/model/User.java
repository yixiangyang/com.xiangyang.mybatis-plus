package com.xiangyang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;


@Data

@TableName("user0")
@ToString
public class User {
    private  String name;
    private Integer age;
    @TableId
    private Long id;
    private Timestamp createTime;

}
