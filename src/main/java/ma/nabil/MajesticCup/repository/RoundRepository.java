package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepository extends MongoRepository<Round, String> {
}