package got.backend.repository;

import got.backend.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenericRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {
}
