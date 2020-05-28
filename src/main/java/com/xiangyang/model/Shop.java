package com.xiangyang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@TableName("shops")
public class Shop {
    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;


    private String code;

    private String enabled;

    private String level;

    private String address;

    private String phone;

    private String memo;

    private String begin_time;

    private String end_time;

    private String open_date;

    private String close_date;

    private Date created;

    private Date modified;

    private Integer division_id;

    @TableField(exist = false)
    private List<Dept> depts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dept{
        private Integer deptId;

        private String deptName;
    }
}
