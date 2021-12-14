package com.example.demo.Utility;

import com.example.demo.Designer.Designer;
import com.example.demo.Designer.DesignerRepository;
import com.example.demo.Gallery.Gallery;
import com.example.demo.Gallery.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityService {
    private final UtilityRepository utilityRepository;
    private final DesignerRepository designerRepository;
    private final GalleryRepository galleryRepository;

    @Autowired
    public UtilityService(UtilityRepository utilityRepository, DesignerRepository designerRepository, GalleryRepository galleryRepository) {
        this.utilityRepository = utilityRepository;
        this.designerRepository = designerRepository;
        this.galleryRepository = galleryRepository;
    }



    public List<Utility> getAllUtilities() {
        return utilityRepository.findAll();

    }

    public Utility getUtilities(String id) {
        Long utility_id=Long.parseLong(id);
        return utilityRepository.findById( utility_id).orElse(null);

    }

    public Utility addUtility(Utility s) {
        Designer d = designerRepository.findById(s.getDesigner().getId()).orElse(null);
        Gallery g=galleryRepository.findById(s.getGallery().getId()).orElse(null);
        s.setDesigner(d);
        s.setGallery(g);
       return  utilityRepository.save(s);




    }

    public List<Utility> getAllServiesByDesigner(String id) {
        List<Utility> allServices= utilityRepository.findAll();
        Long designer_id= Long.parseLong(id);
        List<Utility> servicesOfDesigner = new ArrayList<>();
        for ( Utility s : allServices){
            if(s.getDesigner().getId() == designer_id){
                servicesOfDesigner.add(s);
            }
        }
        return  servicesOfDesigner;
    }
}

