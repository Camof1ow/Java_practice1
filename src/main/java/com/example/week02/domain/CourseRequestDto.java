package com.example.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CourseRequestDto {
    private String title;
    private String tutor;

    public CourseRequestDto(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }
}