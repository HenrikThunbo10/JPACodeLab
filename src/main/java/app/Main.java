package app;

import app.DAOs.CourseDAO;
import app.DAOs.StudentDAO;
import app.entities.Course;
import app.entities.Student;

import java.time.LocalDate;

import java.util.HashSet;

import java.util.Set;

public class Main
{
    public static void main(String[] args)
    {

        CourseDAO courseDAO = new CourseDAO();
        StudentDAO studentDAO = new StudentDAO();

//        studentDAO.create(
//                Student.builder()
//                        .name("John")
//                        .phoneNumber(123456789)
//                        .email("mail@mail.com")
//                        .address("Street 1")
//                        .status("Active")
//                        .dateOfBirth(LocalDate.of(2006,2,12))
//                        .dateOfEnrollment(LocalDate.of(2024,6,1))
//                        .courseId(Set.of(1, 2, 3))
//                        .build()
//
//        );

//        studentDAO.update(
//                Student.builder()
//                        .id(1)
//                        .name("John")
//                        .phoneNumber(123456789)
//                        .email("mail@mail.com")
//                        .address("Street 1")
//                        .status("Active")
//                        .dateOfBirth(LocalDate.of(2006,2,12))
//                        .dateOfEnrollment(LocalDate.of(2024,6,1))
//                        .courseId(Set.of(1,2,3))
//                        .build()
//
//        );
//        studentDAO.delete(
//                Student.builder()
//                        .id(4)
//                        .build()
//        );

//        studentDAO.getStudentCourses(1)
//                .forEach(System.out::println);
//        courseDAO.create(Course.builder()
//                .courseName("Java class")
//                .semester("1. sem")
//                .courseFee(200)
//                .teacherName("Signe")
//                .build());

        studentDAO.getStudentsByCourse(1)
                .forEach(System.out::println);

//        CourseDAO courseDAO = new CourseDAO();
//        courseDAO.create(Course.builder().courseName("Java class").semester("1. sem").courseFee(200).teacherName("Signe").build());
//        courseDAO.create(Course.builder().courseName("Frontend class").semester("2. sem").courseFee(800).teacherName("Jorg").build());
//         courseDAO.getAll().forEach(System.out::println);


        

//        studentDAO.getAll().forEach(System.out::println);
//        courseDAO.getAll().forEach(System.out::println);

    }
}