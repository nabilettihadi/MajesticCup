package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.RoundDTO;

import java.util.List;

public interface RoundService {
    RoundDTO createRound(RoundDTO roundDto);

    RoundDTO getRoundById(String id);

    List<RoundDTO> getAllRounds();

    RoundDTO updateRound(String id, RoundDTO roundDto);

    void deleteRound(String id);
}