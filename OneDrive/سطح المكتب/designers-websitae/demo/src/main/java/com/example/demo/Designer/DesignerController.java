package com.example.demo.Designer;

import com.example.demo.Utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "designer")
@CrossOrigin("*")
public class DesignerController {
    private final DesignerService designerService;

    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @GetMapping
    public List<Designer> getAllDesigner() {
        return designerService.getAllDesigner();
    }


    @GetMapping("/{id}")
    public Designer getUser(@PathVariable String id){
        return designerService.getDesigner(id);
    }
    @PostMapping
    public Designer addDesigner(@RequestBody Designer designer  ){
        return  designerService.addDesigner(designer);
    }
    @PutMapping("/{id}")
    public void updateDesigner(@PathVariable String id, @RequestBody Designer data) {
        designerService.updateDesigner(id, data);
    }
    @DeleteMapping("/{id}")
    public  void deleteDesigner(@PathVariable String id ){
        designerService.deleteDesigner(id);
    }

    @GetMapping("AllUtility/{id}")
    public List<Utility> getAllUtilityByDesignerId(@PathVariable String id) {
        return designerService.getAllUtilityByDesignerId(id);

    }
}
