package com.vmikhina.learning.accessingdatamongodb;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String>{
  Hero findByTitle(String title);
  List<Hero> findByName(String name);
  Optional<Hero> findById(String id);
}
