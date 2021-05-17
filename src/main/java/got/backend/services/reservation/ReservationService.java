package got.backend.services.reservation;

import got.backend.model.Reservation;
import got.backend.repository.ReservationRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends GenericService<Reservation> implements IReservationService {

    @Autowired
    public ReservationService(ReservationRepository repository) { super(repository); }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
