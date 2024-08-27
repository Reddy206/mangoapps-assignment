package com.quickbook.MovieRush.service;

import com.quickbook.MovieRush.model.User;
import com.quickbook.MovieRush.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
