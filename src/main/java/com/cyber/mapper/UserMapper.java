package com.cyber.mapper;

import com.cyber.domain.User;
import com.cyber.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User map(UserDto dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, User.class);
  }
}
