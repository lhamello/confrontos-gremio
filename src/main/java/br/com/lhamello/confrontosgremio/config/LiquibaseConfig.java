package br.com.lhamello.confrontosgremio.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfig {

  @Autowired
  private DataSource dataSource;
  
  @Bean
  public SpringLiquibase configureLiquibase() {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:db/liquibase-changelog.xml");
    liquibase.setDataSource(dataSource);
    return liquibase;
  }
}
