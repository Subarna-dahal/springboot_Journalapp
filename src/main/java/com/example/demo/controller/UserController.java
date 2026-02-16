package com.example.demo.controller;

import com.example.demo.entity.UserEntry;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserEntry>> getAll(){
        List<UserEntry> entries=userServices.getAll();
        return  ResponseEntity.ok(entries);
    }
}
