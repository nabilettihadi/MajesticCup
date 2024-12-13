package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.TeamDTO;
import ma.nabil.MajesticCup.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDTO toDTO(Team team);

    Team toEntity(TeamDTO teamDTO);
}