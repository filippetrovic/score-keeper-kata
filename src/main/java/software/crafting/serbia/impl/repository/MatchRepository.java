package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.TeamScoredEvent;

public interface MatchRepository {

  MatchScore getCurrentScore();

  void updateScore(TeamScoredEvent teamScoredEvent);
}
