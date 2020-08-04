package lulski.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import lulski.model.NavigationMenuItem;

@Repository
public interface NavigationMenuItemRepository
    extends MongoRepository<NavigationMenuItem, String>, NavigationMenuItemCustomRepository {

  public NavigationMenuItem findById(long id);

}