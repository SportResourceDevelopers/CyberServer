package com.cyber.repository;

import com.cyber.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Byte> {

  Role getByName(@Param("name") String name);
}
