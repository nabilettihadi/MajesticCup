package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
}