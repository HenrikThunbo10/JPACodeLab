package app.DAOs;

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
            return em.find(Student.class, id);
        }
    }

    @Override
    public Set getAll()
    {
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery query = em.createQuery("SELECT s FROM Student s", Student.class);
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

    }
}
