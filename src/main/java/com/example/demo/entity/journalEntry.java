package com.example.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "journal_entries")
@Getter
@Setter
@Data
public class journalEntry {
    @Id
    private String id;
    @NonNull
    private String title;
    private String Content;
    private LocalDateTime date;

}