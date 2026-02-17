package com.example.demo.controller;

import com.example.demo.entity.UserEntry;
import com.example.demo.services.UserServices;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserEntry>> getAll() {
        List<UserEntry> entries = userServices.getAll();
        return ResponseEntity.ok(entries);
    }

    @PostMapping
    public void CreateUser(@RequestBody UserEntry userEntry) {
        userServices.SaveEntry(userEntry);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Nonnull @RequestBody UserEntry userEntry) {
        UserEntry userIndb = userServices.findByUsername(userEntry.getUsername());
        if (userIndb != null) {
            userIndb.setUsername(userEntry.getUsername());
            userIndb.setPassword(userEntry.getPassword());
            userServices.SaveEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
