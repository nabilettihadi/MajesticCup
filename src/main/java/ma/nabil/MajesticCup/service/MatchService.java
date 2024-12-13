package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.MatchDTO;

import java.util.List;

public interface MatchService {
    MatchDTO addMatch(MatchDTO matchDTO);
    List<MatchDTO> getAllMatches();
}