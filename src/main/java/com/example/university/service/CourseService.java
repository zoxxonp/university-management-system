package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.model.Lesson;
import com.example.university.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo){
        this.courseRepo = courseRepo;
    }

    @Transactional
    public Course saveCourse(Course course){
        // cascade = ALL на lessons сохранит уроки
        return courseRepo.save(course);
    }

    @Transactional
    public Course addLessonToCourse(Long courseId, Lesson lesson){
        Course c = courseRepo.findById(courseId).orElseThrow(() -> new java.util.NoSuchElementException("Course not found"));
        c.addLesson(lesson);
        return courseRepo.save(c);
    }

    public Course getCourse(Long id){
        return courseRepo.findById(id).orElseThrow(() -> new java.util.NoSuchElementException("Course not found"));
    }
}