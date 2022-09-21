package com.codeBusters.service;

import com.codeBusters.database.Database;
import com.codeBusters.entity.Parent;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ParentService implements CRUDService<Parent> {
    @Override
    public Parent findById(int id) {
        return Database.parentList.stream()
                .filter(parent -> parent.id==id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<Parent> findAll() {
        return Database.parentList;
    }

    @Override
    public void save(Parent parent) {
        Database.parentList.add(parent);
    }

    @Override
    public void update(Parent parent) {
        List<Parent> filteredParents = Database.parentList.stream()
                .filter(parent1 -> parent1.id== parent.id)
                .collect(Collectors.toList());
        filteredParents.add(parent);
        Database.parentList = filteredParents;
    }

    @Override
    public void deleteById(Long id) {
        Database.parentList = Database.parentList.stream()
                .filter(parent1 -> parent1.id == id).collect(toList());
    }
}
