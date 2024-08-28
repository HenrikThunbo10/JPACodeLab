package app.DAOs;

import app.entities.Course;
import app.entities.Student;
import app.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDAO implements IDAO<Student>
{
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public Student getById(Integer id)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            Student student = em.find(Student.class, id);
            student.getCourseId().size();
            return student;
        }
    }

    @Override
    public Set getAll()
    {
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery<Student> query = em.createQuery(
                    "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courseId",
                    Student.class
            );

            List<Student> studentList = query.getResultList();

            return studentList.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(Student student)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            getById(student.getId());
            em.merge(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.remove(getById(student.getId()));
            em.getTransaction().commit();
        }
    }

    public Set<Integer> getStudentCourses(Integer studentId)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            Student student = em.find(Student.class, studentId);

            {
                // Ensure courses are fetched
                Set<Integer> courses = student.getCourseId();
                courses.size(); // Force initialization if using lazy loading
                return courses;
            }
        }
    }

    public List<Student> getStudentsByCourse(Integer courseID)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery<Student> query = em.createQuery(
                    "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courseId",
                    Student.class
            );

            List<Student> allStudents = query.getResultList();

            // Use streams to filter students who are enrolled in the specified course
            return allStudents.stream()
                    .filter(student -> student.getCourseId().contains(courseID))
                    .collect(Collectors.toList());
        }
    }

}
