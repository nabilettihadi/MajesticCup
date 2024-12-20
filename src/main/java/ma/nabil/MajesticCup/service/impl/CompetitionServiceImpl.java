package ma.nabil.MajesticCup.service.impl;

import lombok.RequiredArgsConstructor;
import ma.nabil.MajesticCup.entity.Competition;
import ma.nabil.MajesticCup.entity.Match;
import ma.nabil.MajesticCup.entity.Round;
import ma.nabil.MajesticCup.repository.CompetitionRepository;
import ma.nabil.MajesticCup.repository.MatchRepository;
import ma.nabil.MajesticCup.repository.RoundRepository;
import ma.nabil.MajesticCup.service.CompetitionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final RoundRepository roundRepository;
    private final MatchRepository matchRepository;

    @Override
    public Competition createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getCompetitionById(String id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competition not found"));
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition updateCompetition(String id, Competition competition) {
        Competition existingCompetition = getCompetitionById(id);
        existingCompetition.setName(competition.getName());
        existingCompetition.setNumberOfTeams(competition.getNumberOfTeams());
        existingCompetition.setTeams(competition.getTeams());
        existingCompetition.setCurrentRound(competition.getCurrentRound());
        existingCompetition.setRounds(competition.getRounds());
        return competitionRepository.save(existingCompetition);
    }

    @Override
    public void deleteCompetition(String id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public Competition createNextRound(String competitionId) {
        Competition competition = getCompetitionById(competitionId);
        List<String> teams = new ArrayList<>(competition.getTeams());
        Collections.shuffle(teams);

        Round round = new Round();
        round.setRoundNumber(competition.getCurrentRound() + 1);
        round.setCompetitionId(competitionId);
        round.setMatches(new ArrayList<>());

        for (int i = 0; i < teams.size(); i += 2) {
            if (i + 1 < teams.size()) {
                Match match = new Match();
                match.setRound(round.getRoundNumber());
                match.setTeam1(teams.get(i));
                match.setTeam2(teams.get(i + 1));
                match = matchRepository.save(match);
                round.getMatches().add(match);
            }
        }

        round = roundRepository.save(round);
        competition.setCurrentRound(round.getRoundNumber());
        competition.getRounds().add(round.getId());
        return competitionRepository.save(competition);
    }
}

