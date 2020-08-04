package lulski.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lulski.model.Post;

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