package com.gongjun.im.core.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author:GongJun
 * @Date:2019/1/18
 */

@Configuration
public class MyBatisPlusConfig {
    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 设置数据库类型
        page.setDialectType("postgresql");
        return page;
    }
}
