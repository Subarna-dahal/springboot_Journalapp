package com.example.demo.controller;

import com.example.demo.entity.journalEntry;
import com.example.demo.services.journalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class journalEntryController {

    @Autowired
    private journalEntryServices journalEntryServices;

    @GetMapping()
    public ResponseEntity<List<journalEntry>> getAll() {
        List<journalEntry> entries = journalEntryServices.getAll();
        return ResponseEntity.ok(entries);
    }

    @PostMapping()
    public ResponseEntity<journalEntry> createEntry(@RequestBody journalEntry myentry) {
        myentry.setDate(LocalDateTime.now());
        journalEntryServices.saveEntry(myentry);
        return ResponseEntity.status(HttpStatus.CREATED).body(myentry);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<journalEntry> getbyId(@PathVariable ObjectId id) {
        return journalEntryServices.findById(id)
                .map(entry -> ResponseEntity.ok(entry))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteJournalbyId(@PathVariable ObjectId id) {
        if (journalEntryServices.findById(id).isPresent()) {
            journalEntryServices.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("id/{id}")
    public ResponseEntity<journalEntry> updatebyId(@PathVariable ObjectId id, @RequestBody journalEntry myEntry) {
        journalEntry oldjournalEntry = journalEntryServices.findById(id).orElse(null);
        if (oldjournalEntry != null) {
            oldjournalEntry.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : oldjournalEntry.getTitle());
            oldjournalEntry.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : oldjournalEntry.getContent());
            journalEntryServices.saveEntry(oldjournalEntry);
            return ResponseEntity.ok(oldjournalEntry);
        }
        return ResponseEntity.notFound().build();
    }
}