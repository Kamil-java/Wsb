package com.wsb.crm_group.domain.controller;

import com.wsb.crm_group.domain.service.LeadService;
import com.wsb.crm_group.model.lead.Lead;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/lead")
@PreAuthorize("hasRole('MANAGE')")
@AllArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @GetMapping
    @PreAuthorize("hasAuthority('management:read')")
    public List<Lead> getAll() {
        return leadService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('management:create')")
    public Lead createClient(@RequestBody Lead lead) {
        return leadService.save(lead)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/assign/client")
    @PreAuthorize("hasAuthority('management:create')")
    public Lead addClientToLead(@RequestParam long leadId, @RequestParam long clientId) {
        return leadService.addClientToLead(leadId, clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('management:update')")
    public Lead updateUser(@PathVariable("id") long id, @RequestBody Lead lead) {
        return leadService.updateById(id, lead)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('management:delete')")
    public void delete(@PathVariable("id") int id) {
        leadService.deleteById(id);
    }
}
