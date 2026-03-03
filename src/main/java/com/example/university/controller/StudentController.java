package com.example.university.controller;

import com.example.university.model.Student;
import com.example.university.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){ this.studentService = studentService; }

    // POST /students
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.ok(saved);
    }

    // POST /students/{studentId}/courses/{courseId}
    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> assignCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        Student updated = studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.ok(updated);
    }

    // GET /students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    // DELETE /students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}