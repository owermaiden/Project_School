package com.codeBusters.service;

import com.codeBusters.database.Database;
import com.codeBusters.entity.Course;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CourseService implements CRUDService<Course> {
    @Override
    public Course findById(int id) {
        return Database.courseList.stream()
                .filter(course -> course.id == id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<Course> findAll() {
        return Database.courseList;
    }

    @Override
    public void save(Course course) {
        Database.courseList.add(course);
    }

    @Override
    public void update(Course course) {
        List<Course> filteredList = Database.courseList.stream()
                .filter(course1 -> course1.id == course.id).collect(toList());

        filteredList.add(course);
        Database.courseList = filteredList;
    }

    @Override
    public void deleteById(Long id) {
        Database.courseList = Database.courseList.stream()
                .filter(course1 -> course1.id == id).collect(toList());
    }
}
