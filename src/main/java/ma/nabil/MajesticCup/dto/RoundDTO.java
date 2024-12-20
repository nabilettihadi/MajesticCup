package ma.nabil.MajesticCup.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoundDTO {
    private String id;
    private int roundNumber;
    private String competitionId;
    private List<MatchDTO> matches;
}

