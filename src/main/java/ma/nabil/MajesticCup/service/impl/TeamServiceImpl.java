package ma.nabil.MajesticCup.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.dto.TeamDTO;
import ma.nabil.MajesticCup.entity.Team;
import ma.nabil.MajesticCup.mapper.TeamMapper;
import ma.nabil.MajesticCup.repository.TeamRepository;
import ma.nabil.MajesticCup.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamDTO createTeam(TeamDTO teamDto) {
        Team team = teamMapper.toEntity(teamDto);
        return teamMapper.toDto(teamRepository.save(team));
    }

    @Override
    public TeamDTO getTeamById(String id) {
        return teamMapper.toDto(teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found")));
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO updateTeam(String id, TeamDTO teamDto) {
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        Team updatedTeam = teamMapper.toEntity(teamDto);
        updatedTeam.setId(existingTeam.getId());
        return teamMapper.toDto(teamRepository.save(updatedTeam));
    }

    @Override
    public void deleteTeam(String id) {
        teamRepository.deleteById(id);
    }
}

