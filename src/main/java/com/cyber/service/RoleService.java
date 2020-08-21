package com.cyber.service;

import com.cyber.domain.Role;
import com.cyber.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

  private final RoleRepository roleRepository;

  @Autowired
  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public Optional<Role> getById(Byte id) {
    return roleRepository.findById(id);
  }

  public Role getByName(String name) {
    return roleRepository.getByName(name);
  }
}
