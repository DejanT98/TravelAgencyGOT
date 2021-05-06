package got.backend.services.country;

import got.backend.model.Country;
import got.backend.repository.CountryRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country> implements ICountryService {

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
    }
}
