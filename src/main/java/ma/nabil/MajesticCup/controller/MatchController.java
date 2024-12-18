package ma.nabil.MajesticCup.controller;

import ma.nabil.MajesticCup.dto.MatchDTO;
import ma.nabil.MajesticCup.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public MatchDTO addMatch(@RequestBody MatchDTO matchDTO) {
        return matchService.addMatch(matchDTO);
    }

    @GetMapping
    public List<MatchDTO> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PutMapping("/{id}")
    public MatchDTO updateMatch(@PathVariable String id, @RequestBody MatchDTO matchDTO) {
        return matchService.updateMatch(id, matchDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable String id) {
        matchService.deleteMatch(id);
    }
}