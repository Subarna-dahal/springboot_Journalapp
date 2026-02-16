package com.example.demo.services;

import com.example.demo.entity.UserEntry;
import com.example.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public void SaveEntry(UserEntry user){
        userRepository.save(user);
    }
    public List<UserEntry> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
}
