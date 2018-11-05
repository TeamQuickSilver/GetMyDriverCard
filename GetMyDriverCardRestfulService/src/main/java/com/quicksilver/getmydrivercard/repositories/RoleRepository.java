package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByRoleId(Long id);
}
