package com.cyber.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails extends User implements UserDetails {

  public MyUserDetails(User user) {
    super(user.getId(),
          user.getUsername(),
          user.getFirstName(),
          user.getLastName(),
          user.getEmail(),
          user.getPassword(),
          user.getCountry(),
          user.getCity(),
          user.getGender(),
          user.getDateOfBirth(),
          user.getRoles());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles()
            .stream()
            .map(role-> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
