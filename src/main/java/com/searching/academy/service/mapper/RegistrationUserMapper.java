package com.searching.academy.service.mapper;

import com.searching.academy.dto.request.RegistrationUserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RegistrationUserMapper extends EntityMapper<RegistrationUserDto, User> {

}
