package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.entity.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);

    Player getPlayerById(String id);

    List<Player> getAllPlayers();

    Player updatePlayer(String id, Player player);

    void deletePlayer(String id);
}