package ma.nabil.MajesticCup.service;

import ma.nabil.MajesticCup.entity.Competition;

import java.util.List;

public interface CompetitionService {
    Competition createCompetition(Competition competition);

    Competition getCompetitionById(String id);

    List<Competition> getAllCompetitions();

    Competition updateCompetition(String id, Competition competition);

    void deleteCompetition(String id);

    Competition createNextRound(String competitionId);
}