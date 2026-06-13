package com.quickserve.auth.repository;

import com.quickserve.auth.eintity.Role;
import com.quickserve.auth.eintity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);

    Boolean existsByRoleName(RoleName roleName);
}
