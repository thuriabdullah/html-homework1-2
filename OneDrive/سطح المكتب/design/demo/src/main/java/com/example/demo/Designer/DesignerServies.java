package com.example.demo.Designer;

import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignerServies {
    private final DesignerRepository designerRepository;
@Autowired
    public DesignerServies(DesignerRepository designerRepository) {
        this.designerRepository = designerRepository;
    }

    public List<Designer> getAllDesigner() {
    return  designerRepository.findAll();
    }

    public Designer getDesigner(String id) {
    Long designer_id=Long.parseLong(id);
    return designerRepository.findById(designer_id).orElse(null);
    }

    public Designer addDesigner(Designer designer) {
    return designerRepository.save(designer);

    }

    public Designer getByUserName(String userName) {
//return  designerRepository.getByUserName(userName);
        Designer designer= designerRepository.getByUserName(userName);
        designer.getUserName();
        return designer;

    }


    public void updateDesigner(String id, Designer data) {
        Long designer_id=Long.parseLong(id);
        Designer designer=designerRepository.findById(designer_id).orElse(null);
        if(designer !=null){
            designer.setDesignerNumber(data.getDesignerNumber());
            designer.setFullName(data.getFullName());
            designer.setUserName(data.getUserName());
            designer.setUserName(data.getUserName());
            designer.setPassword(data.getPassword());
            designer.setAge(data.getAge());
            designer.setAvailabilty(data.isAvailabilty());
            designer.setDesignType(data.getDesignType());
            designerRepository.save(designer);
        }



    }

    public void deleteDesigner(String id) {
        Long designer_id=Long.parseLong(id);
    designerRepository.deleteById(designer_id);
    }
}

