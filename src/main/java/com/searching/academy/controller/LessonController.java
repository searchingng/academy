package com.searching.academy.controller;

import com.searching.academy.dto.LessonDto;
import com.searching.academy.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonDto dto){
        return ResponseEntity.ok(lessonService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> getAll(){
        return ResponseEntity.ok(lessonService.getAll());
    }

    @GetMapping("/my-lessons")
    public ResponseEntity<List<LessonDto>> getMyLessons(){
        return ResponseEntity.ok(lessonService.getMyLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(lessonService.getOne(id));
    }

}
