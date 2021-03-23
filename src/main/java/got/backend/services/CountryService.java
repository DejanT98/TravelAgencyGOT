package got.backend.services;

import got.backend.model.Country;
import got.backend.model.Destination;
import got.backend.repository.CountryRepository;
import got.backend.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private CountryRepository countryRepository;

    private void updateDestinations(Country country) {
        List<Destination> destinations = destinationRepository.findDestinationsByCountry(country);

        for (Destination d: destinations) {
            System.out.println(d.getName());
        }
    }

}
