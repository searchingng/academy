package com.searching.academy.service.impl;

import com.searching.academy.dto.LessonDto;
import com.searching.academy.entity.Lesson;
import com.searching.academy.entity.User;
import com.searching.academy.entity.enums.Role;
import com.searching.academy.repository.LessonRepository;
import com.searching.academy.service.LessonService;
import com.searching.academy.service.mapper.LessonMapper;
import com.searching.academy.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto save(LessonDto lessonDto) {
        Lesson lesson = lessonMapper.toEntity(lessonDto);
        lessonRepository.save(lesson);
        return lessonMapper.toDto(lesson);
    }

    @Override
    public List<LessonDto> getAll() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LessonDto> getMyLessons() {
        User user = UserUtil.currentUser();
        if (!user.getRole().equals(Role.TEACHER))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "For only Teacher");

        return getLessonsByTeacherId(user.getId());
    }

    @Override
    public List<LessonDto> getLessonsByTeacherId(Long teacherId) {
        return lessonRepository.findByTeacherId(teacherId).stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDto getOne(Long id) {
        return lessonMapper.toDto(findById(id));
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lesson Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}
