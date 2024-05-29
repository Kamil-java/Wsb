package com.wsb.crm_group.domain.controller;

import com.wsb.crm_group.domain.service.ClientService;
import com.wsb.crm_group.model.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@PreAuthorize("hasRole('MANAGER')")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    @PreAuthorize("hasAuthority('management:read')")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('management:create')")
    public Client createClient(@RequestBody Client client) {
        return clientService.save(client)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('management:update')")
    public Client updateUser(@PathVariable("id") long id, @RequestBody Client client) {
        return clientService.updateById(id, client)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('management:delete')")
    public void delete(@PathVariable("id") int id) {
        clientService.deleteById(id);
    }
}
