package ma.nabil.MajesticCup.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "matches")
public class Match {
    @Id
    private String id;
    private int round;
    private String team1;
    private String team2;
    private Result result;
    private String winner;

    @Data
    public static class Result {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatistics> statistics;
    }

    @Data
    public static class PlayerStatistics {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}