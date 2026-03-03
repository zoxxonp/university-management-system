package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.model.Lesson;
import com.example.university.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){ this.courseService = courseService; }

    // POST /courses
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    // POST /courses/{courseId}/lessons
    @PostMapping("/{courseId}/lessons")
    public ResponseEntity<Course> addLesson(@PathVariable Long courseId, @RequestBody Lesson lesson){
        return ResponseEntity.ok(courseService.addLessonToCourse(courseId, lesson));
    }

    // GET /courses/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourse(id));
    }
}