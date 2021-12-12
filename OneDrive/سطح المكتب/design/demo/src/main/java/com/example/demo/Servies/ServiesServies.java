package com.example.demo.Servies;

import com.example.demo.Designer.Designer;
import com.example.demo.Gallery.Gallery;
import com.example.demo.Gallery.GalleryRepository;
import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.demo.Designer.DesignerRepository;

import java.util.List;

@Service
public class ServiesServies {

    private final ServiesRepository serviesRepository;
    private final DesignerRepository designerRepository;
    private final GalleryRepository galleryRepository;

@Autowired
    public ServiesServies(ServiesRepository serviesRepository, DesignerRepository designerRepository, GalleryRepository galleryRepository) {
        this.serviesRepository = serviesRepository;
    this.designerRepository = designerRepository;
    this.galleryRepository = galleryRepository;
}

    public List<Servies> getAllServies() {
    return  serviesRepository.findAll();

    }

    public Servies getServies(String id) {
    Long designer_id= Long.parseLong(id);
    return  serviesRepository.findById(designer_id).orElse(null);
    }

    public Servies addServies(Servies servies ,Long designerNumber,Long galleryID) {
        Designer designer = this. designerRepository.findById(designerNumber).orElse(null);
        servies.setDesigner(designer);
        Gallery gallery =this.galleryRepository.findById(galleryID).orElse(null);
        servies.setGallery(gallery);
    return serviesRepository.save(servies);
    }


}
