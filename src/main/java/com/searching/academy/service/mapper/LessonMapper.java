package com.searching.academy.service.mapper;

import com.searching.academy.dto.LessonDto;
import com.searching.academy.entity.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper extends EntityMapper<LessonDto, Lesson> {
}
