package lulski.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nav_menu_item")
public class NavigationMenuItem extends BaseModel {

  private String text;
  private String path;
  private boolean isDeleted;
  private Date lastModified;

  public NavigationMenuItem(String text, String path) {
    SEQUENCE_NAME = "navigation_menu_item_sequence";
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

  @Override
  public String toString() {
    return "NavigationMenuItem [text=" + text + ", path=" + path + "]";
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

}
