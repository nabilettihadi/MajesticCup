package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.UserDTO;
import ma.nabil.MajesticCup.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}