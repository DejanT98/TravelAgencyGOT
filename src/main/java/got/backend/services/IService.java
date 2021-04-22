package got.backend.services;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(int id);
    boolean deleteById(int id);
    boolean updateById(int id, T entity);
}