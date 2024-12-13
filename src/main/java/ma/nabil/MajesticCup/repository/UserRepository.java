package ma.nabil.MajesticCup.repository;

import ma.nabil.MajesticCup.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}