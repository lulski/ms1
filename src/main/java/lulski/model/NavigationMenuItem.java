package lulski.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import lulski.model.db.NavigationMenuItemRepository;
import lulski.service.BeanUtil;

public class NavigationMenuItem {

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
    // TODO implement @ID autoincrement

    NavigationMenuItemRepository navigationMenuItemRepository = BeanUtil.getBean(NavigationMenuItemRepository.class);
    navigationMenuItemRepository.save(this);

    return 0;
  }

  @Override
  public String toString() {
    return "NavigationMenuItem [id=" + id + ", text=" + text + ", path=" + path + "]";
  }

}
