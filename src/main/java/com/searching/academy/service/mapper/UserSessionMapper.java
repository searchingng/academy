package com.searching.academy.service.mapper;

import com.searching.academy.dto.UserSessionDto;
import com.searching.academy.entity.UserSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSessionMapper extends EntityMapper<UserSessionDto, UserSession> {
}
