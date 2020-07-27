package lulski.model;

public class NavigationMenuItem extends BaseModel {

  private String text;
  private String path;

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



}
