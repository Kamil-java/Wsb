package com.wsb.crm_group.domain.service;

import com.wsb.crm_group.domain.dao.ClientRepository;
import com.wsb.crm_group.domain.dao.LeadRepository;
import com.wsb.crm_group.model.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {
    private final ClientRepository clientRepository;
    private final LeadRepository leadRepository;
}
