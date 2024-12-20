package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User createUser(User user);

    String loginUser(String username, String password);

    User getUserById(String id);

    User updateUser(String id, User user);

    void deleteUser(String id);
}