package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;

public class InMemoryMatchRepository implements MatchRepository {

  private int teamAPoints;

  @Override
  public MatchScore getCurrentScore() {
    return new MatchScore(teamAPoints, 0);
  }

  @Override
  public void updateScore(String team, int points) {
    teamAPoints += points;
  }
}
