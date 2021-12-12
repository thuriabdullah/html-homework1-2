package com.example.demo.Designer;

import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "designer")
//يمكن من اخذ الريسورس من دومين اخر  واذا ماستخدمتها المستخدمين الي راح يدخلون على الموقع راح يواجهون مشكله

@CrossOrigin("*")
public class DesignerController {
    private final  DesignerServies designerServies;
    @Autowired
    public DesignerController(DesignerServies designerServies) {
        this.designerServies = designerServies;
    }

    @GetMapping
    public List<Designer> getAllDesigner(){
        return  designerServies.getAllDesigner();
    }
    @GetMapping("/{id}")
    public Designer getUser(@PathVariable String id){
        return designerServies.getDesigner(id);
    }
    @PostMapping
    public Designer addDesigner(@RequestBody Designer designer  ){
        return  designerServies.addDesigner(designer);
    }
    @GetMapping(path="/{userName}")
    public Designer getByusername(@PathVariable String userName){

        return designerServies.getByUserName(userName);
    }

    @PutMapping("/{id}")
    public void updateDesigner(@PathVariable String id, @RequestBody Designer data) {
        designerServies.updateDesigner(id, data);
    }
    @DeleteMapping("/{id}")
    public  void deleteDesigner(@PathVariable String id ){
        designerServies.deleteDesigner(id);
    }

}
