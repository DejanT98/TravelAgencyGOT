package got.backend.services.user;

import got.backend.model.Destination;
import got.backend.model.RoomType;
import got.backend.model.User;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IService<User> {
    Page<User> findAll(Pageable pageable);
}
