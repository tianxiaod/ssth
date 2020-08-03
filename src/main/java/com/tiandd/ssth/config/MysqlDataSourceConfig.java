package com.tiandd.ssth.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages={"com.tiandd.ssth..mapper.mysql"}, sqlSessionFactoryRef="mysqlSqlSessionFactory")
public class MysqlDataSourceConfig
{

  @Value("${spring.datasource.mysql.type}")
  private Class<? extends DataSource> dataSourceType;

  @Bean(name={"mysqlDataSource"})
  @ConfigurationProperties(prefix="spring.datasource.mysql")
  public DataSource writeDataSource()
  {
    return DataSourceBuilder.create().type(this.dataSourceType).build();
  }

  @Bean(name={"mysqlSqlSessionFactory"})
  public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource)
    throws Exception
  {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setVfs(SpringBootVFS.class);
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/tiandd/ssth/mapper/mysql/*.xml"));
    return bean.getObject();
  }

  @Bean(name={"mysqlTransactionManager"})
  public DataSourceTransactionManager TransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource)
  {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name={"mysqlSqlSessionTemplate"})
  public SqlSessionTemplate SqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    throws Exception
  {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
