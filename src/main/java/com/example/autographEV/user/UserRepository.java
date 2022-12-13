package com.example.autographEV.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
public interface UserRepository extends MongoRepository<User,String> {

   User findByEmail(String email);
}


//Optional<User> findByEmail(String email);

//    List<User> findAllByAddress(String address);
//    List<User> findAllByName(String name);
//    List<User> findByALLEmail(String email);
// User user = UserRepository.findByEmail(String email);