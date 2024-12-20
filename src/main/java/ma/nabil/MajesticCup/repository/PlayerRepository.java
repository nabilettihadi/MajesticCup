package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.dto.PlayerStatisticsDTO;
import ma.nabil.MajesticCup.entity.Player;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
        List<PlayerStatisticsDTO> findTopScorers(); // Implémentez cette méthode
    List<PlayerStatisticsDTO> findTopAssists(); // Implémentez cette méthode
    List<PlayerStatisticsDTO> findCardStatistics();
}