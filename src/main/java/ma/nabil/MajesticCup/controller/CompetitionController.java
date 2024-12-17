package ma.nabil.MajesticCup.controller;

import ma.nabil.MajesticCup.dto.CompetitionDTO;
import ma.nabil.MajesticCup.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    public CompetitionDTO addCompetition(@RequestBody CompetitionDTO competitionDTO) {
        return competitionService.addCompetition(competitionDTO);
    }

    @GetMapping
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }
}