package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.CompetitionDTO;

import java.util.List;

public interface CompetitionService {
    CompetitionDTO addCompetition(CompetitionDTO competitionDTO);
    List<CompetitionDTO> getAllCompetitions();
}