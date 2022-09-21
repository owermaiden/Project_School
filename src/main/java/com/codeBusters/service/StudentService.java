package com.codeBusters.service;

import com.codeBusters.database.Database;
import com.codeBusters.entity.Student;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StudentService implements CRUDService<Student> {

    @Override
    public Student findById(int id) {
        return Database.studentList.stream()
                .filter(student -> student.id == id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<Student> findAll() {
        return Database.studentList;
    }

    @Override
    public void save(Student student) {
        Database.studentList.add(student);
    }

    @Override
    public void update(Student student) {
        List<Student> filteredList = Database.studentList.stream()
                .filter(student1 -> student1.id == student.id).collect(toList());

        filteredList.add(student);
        Database.studentList = filteredList;
    }

    @Override
    public void deleteById(Long id) {
        List<Student> filteredList = Database.studentList.stream()
                .filter(student1 -> student1.id == id).collect(toList());
        Database.studentList = filteredList;
    }
}
