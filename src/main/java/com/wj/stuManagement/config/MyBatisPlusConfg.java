package com.wj.stuManagement.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: WangJin
 * @description
 * @date: 2021/10/5 19:29
 */
@Configuration
@MapperScan("com.wj.stuManagement.mapper")
public class MyBatisPlusConfg {
}
