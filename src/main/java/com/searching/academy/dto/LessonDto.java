package com.searching.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {

    private Long id;
    private String name;
    private Long teacherId;

}
