package com.vmikhina.learning.accessingdatamongodb;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String>{
  public Users findByEmail(String email);
  public List<Users> findByName(String name);
}
