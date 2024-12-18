package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    TeamDTO addTeam(TeamDTO teamDTO);

    List<TeamDTO> getAllTeams();

    TeamDTO updateTeam(String id, TeamDTO teamDTO);

    void deleteTeam(String id);
}