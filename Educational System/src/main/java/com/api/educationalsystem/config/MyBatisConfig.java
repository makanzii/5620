package com.api.educationalsystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.api.educationalsystem.mapper")
public class MyBatisConfig {
}
