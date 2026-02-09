package com.example.demo.controller;

import com.example.demo.entity.journalEntry;
import com.example.demo.services.journalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class journalEntryController {

    @Autowired
    private journalEntryServices journalEntryServices;

    @GetMapping()
    public List<journalEntry> getAll() {
        return journalEntryServices.getAll();
    }

    @PostMapping()
    public boolean createEntry(@RequestBody journalEntry myentry) {
        myentry.setDate(LocalDateTime.now());
        journalEntryServices.saveEntry(myentry);
        return true;

    }

    @GetMapping("id/{id}")
    public journalEntry getbyId(@PathVariable ObjectId id) {
        return journalEntryServices.findById(id).orElse(null);
    }

    @DeleteMapping("id/{id}")
    public boolean deleteJournalbyId(@PathVariable ObjectId id) {
        journalEntryServices.deleteById(id);
        return true;
    }

    @PutMapping("id/{id}")
    public journalEntry updatebyId(@PathVariable ObjectId id, @RequestBody journalEntry myEntry) {
        journalEntry oldjournalEntry = journalEntryServices.findById(id).orElse(null);
        if (oldjournalEntry != null) {
            oldjournalEntry.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : oldjournalEntry.getTitle());
            oldjournalEntry.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : oldjournalEntry.getContent());
        }
        journalEntryServices.saveEntry(oldjournalEntry);
        return oldjournalEntry;
    }

}
