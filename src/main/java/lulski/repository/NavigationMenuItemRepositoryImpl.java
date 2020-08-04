package lulski.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import lulski.model.NavigationMenuItem;

/**
 * NavigationMenuItemRepositoryImpl
 */
public class NavigationMenuItemRepositoryImpl implements NavigationMenuItemCustomRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public NavigationMenuItem save(NavigationMenuItem model) {

    System.out.println("saving from custom save()");
    mongoTemplate.save(model);

    return model;
  }

}