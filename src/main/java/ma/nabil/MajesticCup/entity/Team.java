package ma.nabil.MajesticCup.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String city;
    private List<Player> players;
}