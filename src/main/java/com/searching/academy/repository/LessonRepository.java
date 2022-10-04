package com.searching.academy.repository;

import com.searching.academy.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByTeacherId(Long teacherId);

}
