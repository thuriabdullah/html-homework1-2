package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="user")
@CrossOrigin("*")
public class UserControoler {
    private final UserServies userServies;
@Autowired
    public UserControoler(UserServies userServies) {
        this.userServies = userServies;
    }

    @GetMapping("greeting/{name}")
    public  String greeting(@PathVariable String userName){

        return "welcome"+userName;
    }

    @GetMapping
    public List<User> getAllUser(){
    return  userServies.getAllUser();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
    return userServies.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user ){
        System.out.println(user);
    return  userServies.addUser(user);

    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User data) {
        userServies.updateUser(id, data);
    }

   @DeleteMapping("/{id}")
    public void deleteuser (@PathVariable String id ){
    userServies.deleteuser(id);
   }

}
