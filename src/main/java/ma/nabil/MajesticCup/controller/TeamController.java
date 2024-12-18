package ma.nabil.MajesticCup.controller;

import ma.nabil.MajesticCup.dto.TeamDTO;
import ma.nabil.MajesticCup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO) {
        return teamService.addTeam(teamDTO);
    }

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    public TeamDTO updateTeam(@PathVariable String id, @RequestBody TeamDTO teamDTO) {
        return teamService.updateTeam(id, teamDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable String id) {
        teamService.deleteTeam(id);
    }
}