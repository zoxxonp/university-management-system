package com.example.university.model;

import jakarta.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // ====== GETTERS AND SETTERS ======

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {   // ← ВОТ ЭТОГО НЕ ХВАТАЛО
        this.course = course;
    }
}