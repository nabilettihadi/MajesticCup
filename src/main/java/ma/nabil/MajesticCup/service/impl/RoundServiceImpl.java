package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.RoundDTO;
import ma.nabil.MajesticCup.entity.Round;
import ma.nabil.MajesticCup.mapper.RoundMapper;
import ma.nabil.MajesticCup.repository.RoundRepository;
import ma.nabil.MajesticCup.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private RoundMapper roundMapper;

    @Override
    public RoundDTO addRound(RoundDTO roundDTO) {
        Round round = roundMapper.toEntity(roundDTO);
        return roundMapper.toDTO(roundRepository.save(round));
    }

    @Override
    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .map(roundMapper::toDTO)
                .collect(Collectors.toList());
    }
}