package lulski.repository;

import org.springframework.data.repository.NoRepositoryBean;

import lulski.model.NavigationMenuItem;

@NoRepositoryBean
public interface NavigationMenuItemCustomRepository {

    public NavigationMenuItem save(NavigationMenuItem model);

}