package com.example.autographEV.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    //Save New data
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    //Search
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    //searchAlbumId
    public Album getById(String albumId) {
        return albumRepository.findById(albumId).get();
    }
    //update
    public Album updateAlbum(Album album) { return albumRepository.save(album); }
    //delete
    public void deleteAlbum(String albumId) {
        albumRepository.deleteById(albumId);
    }

}