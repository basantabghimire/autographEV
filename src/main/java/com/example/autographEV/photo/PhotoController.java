package com.example.autographEV.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo){
        System.out.println("Save photo");
        return photoService.savePhoto(photo);
    }
    @GetMapping
    public List<Photo> getAllPhoto(){
        System.out.println("Display all photo");
        return photoService.getAllPhoto();
    }
    @GetMapping("/photoId")
    public Optional<Photo> getById(@RequestParam(name="photoId")String photoId){
        System.out.println("Display photo by photoId");
        return photoService.getById(photoId);
    }
    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){

        System.out.println("picture update");
        return photoService.updatePhoto(photo);
    }
    @DeleteMapping
    public void deletePhoto(@RequestParam (name = "photoId")String photoId){
        System.out.println("picture delete");
        photoService.deletePhoto(photoId);
    }


}
