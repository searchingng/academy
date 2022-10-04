package com.searching.academy.service;

import com.searching.academy.dto.LessonDto;
import com.searching.academy.entity.Lesson;

import java.util.List;

public interface LessonService {

    LessonDto save(LessonDto lessonDto);

    List<LessonDto> getAll();

    List<LessonDto> getMyLessons();

    List<LessonDto> getLessonsByTeacherId(Long teacherId);

    LessonDto getOne(Long id);

    Lesson findById(Long id);

    void deleteById(Long id);

}
