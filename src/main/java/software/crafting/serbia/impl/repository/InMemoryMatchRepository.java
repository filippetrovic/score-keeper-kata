package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;

public class InMemoryMatchRepository implements MatchRepository {

  private int teamAPoints;
  private int teamBPoints;

  @Override
  public MatchScore getCurrentScore() {
    return new MatchScore(teamAPoints, teamBPoints);
  }

  @Override
  public void updateScore(String team, int points) {
    if ("A".equalsIgnoreCase(team)) {
      teamAPoints += points;
    } else if ("B".equalsIgnoreCase(team)) {
      teamBPoints += points;
    }
  }
}
