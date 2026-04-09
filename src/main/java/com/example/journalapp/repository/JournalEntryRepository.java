package com.example.journalapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.journalapp.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
