package ma.nabil.MajesticCup.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompetitionDTO {
    private String id;
    private String name;
    private int numberOfTeams;
    private List<String> teams;
    private int currentRound;
    private List<String> rounds;
}