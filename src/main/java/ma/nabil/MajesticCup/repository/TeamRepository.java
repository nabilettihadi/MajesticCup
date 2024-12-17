package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
}