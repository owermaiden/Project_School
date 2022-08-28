package com.gogetters;

import com.gogetters.entity.Course;
import com.gogetters.entity.Parent;
import com.gogetters.entity.School;
import com.gogetters.entity.Student;
import com.gogetters.service.*;

import java.util.Scanner;

public class SchoolMainRunner {

    public static CRUDService<School> schoolService;
    public static CRUDService<Course> courseService;
    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;

    static {
        SchoolMainRunner.schoolService = new SchoolService();
        SchoolMainRunner.courseService = new CourseService();
        SchoolMainRunner.parentService = new ParentService();
        SchoolMainRunner.studentService = new StudentService();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // print school list and select one of them...
        System.out.println("Please enter your school? ");
        schoolService.findAll().forEach(school ->
                System.out.println(
                        "Enter "+school.id+" for "+ school.getName()
                ));
        int schoolId = scanner.nextInt();
        School chosenSchool = schoolService.findById(schoolId);
        System.out.println(chosenSchool);

        // Print courses List...

        // print Student List who has taken selected Course..

        // print parent of selected student...
    }


}
