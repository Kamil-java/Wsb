package com.wsb.crm_group.domain.service;

import com.wsb.crm_group.domain.dao.ClientRepository;
import com.wsb.crm_group.domain.dao.LeadRepository;
import com.wsb.crm_group.model.client.Client;
import com.wsb.crm_group.model.lead.Lead;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;
    private final ClientRepository clientRepository;

    public List<Lead> getAll() {
        return leadRepository.findAll();
    }

    @Transactional
    public Optional<Lead> save(Lead lead) {
        return Optional.of(leadRepository.save(lead));
    }

    @Transactional
    public Optional<Lead> addClientToLead(long id, long clientId) {
        Optional<Lead> byId = leadRepository.findById(id);
        if (byId.isPresent()) {
            Optional<Client> clientById = clientRepository.findById(clientId);
            clientById.ifPresent(client -> byId.get().getClient().add(client));
            return Optional.of(leadRepository.save(byId.get()));
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Lead> updateById(long id, Lead lead) {
        Optional<Lead> leadById = leadRepository.findById(id);
        if (leadById.isPresent()) {
            lead.setId(leadById.get().getId());
            return Optional.of(leadRepository.save(lead));
        }
        return Optional.empty();
    }

    public void deleteById(long id) {
        leadRepository.deleteById(id);
    }
}
