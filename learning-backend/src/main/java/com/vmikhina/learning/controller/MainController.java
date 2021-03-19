package com.vmikhina.learning.controller;

import com.vmikhina.learning.accessingdatamongodb.Hero;
import com.vmikhina.learning.accessingdatamongodb.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/hero")
public class MainController {
  @Autowired
  private HeroRepository repository;

  @GetMapping("/")
  public ResponseEntity main(){
    return ResponseEntity.ok("works!");
  }

  @GetMapping
  public ResponseEntity getHeroes(){
    List<Hero> heroes = repository.findAll();
    return ResponseEntity.ok(heroes);
  }

  @GetMapping("/{id}")
  public ResponseEntity getHero(@PathVariable String id){
    if (repository.findById(id).isPresent()) {
      Hero hero = repository.findById(id).get();
      return ResponseEntity.ok(hero);
    }
    throw new NoSuchElementException("Data not found");
  }
  @PutMapping("/{id}")
  public ResponseEntity updateHero(@PathVariable("id") String id, @RequestBody Hero heroObj) {
    if (repository.findById(id).isPresent()){
      Hero hero = repository.findById(id).get();
      hero.name = heroObj.getName();
      hero.title = heroObj.getTitle();
      repository.save(hero);
      return ResponseEntity.ok(hero);
    }
    throw new NoSuchElementException("Data not found");
  }

  @PostMapping
  public ResponseEntity saveHero(@RequestBody Hero hero) {
    repository.save(hero);
    return ResponseEntity.ok(hero);
  }

  /**
   * Here path variable with "id", in getHero method - without
   * */
  @DeleteMapping("/{id}")
  public ResponseEntity deleteHero(@PathVariable("id") String id) {
    if (repository.findById(id).isPresent()){
      Hero hero = repository.findById(id).get();
      repository.delete(hero);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    throw new NoSuchElementException("Data not found");
  }

}
