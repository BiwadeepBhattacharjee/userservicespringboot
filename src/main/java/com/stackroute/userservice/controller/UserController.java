package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }


    @GetMapping("/users")
    public List<User> getAllUser()
    {
        List<User> users=userService.getAllUser();
        return users;
    }


    @GetMapping("/user/{id}")
    public User retrieveUserById(@PathVariable int id) {
    	Optional<User> user = userService.findById(id);

    	return user.get();
    }

    @DeleteMapping("/user/{id}")
    public void deleteStudent(@PathVariable int id) {
        userService.deleteById(id);
    }

}
