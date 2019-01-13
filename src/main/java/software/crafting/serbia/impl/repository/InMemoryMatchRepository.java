package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;

public class InMemoryMatchRepository implements MatchRepository {

  @Override
  public MatchScore getCurrentScore() {
    return new MatchScore(0, 0);
  }

  @Override
  public void updateScore(String team, int points) {

  }
}
