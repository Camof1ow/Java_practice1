package com.example.week02;

import com.example.week02.domain.Course;
import com.example.week02.domain.CourseRepository;
import com.example.week02.domain.CourseRequestDto;
import com.example.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (Course course : courseList) {
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequestDto courseRequestDto = new CourseRequestDto("프엔드꽃, 리액트", "임영");
            courseService.update(1L, courseRequestDto);
            courseList = courseRepository.findAll();
            for (Course course : courseList) {
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }


        };
    }}

