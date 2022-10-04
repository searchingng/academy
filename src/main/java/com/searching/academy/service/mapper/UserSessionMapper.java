package com.searching.academy.service.mapper;

import com.searching.academy.dto.UserSessionDto;
import com.searching.academy.entity.UserSession;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserSessionMapper extends EntityMapper<UserSessionDto, UserSession> {
}
