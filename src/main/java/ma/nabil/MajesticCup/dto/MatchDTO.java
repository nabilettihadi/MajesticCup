package ma.nabil.MajesticCup.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchDTO {
    private String id;
    private int round;
    private TeamDTO team1;
    private TeamDTO team2;
    private ResultDTO result;
    private String winner;

    @Data
    public static class ResultDTO {
        private int team1Goals;
        private int team2Goals;
        private List<StatisticsDTO> statistics;

        @Data
        public static class StatisticsDTO {
            private String playerId;
            private int goals;
            private int assists;
            private int yellowCards;
            private int redCards;
        }
    }
}