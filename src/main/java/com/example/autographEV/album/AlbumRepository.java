package com.example.autographEV.album;


import org.springframework.data.mongodb.repository.MongoRepository;


public interface AlbumRepository extends MongoRepository<Album, String> {


}
