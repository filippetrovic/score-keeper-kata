package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.Home;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.TeamScoredEvent;

import java.util.EnumMap;
import java.util.Map;

public class InMemoryMatchRepository implements MatchRepository {

  private Map<Home, Integer> points = new EnumMap<>(Home.class);

  @Override
  public MatchScore getCurrentScore() {
    int homeTeamPoints = points.getOrDefault(Home.HOME, 0);
    int awayTeamPoints = points.getOrDefault(Home.AWAY, 0);
    return new MatchScore(homeTeamPoints, awayTeamPoints);
  }

  @Override
  public void updateScore(TeamScoredEvent teamScoredEvent) {

    Integer currentPoints = points.getOrDefault(teamScoredEvent.getTeam().getHome(), 0);
    Integer newPoints = currentPoints + teamScoredEvent.getPoints();

    points.put(teamScoredEvent.getTeam().getHome(), newPoints);

  }
}
