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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@MapperScan(basePackages={"com.tiandd.ssth.mapper.oracle"}, sqlSessionFactoryRef="oracleSqlSessionFactory")
public class OracleDataSourceConfig
{

  @Value("${spring.datasource.oracle.type}")
  private Class<? extends DataSource> dataSourceType;

  @Bean(name={"oracleDataSource"})
  @ConfigurationProperties(prefix="spring.datasource.oracle")
  @Primary
  public DataSource writeDataSource()
  {
    return DataSourceBuilder.create().type(this.dataSourceType).build();
  }

  @Bean(name={"oracleSqlSessionFactory"})
  @Primary
  public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource)
    throws Exception
  {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setVfs(SpringBootVFS.class);
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/tiandd/ssth/mapper/oracle/*.xml"));
    return bean.getObject();
  }

  @Bean(name={"oracleTransactionManager"})
  @Primary
  public DataSourceTransactionManager TransactionManager(@Qualifier("oracleDataSource") DataSource dataSource)
  {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name={"studentSqlSessionTemplate"})
  @Primary
  public SqlSessionTemplate SqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    throws Exception
  {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
