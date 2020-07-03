package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class MainController {
  @GetMapping("/")
  public ResponseEntity main(){
    return ResponseEntity.ok("works!");
  }
  @GetMapping("/resources")
  public ResponseEntity resource(){
    return ResponseEntity.ok(new Users("rest","rest@rest.ru"));
  }

}
