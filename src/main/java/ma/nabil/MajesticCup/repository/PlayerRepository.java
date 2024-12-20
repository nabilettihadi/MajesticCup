package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, String> {

    @Query(value = "{}", sort = "{ goals: -1 }")
    List<Player> findTopScorers();

    @Query(value = "{ assists: { $exists: true } }", sort = "{ assists: -1 }")
    List<Player> findTopAssists();

    @Query(value = "{ $or: [ { yellowCards: { $exists: true } }, { redCards: { $exists: true } } ] }")
    List<Player> findCardStatistics();
}