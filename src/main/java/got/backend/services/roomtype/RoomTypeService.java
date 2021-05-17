package got.backend.services.roomtype;

import got.backend.model.RoomType;
import got.backend.repository.RoomTypeRepository;
import got.backend.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService extends GenericService<RoomType> implements IRoomTypeService {
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        super(roomTypeRepository);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
