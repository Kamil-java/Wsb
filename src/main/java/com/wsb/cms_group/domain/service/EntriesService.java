package com.wsb.cms_group.domain.service;

import com.wsb.cms_group.domain.dao.EntriesRepository;
import com.wsb.cms_group.model.entry.Entries;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntriesService {

    private EntriesRepository entriesRepository;

    public List<Entries> getAllEntries() {
        return entriesRepository.findAll();
    }

    public Entries createEntries(Entries entries) {
        return entriesRepository.save(entries);
    }

    public void deleteEntries(int id) {
        entriesRepository.deleteById(id);
    }
}
