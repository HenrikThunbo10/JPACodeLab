package app;

import app.DAOs.CourseDAO;
import app.DAOs.PersonDAO;
import app.DAOs.StudentDAO;
import app.entities.Course;
import app.entities.Person;
import app.entities.Student;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.create(
//                Student.builder()
//                        .name("John")
//                        .phone_number(123456789)
//                        .email("mail@mail.com")
//                        .address("Street 1")
//                        .status("Active")
//                        .date_of_birth(LocalDate.of(2006,2,12))
//                        .date_of_enrollment(LocalDate.of(2024,6,1))
//                        .course_id(1)
//                        .build()
//
//        );

        studentDAO.update(
                Student.builder()
                        .id(1)
                        .name("John")
                        .phoneNumber(123456789)
                        .email("mail@mail.com")
                        .address("Street 1")
                        .status("Active")
                        .dateOfBirth(LocalDate.of(2006,2,12))
                        .dateOfEnrollment(LocalDate.of(2024,6,1))
                        //.course_id(1)
                        .build()

        );
        studentDAO.getAll().forEach(System.out::println);
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.create(Course.builder().courseName("Java class").semester("1. sem").courseFee(200).teacherName("Signe").build());
        courseDAO.create(Course.builder().courseName("Frontend class").semester("2. sem").courseFee(800).teacherName("Jorg").build());
        courseDAO.getAll().forEach(System.out::println);

    }
}