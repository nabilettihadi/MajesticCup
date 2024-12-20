package ma.nabil.MajesticCup.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.entity.Player;
import ma.nabil.MajesticCup.repository.PlayerRepository;
import ma.nabil.MajesticCup.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(String id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(String id, Player player) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setName(player.getName());
        existingPlayer.setSurname(player.getSurname());
        existingPlayer.setPosition(player.getPosition());
        existingPlayer.setNumber(player.getNumber());
        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }
}

