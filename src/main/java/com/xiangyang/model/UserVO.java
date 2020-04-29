package com.xiangyang.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVO {
    private Long uId;

    private String uName;

    private Long tId;

    private String tName;

}
