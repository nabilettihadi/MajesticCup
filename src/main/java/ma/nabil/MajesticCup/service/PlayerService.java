package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO addPlayer(PlayerDTO playerDTO);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO updatePlayer(String id, PlayerDTO playerDTO);

    void deletePlayer(String id);
}