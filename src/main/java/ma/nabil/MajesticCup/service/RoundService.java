package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.RoundDTO;

import java.util.List;

public interface RoundService {
    RoundDTO addRound(RoundDTO roundDTO);
    List<RoundDTO> getAllRounds();
}