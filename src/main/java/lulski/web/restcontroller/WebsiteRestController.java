package lulski.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lulski.model.NavigationMenuItem;
import lulski.service.WebsiteService;

@RestController
@RequestMapping("api/website")
public class WebsiteRestController {
  private WebsiteService websiteService;

  @Autowired
  public WebsiteRestController(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }

  @GetMapping("/getNavigationMenuItems")
  ResponseEntity<List<NavigationMenuItem>> getNavigationMenuItems() {

    return new ResponseEntity<List<NavigationMenuItem>>(websiteService.getNavigationMenuItems(), HttpStatus.OK);
  }

}