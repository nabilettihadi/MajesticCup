package ma.nabil.MajesticCup.mapper;

import ma.nabil.MajesticCup.dto.RoundDTO;
import ma.nabil.MajesticCup.entity.Round;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoundMapper {
    RoundDTO toDTO(Round round);

    Round toEntity(RoundDTO roundDTO);
}