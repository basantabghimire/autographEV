package com.example.autographEV.album;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album){
        System.out.println("Add new Album");
        return albumService.saveAlbum(album);
    }
    @GetMapping("/all")
    public List<Album> getAllAlbums(@RequestHeader(name = "idToken") String idToken){
        System.out.println("Get all album");
        return albumService.getAllAlbums();
    }
    @GetMapping("/{albumId}")
    public Album getById(@RequestParam("albumId") String albumId){
        System.out.println("get album by Id");
        return albumService.getById(albumId);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementError(){
        return "No such element found";
    }

    @PutMapping("/{albumId}")
    public Album updateAlbum(@RequestBody @Valid Album album){
        System.out.println("Edit album");
        return albumService.updateAlbum(album);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbum(@PathVariable String albumId){
        System.out.println("Delete album by Id");
        albumService.deleteAlbum(albumId);
    }
}
