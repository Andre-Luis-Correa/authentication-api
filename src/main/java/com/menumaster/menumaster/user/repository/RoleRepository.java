package com.menumaster.menumaster.user.repository;

import com.menumaster.menumaster.user.domain.entity.Role;
import com.menumaster.menumaster.user.domain.entity.User;
import com.menumaster.menumaster.user.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName role);
}
