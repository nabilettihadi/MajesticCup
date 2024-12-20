package ma.nabil.MajesticCup.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "players")
public class Player {
    @Id
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
}