package lulski.model.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import lulski.model.NavigationMenuItem;

public interface NavigationMenuItemRepository extends MongoRepository<NavigationMenuItem, String> {

  public NavigationMenuItem findByText(String text);

}