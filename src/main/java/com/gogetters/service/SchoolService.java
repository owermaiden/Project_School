package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.School;

import java.util.List;

public class SchoolService implements CRUDService<School> {

    @Override
    public School findById(int id) {
        return Database.schoolList.stream()
                .filter(school -> school.id == id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<School> findAll() {
        return Database.schoolList;
    }

    @Override
    public void save(School school) {
        Database.schoolList.add(school);
    }

    @Override
    public void update(School school) {
        List<School> filteredList = Database.schoolList.stream()
                .filter(school1 -> school1.id == school.id).toList();

        filteredList.add(school);
        Database.schoolList = filteredList;
    }

    @Override
    public void deleteById(Long id) {
        Database.schoolList =  Database.schoolList.stream()
                .filter(school1 -> school1.id == id).toList();
    }
}
