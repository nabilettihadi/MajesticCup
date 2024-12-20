package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.dto.MatchDTO.PlayerStatisticsDto;
import ma.nabil.MajesticCup.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, String> {
    List<PlayerStatisticsDto> findTopScorers();

    List<PlayerStatisticsDto> findTopAssists();

    List<PlayerStatisticsDto> findCardStatistics();
}