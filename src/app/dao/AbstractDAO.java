package app.dao;

import java.util.List;

public interface AbstractDAO<T> {

    T save(T entity);

    List<T> getAll();

    T findById(Integer id);

    String update(T entity);
}
