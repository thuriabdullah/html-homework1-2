package com.example.demo.Servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="sevices")
public class ServiesController {
    private final ServiesServies serviesServies;
@Autowired
    public ServiesController(ServiesServies serviesServies) {
        this.serviesServies = serviesServies;
    }
    @GetMapping
    public List<Servies> getAllServies(){
        return  serviesServies.getAllServies();
    }
    @GetMapping("/{id}")
    public Servies getServies(@PathVariable String id){
        return serviesServies.getServies(id);
    }
    @PostMapping
    public Servies addServies(@RequestBody Form form ){
//        System.out.println(form.getTitle());
        return  serviesServies.addServies(form.getServies(),form.getDesignerNumber(),form.getGalleryID());

    }


}
class Form {
    private Servies servies;
    private Long designerNumber;
    private Long galleryID ;

    public Form(Servies servies, Long designerNumber, Long galleryID) {
        this.servies = servies;
        this.designerNumber = designerNumber;
        this.galleryID = galleryID;
    }

    public Servies getServies() {
        return servies;
    }

    public void setServies(Servies servies) {
        this.servies = servies;
    }

    public Long getDesignerNumber() {
        return designerNumber;
    }

    public void setDesignerNumber(Long designerNumber) {
        this.designerNumber = designerNumber;
    }

    public Long getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(Long galleryID) {
        this.galleryID = galleryID;
    }
}

