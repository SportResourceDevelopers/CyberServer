//package com.cyber.service;
//
//import com.cyber.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class JwtUserDetailsService implements JwtUserDetailsService {
//
//  private final UserService userService;
//
//  @Autowired
//  public JwtUserDetailsService(UserService userService) {
//    this.userService = userService
//  }
//
//  @Override
//  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    Optional<User> optionalUser = userService.getByEmail(email);
//    return Optional.ofNullable(optionalUser).orElseThrow(() -> new UsernameNotFoundException("Username Not Found"))
//            .map(MyUserDetails::new).get();
//  }
//}
