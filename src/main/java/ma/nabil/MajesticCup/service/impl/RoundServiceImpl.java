package ma.nabil.MajesticCup.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.dto.RoundDTO;
import ma.nabil.MajesticCup.entity.Round;
import ma.nabil.MajesticCup.mapper.RoundMapper;
import ma.nabil.MajesticCup.repository.RoundRepository;
import ma.nabil.MajesticCup.service.RoundService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;

    @Override
    public RoundDTO createRound(RoundDTO roundDto) {
        Round round = roundMapper.toEntity(roundDto);
        return roundMapper.toDto(roundRepository.save(round));
    }

    @Override
    public RoundDTO getRoundById(String id) {
        return roundMapper.toDto(roundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Round not found")));
    }

    @Override
    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .map(roundMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoundDTO updateRound(String id, RoundDTO roundDto) {
        Round existingRound = roundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Round not found"));
        Round updatedRound = roundMapper.toEntity(roundDto);
        updatedRound.setId(existingRound.getId());
        return roundMapper.toDto(roundRepository.save(updatedRound));
    }

    @Override
    public void deleteRound(String id) {
        roundRepository.deleteById(id);
    }
}

