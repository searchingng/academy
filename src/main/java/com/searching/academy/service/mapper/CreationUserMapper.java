package com.searching.academy.service.mapper;

import com.searching.academy.dto.request.CreationUserDto;
import com.searching.academy.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CreationUserMapper extends EntityMapper<CreationUserDto, User> {

}
