package got.backend.services.room;

import got.backend.model.Destination;
import got.backend.model.Room;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomService extends IService<Room> {
    Page<Room> findAll(Pageable pageable);
}
