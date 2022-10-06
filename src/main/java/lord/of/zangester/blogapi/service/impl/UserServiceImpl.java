package lord.of.zangester.blogapi.service.impl;

import lord.of.zangester.blogapi.entity.User;
import lord.of.zangester.blogapi.payload.UserPayload;
import lord.of.zangester.blogapi.repository.UserRepository;
import lord.of.zangester.blogapi.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserPayload userPayload) {
        User user = new User(userPayload.getName(), userPayload.getUsername(), userPayload.getEmail(), userPayload.getPassword());

        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserPayload userPayload) {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isEmpty()){
            throw new UsernameNotFoundException(String.format("User with id %s doesn't exist", id));
        }

        User user = new User();
        user.setName(userPayload.getName());
        user.setUsername(userPayload.getUsername());
        user.setEmail(userPayload.getEmail());
        user.setPassword(userPayload.getPassword());

        userRepository.save(user);
    }
}
