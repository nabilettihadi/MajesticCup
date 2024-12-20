package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.MatchDTO;
import ma.nabil.MajesticCup.entity.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchDTO toDto(Match match);

    Match toEntity(MatchDTO matchDTO);
}