package com.example.demo.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="utility")
public class UtilityController {
    private final UtilityService utilityService;

    @Autowired
    public UtilityController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }
    @GetMapping
    public List<Utility> getAllUtilities(){
        return  utilityService.getAllUtilities();
    }
    @GetMapping("/{id}")
    public Utility getUtility(@PathVariable String id){
        System.out.println(id);
        return utilityService.getUtilities(id);
    }
    @PostMapping
    public Utility addUtility(@RequestBody Utility s){
        return  utilityService.addUtility(s);
    }
    @GetMapping("all/{id}")
    public List<Utility> getAllServiesByDesigner(@PathVariable String id){
        return utilityService.getAllServiesByDesigner(id);
    }

}
