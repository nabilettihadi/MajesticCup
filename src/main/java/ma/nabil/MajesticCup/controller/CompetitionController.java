package ma.nabil.MajesticCup.controller;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.entity.Competition;
import ma.nabil.MajesticCup.service.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/competitions")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<Competition> createCompetition(@RequestBody Competition competition) {
        return ResponseEntity.ok(competitionService.createCompetition(competition));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable String id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @GetMapping
    public ResponseEntity<List<Competition>> getAllCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable String id, @RequestBody Competition competition) {
        return ResponseEntity.ok(competitionService.updateCompetition(id, competition));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/next-round")
    public ResponseEntity<Competition> createNextRound(@PathVariable String id) {
        return ResponseEntity.ok(competitionService.createNextRound(id));
    }
}

