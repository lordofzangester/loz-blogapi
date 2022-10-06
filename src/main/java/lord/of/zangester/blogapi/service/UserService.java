package lord.of.zangester.blogapi.service;

import lord.of.zangester.blogapi.payload.UserPayload;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void addUser(UserPayload userPayload);
    void updateUser(Long id, UserPayload userPayload);
}
