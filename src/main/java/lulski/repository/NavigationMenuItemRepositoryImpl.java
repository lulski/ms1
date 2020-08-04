package lulski.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import lulski.model.NavigationMenuItem;

/**
 * NavigationMenuItemRepositoryImpl
 */
public class NavigationMenuItemRepositoryImpl implements NavigationMenuItemCustomRepository {

  @Autowired
  private MongoOperations mongoOperations;

  @Override
  public NavigationMenuItem save(NavigationMenuItem model) {

    mongoOperations.save(model);

    return model;
  }

}