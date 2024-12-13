package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
}