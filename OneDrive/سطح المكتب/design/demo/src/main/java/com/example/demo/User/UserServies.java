package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServies {

    private final UserRepository userRepository;
@Autowired
    public UserServies(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User getUser(String id) {
    Long user_Id=Long.parseLong(id);
    return userRepository.findById(user_Id).orElse(null);
    }


    public User addUser(User user) {
    return userRepository.save(user);
    }

    public void updateUser(String id, User data) {

            Long user_id = Long.parseLong(id);
           User user = userRepository.findById(user_id).orElse(null);
            if (user != null) {
                user.setFullName(data.getFullName());
                user.setUserName(data.getUserName());
                user.setAge(data.getAge());
                user.setStatus(data.isStatus());
                user.setCreationDate(data.getCreationDate());
                userRepository.save(user);

            }

        }

      public void deleteuser(String id) {
      Long user_id = Long.parseLong(id);
     userRepository.deleteById(user_id );
    }

    public String greeting(String name) {
    User user= userRepository.getByUserName(name);
    user.getUserName();
    return "welcome"+ user;
    }
}

