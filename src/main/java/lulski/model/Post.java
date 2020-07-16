package lulski.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Post {


  @PostConstruct
  public void postConstruct(){
    System.out.println( ">>> Post object postconstruct");
  }


  @PreDestroy
  public void preDestroy(){
    System.out.println( ">>> Post object preDestroy");
  }

  public int save(){
      return 0;
  }
}