package ma.nabil.MajesticCup.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.entity.Match;
import ma.nabil.MajesticCup.repository.MatchRepository;
import ma.nabil.MajesticCup.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match getMatchById(String id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match updateMatch(String id, Match match) {
        Match existingMatch = getMatchById(id);
        existingMatch.setRound(match.getRound());
        existingMatch.setTeam1(match.getTeam1());
        existingMatch.setTeam2(match.getTeam2());
        existingMatch.setResult(match.getResult());
        existingMatch.setWinner(match.getWinner());
        return matchRepository.save(existingMatch);
    }

    @Override
    public void deleteMatch(String id) {
        matchRepository.deleteById(id);
    }

    @Override
    public Match updateMatchResult(String id, Match.Result result) {
        Match match = getMatchById(id);
        match.setResult(result);
        if (result.getTeam1Goals() > result.getTeam2Goals()) {
            match.setWinner(match.getTeam1());
        } else if (result.getTeam2Goals() > result.getTeam1Goals()) {
            match.setWinner(match.getTeam2());
        }
        return matchRepository.save(match);
    }
}

