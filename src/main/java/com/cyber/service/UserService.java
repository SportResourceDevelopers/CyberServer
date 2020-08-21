package com.cyber.service;

import com.cyber.domain.User;
import com.cyber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User getByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
