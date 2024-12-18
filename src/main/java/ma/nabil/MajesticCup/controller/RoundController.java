package ma.nabil.MajesticCup.controller;

import ma.nabil.MajesticCup.dto.RoundDTO;
import ma.nabil.MajesticCup.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rounds")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping
    public RoundDTO addRound(@RequestBody RoundDTO roundDTO) {
        return roundService.addRound(roundDTO);
    }

    @GetMapping
    public List<RoundDTO> getAllRounds() {
        return roundService.getAllRounds();
    }

    @PutMapping("/{id}")
    public RoundDTO updateRound(@PathVariable String id, @RequestBody RoundDTO roundDTO) {
        return roundService.updateRound(id, roundDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRound(@PathVariable String id) {
        roundService.deleteRound(id);
    }
}