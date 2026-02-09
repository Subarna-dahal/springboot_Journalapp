package com.example.demo.services;

import com.example.demo.entity.journalEntry;
import com.example.demo.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class journalEntryServices {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public void saveEntry(journalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<journalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id){
         journalEntryRepository.deleteById(id);
    }

}