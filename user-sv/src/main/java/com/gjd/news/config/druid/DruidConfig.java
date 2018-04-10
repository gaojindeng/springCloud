package com.gjd.news.config.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig {
	
	
	@Bean
	@ConfigurationProperties(prefix="spring.druid")
	public DruidDataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
}

