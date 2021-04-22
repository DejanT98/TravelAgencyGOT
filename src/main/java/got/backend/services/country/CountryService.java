package got.backend.services.country;

import got.backend.model.Country;
import got.backend.model.Destination;
import got.backend.repository.CountryRepository;
import got.backend.repository.DestinationRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Service
public class CountryService extends GenericService<Country> implements ICountryService {

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
    }
}
