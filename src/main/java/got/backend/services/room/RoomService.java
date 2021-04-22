package got.backend.services.room;

import got.backend.model.Room;
import got.backend.repository.RoomRepository;
import got.backend.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends GenericService<Room> implements IRoomService {

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        super(roomRepository);
    }
}
