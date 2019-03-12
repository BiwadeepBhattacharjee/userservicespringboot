package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUser()
    {
      return (List<User>) userRepository.findAll();
    }


    public Optional<User> findById(int id){
        Optional<User> user=userRepository.findById(id);
        return user;
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
