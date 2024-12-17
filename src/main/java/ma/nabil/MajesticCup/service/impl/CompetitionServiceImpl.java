package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.CompetitionDTO;
import ma.nabil.MajesticCup.entity.Competition;
import ma.nabil.MajesticCup.mapper.CompetitionMapper;
import ma.nabil.MajesticCup.repository.CompetitionRepository;
import ma.nabil.MajesticCup.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public CompetitionDTO addCompetition(CompetitionDTO competitionDTO) {
        Competition competition = competitionMapper.toEntity(competitionDTO);
        return competitionMapper.toDTO(competitionRepository.save(competition));
    }

    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll().stream()
                .map(competitionMapper::toDTO)
                .collect(Collectors.toList());
    }
}