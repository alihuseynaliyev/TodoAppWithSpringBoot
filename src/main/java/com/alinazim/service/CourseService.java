package com.alinazim.service;

import com.alinazim.entitiy.Course;
import com.alinazim.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Post
    public Course saveCourse(Course course) {
        System.out.printf(course.toString());
        return courseRepository.save(course);
    }

    //Optional
    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    //Get
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> getCoursesForUser(String username) {
        return courseRepository.findAllByUserName(username);
    }

    //Put
    public Course updateCourse(Course course) {
        System.out.printf("updates");
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setStatus(course.getStatus());
        return courseRepository.save(existingCourse);
    }

    //Delete
    public String deleteCourse(int id) {
        courseRepository.deleteById(id);
        return id + " id -> removed";
    }

}
