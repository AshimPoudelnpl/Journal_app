package com.example.journalapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.repository.JournalEntryRepository;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryController(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry) {
        JournalEntry savedEntry = journalEntryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getById(@PathVariable String id) {
        return journalEntryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        if (!journalEntryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        journalEntryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
