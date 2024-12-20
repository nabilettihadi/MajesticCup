package ma.nabil.MajesticCup.controller;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.entity.Match;
import ma.nabil.MajesticCup.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/api/admin/matches")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchService.createMatch(match));
    }

    @GetMapping("/api/public/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/api/public/matches/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable String id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PutMapping("/api/admin/matches/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Match> updateMatch(@PathVariable String id, @RequestBody Match match) {
        return ResponseEntity.ok(matchService.updateMatch(id, match));
    }

    @DeleteMapping("/api/admin/matches/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMatch(@PathVariable String id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/operator/matches/{id}/result")
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<Match> updateMatchResult(@PathVariable String id, @RequestBody Match.Result result) {
        return ResponseEntity.ok(matchService.updateMatchResult(id, result));
    }
}

