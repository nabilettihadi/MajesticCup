package ma.nabil.MajesticCup.service.impl;

import ma.nabil.MajesticCup.dto.PlayerDTO;
import ma.nabil.MajesticCup.entity.Player;
import ma.nabil.MajesticCup.mapper.PlayerMapper;
import ma.nabil.MajesticCup.repository.PlayerRepository;
import ma.nabil.MajesticCup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        return playerMapper.toDTO(playerRepository.save(player));
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }
}