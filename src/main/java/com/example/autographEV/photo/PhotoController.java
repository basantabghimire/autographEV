package com.example.autographEV.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo){
        System.out.println("Save photo");
        return photoService.savePhoto(photo);
    }
    @GetMapping
    public List<Photo> getAllPhoto(){
        System.out.println("Display all photo");
        return photoService.getAllPhoto();
    }
    @GetMapping("/{photoId}")
    public Photo getById(@RequestParam("photoId") String photoId){
        System.out.println("Display photo by photoId");
        return photoService.getPhotoById(photoId);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementError(){
        return "No such element found";
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody @Valid Photo photo){
        System.out.println("picture update");
        return photoService.updatePhoto(photo);
    }
    @DeleteMapping("/{photoId}")
    public void deletePhoto(@PathVariable String photoId){
        System.out.println("picture delete");
        photoService.deletePhoto(photoId);
    }


}
