package got.backend.services.country;

import got.backend.model.Country;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICountryService extends IService<Country> {
        Page<Country> findAll(Pageable pageable);
}
