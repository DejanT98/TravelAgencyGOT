package got.backend.repository;

import got.backend.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CountryRepository extends IGenericRepository<Country> {

}
