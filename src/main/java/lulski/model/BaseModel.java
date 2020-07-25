package lulski.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public abstract class BaseModel {

  @Transient
  public String SEQUENCE_NAME;

  @Id
  public long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }



}