package com.vmikhina.learning.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Users {
  @Id
  public String id;

  public String name;
  public String email;
  public int age;
  public boolean hasCar;
  public String pass;
  public Date birthday;

  public Users(){}

  public Users(String name, String email){
    this.name = name;
    this.email = email;
  }

  @Override
  public String toString(){
    return String.format("User [id=%s, name='%s', email='%s']", id, name, email);
  }
}
