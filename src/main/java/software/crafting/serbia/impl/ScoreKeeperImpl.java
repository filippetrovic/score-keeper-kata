package software.crafting.serbia.impl;

import software.crafting.serbia.ScoreKeeper;
import software.crafting.serbia.impl.formatter.ScoreFormatter;
import software.crafting.serbia.impl.model.Home;
import software.crafting.serbia.impl.model.Points;
import software.crafting.serbia.impl.model.Team;
import software.crafting.serbia.impl.model.TeamScoredEvent;
import software.crafting.serbia.impl.repository.MatchRepository;

public class ScoreKeeperImpl implements ScoreKeeper {

  public static final Team TEAM_A = new Team("A", Home.HOME);
  public static final Team TEAM_B = new Team("B", Home.AWAY);

  private ScoreFormatter formatter;

  private MatchRepository matchRepository;

  public ScoreKeeperImpl(ScoreFormatter formatter, MatchRepository matchRepository) {
    this.formatter = formatter;
    this.matchRepository = matchRepository;
  }

  @Override
  public String getScore() {
    return formatter.format(matchRepository.getCurrentScore());
  }

  @Override
  public void scoreTeamA1() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_A, Points.one()));
  }

  @Override
  public void scoreTeamB1() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_B, Points.one()));
  }

  @Override
  public void scoreTeamA2() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_A, Points.two()));
  }

  @Override
  public void scoreTeamB2() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_B, Points.two()));
  }

  @Override
  public void scoreTeamA3() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_A, Points.three()));
  }

  @Override
  public void scoreTeamB3() {
    matchRepository.updateScore(TeamScoredEvent.of(TEAM_B, Points.three()));
  }

}
