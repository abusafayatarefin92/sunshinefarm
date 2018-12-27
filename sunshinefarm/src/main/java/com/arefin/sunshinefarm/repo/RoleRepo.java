package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Role;
import netscape.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
