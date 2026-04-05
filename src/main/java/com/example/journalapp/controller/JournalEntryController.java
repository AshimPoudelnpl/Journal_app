package com.example.journalapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.journalapp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/abc")
    public List<JournalEntry> getAll() { // http://localhost:8080/journal GET
        return new ArrayList<>(journalEntries.values());

    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry) { // http://localhost:8080/journal POST

        journalEntries.put(myentry.getId(), myentry);
        return true;
    }

    @GetMapping("/{id}")
    public JournalEntry getById(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @DeleteMapping("/{id}")
    public JournalEntry deleteById(@PathVariable Long id) {
        return journalEntries.remove(id);
    }
}