package got.backend.services.roomtype;

import got.backend.model.Destination;
import got.backend.model.RoomType;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomTypeService extends IService<RoomType> {
    Page<RoomType> findAll(Pageable pageable);
}
