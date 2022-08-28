package com.gogetters.database;

import com.gogetters.entity.Course;
import com.gogetters.entity.Parent;
import com.gogetters.entity.School;
import com.gogetters.entity.Student;
import com.gogetters.enums.WeekDays;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Course> courseList = new ArrayList<>(List.of(
            new Course(1,"English", 40, List.of(WeekDays.MONDAY, WeekDays.THURSDAY)),
            new Course(2,"Math",50, List.of(WeekDays.values())),
            new Course(3,"Java",80, List.of(WeekDays.WEDNESDAY))
    ));

    public static List<Parent> parentList = new ArrayList<>(List.of(
            new Parent(1,"Dilbar", "Korshad"),
            new Parent(2,"Boban", "Aseel")
    ));

    public static List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,12345L, "ower", "maiden", parentList.get(0), courseList ),
            new Student(2, 12346L, "hasan", "can", parentList.get(1),courseList )
    ));

    public static List<School> schoolList = new ArrayList<>(List.of(
            new School(1,"ABC_School", studentList,courseList),
            new School(2,"Java_School", studentList,courseList)
    ));




}
