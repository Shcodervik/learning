package com.vmikhina.learning.accessingdatamongodb;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hero")
public class Hero {
  @Id
  @Getter
  @Setter
  public String id;
  @Getter
  @Setter
  public String name;
  @Getter
  @Setter
  public String title;
  @Getter
  @Setter
  public Binary image;

  public Hero(){}

  public Hero(String name, String title){
    this.name = name;
    this.title = title;
  }

  @Override
  public String toString(){
    return String.format("User [id=%s, name='%s', title='%s']", id, name, title);
  }
}
