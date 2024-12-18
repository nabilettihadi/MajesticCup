package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);
}