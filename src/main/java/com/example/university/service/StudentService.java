package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.model.Student;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo){
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Transactional
    public Student saveStudent(Student student){
        // cascade сделает сохранение profile
        return studentRepo.save(student);
    }

    @Transactional
    public Student assignStudentToCourse(Long studentId, Long courseId){
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student not found"));
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new NoSuchElementException("Course not found"));

        student.addCourse(course);
        // сохраняем студент — изменения в join table будут сохранены
        return studentRepo.save(student);
    }

    @Transactional
    public void deleteStudent(Long id){
        Student s = studentRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found"));
        // благодаря cascade = ALL и orphanRemoval = true профиль удалится автоматически
        studentRepo.delete(s);
    }

    public Student getStudent(Long id){
        return studentRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found"));
    }
}