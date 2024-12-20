package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.CompetitionDTO;
import ma.nabil.MajesticCup.entity.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionDTO toDto(Competition competition);

    Competition toEntity(CompetitionDTO competitionDTO);
}