package got.backend.services.accommodation;

import got.backend.model.Accommodation;
import got.backend.repository.AccommodationRepository;
import got.backend.repository.IGenericRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService extends GenericService<Accommodation> implements IAccommodationService {

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository) {
        super(accommodationRepository);
    }
}
