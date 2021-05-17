package got.backend.services.reservation;

import got.backend.model.Destination;
import got.backend.model.Reservation;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReservationService extends IService<Reservation> {
    Page<Reservation> findAll(Pageable pageable);
}
