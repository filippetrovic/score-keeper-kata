package software.crafting.serbia.impl;

import software.crafting.serbia.ScoreKeeper;
import software.crafting.serbia.impl.formatter.ScoreFormatter;
import software.crafting.serbia.impl.repository.MatchRepository;

public class ScoreKeeperImpl implements ScoreKeeper {

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
    matchRepository.updateScore("A", 1);
  }

}
