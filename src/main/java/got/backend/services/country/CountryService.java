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
    public CountryService(CountryRepository coutryRepository) {
        super(coutryRepository);
    }

//    @Autowired
//    private DestinationRepository destinationRepository;
//    @Autowired
//    private CountryRepository countryRepository;

//    private void updateDestinations(Country country) {
//        List<Destination> destinations = destinationRepository.findDestinationsByCountry(country);
//
//        for (Destination d: destinations) {
//            System.out.println(d.getName());
//        }
//    }

//    public Country getCountryById(Integer id) {
//        return countryRepository.getOne(id);
//    }
//
//    public Set<Country> getAllCountries() {
//        return (Set<Country>) countryRepository.findAll();
//    }

}
