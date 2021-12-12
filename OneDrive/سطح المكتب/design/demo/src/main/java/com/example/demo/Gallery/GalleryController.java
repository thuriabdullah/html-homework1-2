package com.example.demo.Gallery;

import com.example.demo.Designer.Designer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="gallery")
public class GalleryController {
    private final GalleryServies galleryServies;
    @Autowired
    public GalleryController(GalleryServies galleryServies) {
        this.galleryServies = galleryServies;
    }
    @GetMapping
    public List<Gallery> getAllGalleries(){
        return  galleryServies.getAllDesigner();
    }
    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable String id){
        return galleryServies.getGallery(id);
    }
    @PostMapping
    public Gallery addGallery(@RequestBody Gallery gallery  ){
        return  galleryServies.addGallery(gallery);

    }
    @PutMapping("/{id}")
    public void updateGallery(@PathVariable String id , @RequestBody Gallery data){
        galleryServies.updateGallery(id, data);
    }
    @DeleteMapping("/{id}")
    public void deleteGallery(@PathVariable String id){
        galleryServies.deleteGallery(id);

    }
}
