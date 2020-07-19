package lulski.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lulski.model.NavigationMenuItem;
import lulski.model.Post;

@Service
public class WebsiteService {

  List<NavigationMenuItem> navigationMenuItems;

	public List<NavigationMenuItem> getNavigationMenuItems() {
		NavigationMenuItem item1 = new NavigationMenuItem("home", "/home");
    NavigationMenuItem item2 = new NavigationMenuItem("dev", "/dev");
    NavigationMenuItem item3 = new NavigationMenuItem("aboutme", "/aboutme");

    navigationMenuItems = new ArrayList<>();

    navigationMenuItems.add(item1);
    navigationMenuItems.add(item2);
    navigationMenuItems.add(item3);

		return navigationMenuItems;
  }

  public Post getPostById(){


     return null;
  }

}
