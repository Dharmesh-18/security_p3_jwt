package com.security.security_p3_jwt.repository;

import com.security.security_p3_jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
