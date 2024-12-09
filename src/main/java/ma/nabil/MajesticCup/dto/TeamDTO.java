package ma.nabil.MajesticCup.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    private String id;
    private String name;
    private String city;
    private List<PlayerDTO> players;
}