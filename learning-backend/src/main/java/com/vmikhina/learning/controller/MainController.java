package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.Hero;
import com.vmikhina.learning.accessingdatamongodb.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
  public ResponseEntity hero(@PathVariable("id") String id){
    if (repository.findById(id).isPresent()) {
      Hero hero = repository.findById(id).get();
      return ResponseEntity.ok(hero);
    }
    throw new NoSuchElementException("Data not found");
  }
  @GetMapping("/update/hero/{id}/{name}/{title}")
  public ResponseEntity updateHero(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("title") String title) {
    if (repository.findById(id).isPresent()){
      Hero hero = repository.findById(id).get();
      hero.name = name;
      hero.title = title;
      repository.save(hero);
      return ResponseEntity.ok(hero);
    }
    throw new NoSuchElementException("Data not found");
  }

}
