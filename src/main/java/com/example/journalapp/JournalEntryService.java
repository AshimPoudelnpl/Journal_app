package com.example.journalapp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.repository.JournalEntryRepository;

@Service
public class JournalEntryService {
    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(String id) {
        return journalEntryRepository.findById(id);
    }

    public JournalEntry saveEntry(JournalEntry journalEntry) {
        if (journalEntry.getDate() == null) {
            journalEntry.setDate(new Date());
        }
        return journalEntryRepository.save(journalEntry);
    }

    public boolean deleteById(String id) {
        if (!journalEntryRepository.existsById(id)) {
            return false;
        }
        journalEntryRepository.deleteById(id);
        return true;
    }
}
