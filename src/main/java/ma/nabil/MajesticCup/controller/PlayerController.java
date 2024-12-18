package ma.nabil.MajesticCup.controller;

import ma.nabil.MajesticCup.dto.PlayerDTO;
import ma.nabil.MajesticCup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public PlayerDTO addPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.addPlayer(playerDTO);
    }

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable String id, @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(id, playerDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
    }
}