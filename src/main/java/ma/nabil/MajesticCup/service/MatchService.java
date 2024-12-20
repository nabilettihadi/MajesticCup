package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.entity.Match;

import java.util.List;

public interface MatchService {
    Match createMatch(Match match);

    Match getMatchById(String id);

    List<Match> getAllMatches();

    Match updateMatch(String id, Match match);

    void deleteMatch(String id);

    Match updateMatchResult(String id, Match.Result result);
}