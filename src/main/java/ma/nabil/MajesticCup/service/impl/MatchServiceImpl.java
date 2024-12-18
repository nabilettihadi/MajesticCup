package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.MatchDTO;
import ma.nabil.MajesticCup.entity.Match;
import ma.nabil.MajesticCup.mapper.MatchMapper;
import ma.nabil.MajesticCup.repository.MatchRepository;
import ma.nabil.MajesticCup.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public MatchDTO addMatch(MatchDTO matchDTO) {
        Match match = matchMapper.toEntity(matchDTO);
        return matchMapper.toDTO(matchRepository.save(match));
    }

    @Override
    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MatchDTO updateMatch(String id, MatchDTO matchDTO) {
        Optional<Match> existingMatch = matchRepository.findById(id);
        if (existingMatch.isPresent()) {
            Match match = matchMapper.toEntity(matchDTO);
            match.setId(id);
            return matchMapper.toDTO(matchRepository.save(match));
        }
        return null;
    }

    @Override
    public void deleteMatch(String id) {
        matchRepository.deleteById(id);
    }
}