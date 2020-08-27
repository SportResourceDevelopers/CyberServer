package com.cyber.service;

import com.cyber.domain.User;
import com.cyber.repository.RoleRepository;
import com.cyber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final EmailService emailService;

  @Autowired
  public UserService(UserRepository userRepository, RoleRepository roleRepository, EmailService emailService) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.emailService = emailService;
  }

  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public Optional<User> getByEmail(String email) {
    return Optional.ofNullable(userRepository.findByEmail(email));
  }

  public User save(User user) {
    user.setPassword(hashPassword(user.getPassword()));
    user.setRoles(Collections.singleton(roleRepository.getByName("ROLE_USER")));
    return userRepository.save(user);
  }

  public boolean confirmEmail(String emailkey){
   /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    return false;
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public String hashPassword(String plainTextPassword){
    return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
  }
}
