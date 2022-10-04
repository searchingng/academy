package com.searching.academy.service.mapper;

import com.searching.academy.dto.UserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {

}
