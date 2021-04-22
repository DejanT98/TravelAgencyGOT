package got.backend.services;

import got.backend.model.BaseEntity;
import got.backend.repository.IGenericRepository;

import java.util.List;

public class GenericService<T extends BaseEntity> implements IService<T> {

    protected final IGenericRepository<T> repository;

    public GenericService(IGenericRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(int id) {
        return repository.getOne(id);
    }

    @Override
    public boolean deleteById(int id) {
        if(!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateById(int id, T entity) {
        if(!repository.existsById(id))
            return false;
        entity.setId(id);
        repository.save(entity);
        return true;
    }
}
