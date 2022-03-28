package sit.tuvarna.bg.vaccine.data.repository;

import java.util.List;
import java.util.Optional;

public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    T getById(Long id);
    List<T> getAll();

}
