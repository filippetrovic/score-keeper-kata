package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.TeamScoredEvent;

public class InMemoryMatchRepository implements MatchRepository {

  private int teamAPoints;
  private int teamBPoints;

  @Override
  public MatchScore getCurrentScore() {
    return new MatchScore(teamAPoints, teamBPoints);
  }

  @Override
  public void updateScore(TeamScoredEvent teamScoredEvent) {
    if ("A".equalsIgnoreCase(teamScoredEvent.getTeam())) {
      teamAPoints += teamScoredEvent.getPoints();
    } else if ("B".equalsIgnoreCase(teamScoredEvent.getTeam())) {
      teamBPoints += teamScoredEvent.getPoints();
    }
  }
}
