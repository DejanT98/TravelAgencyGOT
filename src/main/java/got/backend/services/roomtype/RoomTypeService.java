package got.backend.services.roomtype;

import got.backend.model.RoomType;
import got.backend.repository.IGenericRepository;
import got.backend.repository.RoomTypeRepository;
import got.backend.services.GenericService;
import got.backend.services.room.IRoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService extends GenericService<RoomType> implements IRoomTypeService {
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        super(roomTypeRepository);
    }
}
