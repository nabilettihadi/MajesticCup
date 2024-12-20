package ma.nabil.MajesticCup.controller;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.dto.RoundDto;
import ma.nabil.MajesticCup.service.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rounds")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class RoundController {
    private final RoundService roundService;

    @PostMapping
    public ResponseEntity<RoundDto> createRound(@RequestBody RoundDto roundDto) {
        return ResponseEntity.ok(roundService.createRound(roundDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoundDto> getRoundById(@PathVariable String id) {
        return ResponseEntity.ok(roundService.getRoundById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoundDto>> getAllRounds() {
        return ResponseEntity.ok(roundService.getAllRounds());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoundDto> updateRound(@PathVariable String id, @RequestBody RoundDto roundDto) {
        return ResponseEntity.ok(roundService.updateRound(id, roundDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable String id) {
        roundService.deleteRound(id);
        return ResponseEntity.ok().build();
    }
}

