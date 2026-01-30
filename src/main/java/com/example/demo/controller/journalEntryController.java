package com.example.demo.controller;

import com.example.demo.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    public Map<Long,journalEntry> journalEntries=new HashMap<>();
    @GetMapping("/get-data")
    public List<journalEntry> getAll(){
        return  new ArrayList<>(journalEntries.values());
    }
    @PostMapping("/entre-data")
    public  void createEntry(@RequestBody journalEntry myentry){
            journalEntries.put(myentry.getId(),myentry);
    }
}
