package com.example.autographEV.album;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album saveAlbum(@RequestBody Album album){
        System.out.println("Add new Album");
        return albumService.saveAlbum(album);
    }
    @GetMapping
    public List<Album> getAllAlbums(){
        System.out.println("Get all album");
        return albumService.getAllAlbums();
    }
    @GetMapping("/AlbumId")
    public Optional<Album> getById(@RequestParam(name="albumId") String albumId){
        System.out.println("get album by Id");
        return albumService.getById(albumId);
    }
    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        System.out.println("Edit album ");
        return albumService.updateAlbum(album);
    }

    @DeleteMapping("AlbumId")
    public void deleteAlbum (@RequestParam (name="albumId") String albumId){
        System.out.println("Delete album by Id");
        albumService.deleteAlbum(albumId);
    }


}
