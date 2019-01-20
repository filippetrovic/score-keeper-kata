package software.crafting.serbia.impl.repository;

import software.crafting.serbia.impl.model.Home;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.Points;
import software.crafting.serbia.impl.model.TeamScoredEvent;

import java.util.EnumMap;
import java.util.Map;

public class InMemoryMatchRepository implements MatchRepository {

  private Map<Home, Points> points = new EnumMap<>(Home.class);

  @Override
  public MatchScore getCurrentScore() {
    Points homeTeamPoints = points.getOrDefault(Home.HOME, new Points(0));
    Points awayTeamPoints = points.getOrDefault(Home.AWAY, new Points(0));
    return new MatchScore(homeTeamPoints, awayTeamPoints);
  }

  @Override
  public void updateScore(TeamScoredEvent teamScoredEvent) {

    points.merge(
        teamScoredEvent.getTeam().getHome(),
        teamScoredEvent.getPoints(),
        Points::plus);

  }
}
