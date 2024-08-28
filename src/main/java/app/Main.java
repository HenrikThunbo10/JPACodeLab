package app;

import app.DAOs.CourseDAO;
import app.DAOs.PersonDAO;
import app.entities.Course;
import app.entities.Person;

public class Main
{
    public static void main(String[] args)
    {
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.create(Course.builder().courseName("Java class").semester("1. sem").courseFee(200).teacherName("Signe").build());
        courseDAO.create(Course.builder().courseName("Frontend class").semester("2. sem").courseFee(800).teacherName("Jorg").build());
        courseDAO.getAll().forEach(System.out::println);

    }
}