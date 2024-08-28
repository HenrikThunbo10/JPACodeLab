package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import java.util.*;



@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int phoneNumber;
    private String email;
    private String address;
    private String status;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnrollment;

    @ElementCollection
    private Set<Integer> courseId;

 
}
