package com.wsb.crm_group.domain.service;

import com.wsb.crm_group.domain.dao.ClientRepository;
import com.wsb.crm_group.model.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Optional<Client> save(Client client) {
        Optional<Client> clientByEmail = clientRepository.findClientByEmail(client.getEmail());
        if (clientByEmail.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(clientRepository.save(client));
    }

    @Transactional
    public Optional<Client> updateById(long id, Client client) {
        Optional<Client> clientById = clientRepository.findById(id);
        if (clientById.isPresent()) {
            client.setId(clientById.get().getId());
            return Optional.of(clientRepository.save(client));
        }

        return Optional.empty();
    }

    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }
}
