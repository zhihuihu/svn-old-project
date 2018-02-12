package com.hxkj.waychat;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages={"com.hxkj.waychat.dao"})
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
	
	
	private static Logger logger = Logger.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis/config.xml"));
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/hxkj/waychat/mapper/*Mapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.hxkj.waychat.entity,com.hxkj.waychat.entity.query,com.hxkj.waychat.entity.result");
		return sqlSessionFactoryBean.getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("============= SpringBoot Start Success =============");
	}
}
