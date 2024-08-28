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

        Set<Integer> courseList = new HashSet<>();
        courseList.add(1);
        courseList.add(2);
        courseList.add(3);

        studentDAO.getAll().forEach(System.out::println);
        courseDAO.getAll().forEach(System.out::println);

    }
}