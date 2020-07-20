package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.User;
import com.vmikhina.learning.accessingdatamongodb.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class MainController {
  @Autowired
  private UserRepository repository;

  @GetMapping("/")
  public ResponseEntity main(){
    return ResponseEntity.ok("works!");
  }
  @GetMapping("/resources")
  public ResponseEntity resource(){
    List<User> userList = repository.findAll();
    //return ResponseEntity.ok(new User("rest","rest@rest.ru"));
    return ResponseEntity.ok(userList);
  }

}
