package lulski.model;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {

  @Bean
  public Post post() {
    return new Post();
  }

  @Bean
  public DataSource dataSource() {
    System.out.println(">>> PostConfig.dataSource is initialized ");
    return null;
  }

}