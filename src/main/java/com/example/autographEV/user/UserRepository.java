package com.example.autographEV.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findAllByAddress(String address);
    List<User> findAllByName(String name);
}
