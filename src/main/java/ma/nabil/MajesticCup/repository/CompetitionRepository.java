package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
}