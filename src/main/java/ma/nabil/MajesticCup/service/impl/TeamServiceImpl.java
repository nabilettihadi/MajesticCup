package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.TeamDTO;
import ma.nabil.MajesticCup.entity.Team;
import ma.nabil.MajesticCup.mapper.TeamMapper;
import ma.nabil.MajesticCup.repository.TeamRepository;
import ma.nabil.MajesticCup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public TeamDTO addTeam(TeamDTO teamDTO) {
        Team team = teamMapper.toEntity(teamDTO);
        return teamMapper.toDTO(teamRepository.save(team));
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO updateTeam(String id, TeamDTO teamDTO) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            Team team = teamMapper.toEntity(teamDTO);
            team.setId(id);
            return teamMapper.toDTO(teamRepository.save(team));
        }
        return null;
    }

    @Override
    public void deleteTeam(String id) {
        teamRepository.deleteById(id);
    }
}