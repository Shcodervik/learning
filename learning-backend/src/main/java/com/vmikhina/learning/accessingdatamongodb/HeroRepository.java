package com.vmikhina.learning.accessingdatamongodb;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String>{
  Hero findByTitle(String title);
  List<Hero> findByName(String name);
  Hero findById(int id);
}
