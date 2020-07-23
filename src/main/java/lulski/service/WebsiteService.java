package lulski.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lulski.model.NavigationMenuItem;


/**
 * Website main service class, provide API that covers website related models -
 * NavigationMenuItem.class
 */
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



}
