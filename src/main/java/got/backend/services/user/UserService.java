package got.backend.services.user;

import got.backend.model.User;
import got.backend.repository.UserRepository;
import got.backend.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> implements IUserService {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
