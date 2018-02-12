package com.deng.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.deng.util.DatabaseType;
import com.deng.util.DynamicDataSource;

/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration // 该注解类似于spring配置文件
public class MyBatisConfig implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }
    
    
    @Bean
    @Primary
    @Scope("singleton")
    public DynamicDataSource dataSource() throws Exception {
        Map<Object, Object> targetDataSources = new HashMap<>();
        
        Properties props = new Properties();
        props.put("driverClassName", environment.getProperty("test1-datasource.driverClassName"));
        props.put("url", environment.getProperty("test1-datasource.url"));
        props.put("username", environment.getProperty("test1-datasource.username"));
        props.put("password", environment.getProperty("test1-datasource.password"));
        DataSource ds1 = DruidDataSourceFactory.createDataSource(props);

        props.put("driverClassName", environment.getProperty("test2-datasource.driverClassName"));
        props.put("url", environment.getProperty("test2-datasource.url"));
        props.put("username", environment.getProperty("test2-datasource.username"));
        props.put("password", environment.getProperty("test2-datasource.password"));
        DataSource ds2 = DruidDataSourceFactory.createDataSource(props);

        targetDataSources.put(DatabaseType.database1, ds1);
        targetDataSources.put(DatabaseType.database2, ds2);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(ds2);// 默认的datasource设置为test2DataSource
        return dataSource;
    }


    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    	sessionFactoryBean.setDataSource(ds);
    	
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        RelaxedPropertyResolver propertyResolver =new RelaxedPropertyResolver(environment,"mybatis.");
        sessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("type-aliases-package"));
        sessionFactoryBean.setMapperLocations(resolver.getResources(propertyResolver.getProperty("mapper-locations")));
        
        return sessionFactoryBean.getObject();
    }



    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}