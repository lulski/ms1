package lulski.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lulski.model.db.NavigationMenuItemRepository;
import lulski.service.BeanUtil;
import lulski.service.DatabaseSequenceGeneratorService;

public class NavigationMenuItem {

  @Transient
  public static final String SEQUENCE_NAME = "navigation_menu_item_sequence";

  @Id
  private long id;

  private String text;
  private String path;



  public NavigationMenuItem(String text, String path) {
    this.setText(text);
    this.setPath(path);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int save() {


    NavigationMenuItemRepository navigationMenuItemRepository = BeanUtil.getBean(NavigationMenuItemRepository.class);
    DatabaseSequenceGeneratorService databaseSequenceGService = BeanUtil.getBean(DatabaseSequenceGeneratorService.class);

    this.id = databaseSequenceGService.generateSequence(NavigationMenuItem.SEQUENCE_NAME);
    navigationMenuItemRepository.save(this);
    //TODO return positive int value when save is successful
    return 0;
  }

  @Override
  public String toString() {
    return "NavigationMenuItem [id=" + id + ", text=" + text + ", path=" + path + "]";
  }

}
