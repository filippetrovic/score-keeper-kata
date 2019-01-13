package software.crafting.serbia.impl.formatter;

import software.crafting.serbia.impl.model.MatchScore;

public class SemaphoreScoreFormatter implements ScoreFormatter {

  @Override
  public String format(MatchScore matchScore) {
    return String.format("%03d:%03d", matchScore.getTeamAScore(), matchScore.getTeamBScore());
  }

}
