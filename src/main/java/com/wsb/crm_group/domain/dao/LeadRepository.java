package com.wsb.crm_group.domain.dao;

import com.wsb.crm_group.model.lead.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
