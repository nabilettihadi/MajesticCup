package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.MatchDTO;

import java.util.List;

public interface MatchService {
    MatchDTO addMatch(MatchDTO matchDTO);

    List<MatchDTO> getAllMatches();

    MatchDTO updateMatch(String id, MatchDTO matchDTO);

    void deleteMatch(String id);
}