package com.mspolater.api;

import com.mspolater.entity.User;
import com.mspolater.respository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;
    @PostConstruct
    public void init(){
        User my_user = new User();
        my_user.setName("Berkcan");
        my_user.setSurname("Arvas");
        userRepository.save(my_user);
    }



    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user)) ;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll()) ;
    }
}
