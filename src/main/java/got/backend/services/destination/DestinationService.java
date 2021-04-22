package got.backend.services.destination;

import got.backend.model.Destination;
import got.backend.repository.CountryRepository;
import got.backend.repository.DestinationRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService extends GenericService<Destination> implements IDestinationService {

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        super(destinationRepository);
    }

    @Override
    public List<Destination> getDestinationsByCountryName(String name) {
        return ((DestinationRepository)repository).getDestinationsByCountryName(name);
    }
}
