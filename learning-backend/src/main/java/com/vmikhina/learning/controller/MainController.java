package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.Hero;
import com.vmikhina.learning.accessingdatamongodb.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class MainController {
  @Autowired
  private HeroRepository repository;

  @GetMapping("/")
  public ResponseEntity main(){
    return ResponseEntity.ok("works!");
  }
  @GetMapping("/resources")
  public ResponseEntity resource(){
    List<Hero> heroes = repository.findAll();
    return ResponseEntity.ok(heroes);
  }
  @GetMapping("/hero/{id}")
  public ResponseEntity hero(@PathVariable("id") int id){
    Hero hero = repository.findById(id);
    return ResponseEntity.ok(hero);
  }

}
