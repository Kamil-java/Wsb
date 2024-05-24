package com.wsb.cms_group.domain.controller;

import com.wsb.cms_group.domain.service.EntriesService;
import com.wsb.cms_group.model.entry.Entries;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
public class EntriesController {
    private EntriesService entriesService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Entries> get() {
        return entriesService.getAllEntries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin:create')")
    public Entries post(@RequestBody Entries entries) {
        return entriesService.createEntries(entries);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('admin:delete')")
    public void delete(@PathVariable("id") int id) {
        entriesService.deleteEntries(id);
    }
}
