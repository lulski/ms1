package lulski.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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


}
