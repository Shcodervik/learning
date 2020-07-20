package com.vmikhina.learning.accessingdatamongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="user")
public class User {
  @Id
  @Getter
  @Setter
  public String id;
  @Getter
  @Setter
  public String name;
  @Getter
  @Setter
  public String email;
  @Getter
  @Setter
  public int age;
  @Getter
  @Setter
  public boolean hasCar;
  @Getter
  @Setter
  public String pass;
  @Getter
  @Setter
  public Date birthday;

  public User(){}

  public User(String name, String email){
    this.name = name;
    this.email = email;
  }

  @Override
  public String toString(){
    return String.format("User [id=%s, name='%s', email='%s']", id, name, email);
  }
}
