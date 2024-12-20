package ma.nabil.MajesticCup.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchDTO {
    private String id;
    private int round;
    private String team1;
    private String team2;
    private ResultDto result;
    private String winner;

    @Data
    public static class ResultDto {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatisticsDto> statistics;
    }

    @Data
    public static class PlayerStatisticsDto {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}