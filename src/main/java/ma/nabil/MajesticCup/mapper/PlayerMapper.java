package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.PlayerDTO;
import ma.nabil.MajesticCup.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerDTO toDTO(Player player);

    Player toEntity(PlayerDTO playerDTO);
}