package com.xiangyang.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@MapperScan("com.xiangyang.mapper")
public class MyBatisPlusConfig {
    //指定使用默认分页
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        System.out.println("走了分页");
//        return paginationInterceptor;
//    }


    //--------指定使用pageHelper插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        System.out.println("是否走了这个");
        return configuration -> configuration.addInterceptor(new com.github.pagehelper.PageInterceptor());
    }
}
