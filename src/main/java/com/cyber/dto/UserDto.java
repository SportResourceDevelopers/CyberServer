package com.cyber.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserDto {

  private String username;
  private Date dateOfBirth;
  private String email;
  private String password;
}
