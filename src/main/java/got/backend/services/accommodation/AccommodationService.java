package got.backend.services.accommodation;

import got.backend.model.Accommodation;
import got.backend.repository.AccommodationRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService extends GenericService<Accommodation> implements IAccommodationService {

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository) {
        super(accommodationRepository);
    }

    @Override
    public Page<Accommodation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
