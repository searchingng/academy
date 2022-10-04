package com.searching.academy.service.mapper;

import com.searching.academy.dto.request.RegistrationUserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationUserMapper extends EntityMapper<RegistrationUserDto, User> {

}
