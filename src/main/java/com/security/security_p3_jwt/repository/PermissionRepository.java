package com.security.security_p3_jwt.repository;

import com.security.security_p3_jwt.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
