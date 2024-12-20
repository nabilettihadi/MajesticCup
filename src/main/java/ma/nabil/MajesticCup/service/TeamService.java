package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    TeamDTO createTeam(TeamDTO teamDTO);

    TeamDTO getTeamById(String id);

    List<TeamDTO> getAllTeams();

    TeamDTO updateTeam(String id, TeamDTO team);

    void deleteTeam(String id);
}