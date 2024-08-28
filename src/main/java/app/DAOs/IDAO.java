package app.DAOs;

import java.util.Set;

public interface IDAO<T>
{
    T getPersonById(Integer id);

    Set<T> getAllPersons();

    void create(T t);

    void update(T t);

    void delete(T t);
}
