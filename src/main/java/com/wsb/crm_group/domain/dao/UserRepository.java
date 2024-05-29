package com.wsb.crm_group.domain.dao;


import java.util.Optional;

import com.wsb.crm_group.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);

}
