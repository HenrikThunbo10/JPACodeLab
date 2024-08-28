package app;

import app.DAOs.PersonDAO;
import app.entities.Person;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        PersonDAO personDAO = new PersonDAO();
        personDAO.create(
                Person.builder()
                        .name("John")
                        .age(25)
                        .build()
        );
        personDAO.getAllPersons().forEach(System.out::println);

    }
}