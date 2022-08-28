package com.gogetters;

import com.gogetters.entity.Course;
import com.gogetters.entity.Parent;
import com.gogetters.entity.School;
import com.gogetters.entity.Student;
import com.gogetters.service.*;

import java.util.ArrayList;
import java.util.List;
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

        // Print courses List...
        System.out.println("Which Course you want to enroll?");
        chosenSchool.getCourses().forEach(course ->
                System.out.println(
                        "Enter "+course.id+" for "+ course.getName()
                ));
        int courseId = scanner.nextInt();
        Course chosenCourse = courseService.findById(courseId);

        // Print Student List who has taken selected Course..
        int tryCount = 0;
        List<Student> sameCourseEnrolledStudentList = new ArrayList<>();
        while (tryCount != 3){
            System.out.println("Would you like to see which students has enrolled the same course? Y/N");
            String ch = scanner.next();
            if (ch.equalsIgnoreCase("Y")){
                studentService.findAll().stream()
                    .filter(student -> student.getCourses().stream()
                            .map(Course::getId).anyMatch(id -> id == student.id)
                    )
                    .peek(sameCourseEnrolledStudentList::add)
                    .forEach(filteredStudent ->
                            System.out.println(filteredStudent.getFirstName()+" "+filteredStudent.getLastName()+" is enrolled.")
                    );
                break;
            } else if (ch.equalsIgnoreCase("N")){
                break;
            } else {
                System.out.println("You didn`t make a choice");
                tryCount++;
            }
        }

        // Print parent of selected student...
        sameCourseEnrolledStudentList
                .forEach(student ->
                        System.out.println(
                                "Enter "+student.id+" for "+student.getFirstName()+" "+student.getLastName()
                        )
                );
        Student selectedStudent = studentService.findById(scanner.nextInt());
        System.out.println(selectedStudent.getParent().getFirstName()+ " is "+selectedStudent.getFirstName()+ "`s parent... ");


    }


}
