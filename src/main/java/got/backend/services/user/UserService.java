package got.backend.services.user;

import got.backend.model.User;
import got.backend.repository.IGenericRepository;
import got.backend.repository.UserRepository;
import got.backend.services.GenericService;

public class UserService extends GenericService<User> implements IUserService {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
