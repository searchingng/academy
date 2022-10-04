package com.searching.academy.service.mapper;

import com.searching.academy.dto.request.CreationUserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreationUserMapper extends EntityMapper<CreationUserDto, User> {

}
