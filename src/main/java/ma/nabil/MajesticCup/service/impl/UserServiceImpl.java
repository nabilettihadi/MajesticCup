package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.UserDTO;
import ma.nabil.MajesticCup.entity.User;
import ma.nabil.MajesticCup.mapper.UserMapper;
import ma.nabil.MajesticCup.repository.UserRepository;
import ma.nabil.MajesticCup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}