package com.fitt.gbt.qbank.common;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : MybatisPlus配置类
 * @since : 2018/10/14
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.fitt.gbt.qbank.mapper*")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
