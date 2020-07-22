package lulski;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lulski.model.NavigationMenuItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NavigationMenuItemTest {


  @Test
  public void a_new_entry_of_navigation_menu_is_added_into_database() {

    NavigationMenuItem nav1 = new NavigationMenuItem("home", "/home");
    assertTrue( nav1.save() > 0, "nav1.save() should return positive int to indicate dbsave was sucessful, but it did not return positive int");
  }
}