package com.wsb.cms_group.domain.dao;

import com.wsb.cms_group.model.entry.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository extends JpaRepository<Entries, Integer> {
}
