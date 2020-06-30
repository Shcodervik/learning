package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
  @GetMapping("/")
  public ResponseEntity main(){
    return ResponseEntity.ok("works!");
  }
  @GetMapping("/resources")
  public ResponseEntity resource(){
    return ResponseEntity.ok(new Users("rest","rest@rest.ru"));
  }

  @RequestMapping("/login")
  public boolean login(@RequestBody User user) {
    return user.getUsername().equals("admin") && user.getPassword().equals("restPass");
  }
  @RequestMapping("/home")
  public Principal user(HttpServletRequest request) {
    String authToken = request.getHeader("Authorization")
            .substring("Basic".length()).trim();
    return () ->  new String(Base64.getDecoder()
            .decode(authToken)).split(":")[0];
  }
}
