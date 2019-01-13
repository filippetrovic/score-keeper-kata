package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;

public interface MatchRepository {

  MatchScore getCurrentScore();

  void updateScore(String team, int points);
}
