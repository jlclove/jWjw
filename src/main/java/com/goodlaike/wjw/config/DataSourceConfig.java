package com.goodlaike.wjw.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
class DataSourceConfig {

  public final static String BEANNAME_DATASOURCE_COMMON = "wjw.dataSource";
  public final static String BEANNAME_SQLSESSION_COMMON = "wjw.sqlsession";
  public final static String BEANNAME_TRANSACTION_MANAGER = "wjw.transactionmanager";

  /**
   * 普通数据源
   * 
   * @return
   */
  @Primary // 主数据源，必须配置，spring启动时会执行初始化数据操作（无论是否真的需要），选择查找DataSource class类型的数据源
  @Bean(name = BEANNAME_DATASOURCE_COMMON)
  @ConfigurationProperties(prefix = "com.goodlaike.wjw.datasource")
  public DataSource createDataSourceCommon() {
    return DataSourceBuilder.create().build();
  }

  /**
   * 配置事务
   * 
   * @param dataSource 数据源
   * @return DataSourceTransactionManager
   * @author Jail Hu
   */
  @Resource(name = BEANNAME_DATASOURCE_COMMON)
  @Bean(name = BEANNAME_TRANSACTION_MANAGER)
  public DataSourceTransactionManager createDataSourceTransactionManager() {
    DataSource dataSource = this.createDataSourceCommon();
    DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
    return manager;
  }

  /**
   * 实例普通的 sqlSession
   * 
   * @return SqlSession
   * @throws Exception
   * @summary 实例普通的 sqlSession
   * @author Jail Hu
   * @version v1
   * @since 2016年12月6日 上午10:49:29
   */
  @Bean(name = BEANNAME_SQLSESSION_COMMON)
  public SqlSession initSqlSessionCommon() throws Exception {
    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    factory.setDataSource(this.createDataSourceCommon());
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    factory.setConfigLocation(resolver.getResource("mybatis/mybatis-config.xml"));
    factory.setMapperLocations(resolver.getResources("mybatis/mappers/**/*.xml"));
    return new SqlSessionTemplate(factory.getObject());
  }
}
