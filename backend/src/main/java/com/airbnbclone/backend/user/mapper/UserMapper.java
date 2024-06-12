package com.airbnbclone.backend.user.mapper;

import com.airbnbclone.backend.user.application.dto.ReadUserDTO;
import com.airbnbclone.backend.user.domain.Authority;
import com.airbnbclone.backend.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  ReadUserDTO readUserDTOToUser(User user);

  default String mapAuthoritiesToString(Authority authority) {
    return authority.getName();
  }
}
