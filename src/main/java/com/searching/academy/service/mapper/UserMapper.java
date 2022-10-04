package com.searching.academy.service.mapper;

import com.searching.academy.dto.UserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper extends EntityMapper<UserDto, User> {

}
