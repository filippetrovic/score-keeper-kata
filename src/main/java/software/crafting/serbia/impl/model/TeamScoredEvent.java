package software.crafting.serbia.impl.model;

import java.util.Objects;

public class TeamScoredEvent {

  private final Team team;
  private final int points;

  public TeamScoredEvent(Team team, int points) {
    this.team = team;
    this.points = points;
  }

  public Team getTeam() {
    return team;
  }

  public int getPoints() {
    return points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeamScoredEvent that = (TeamScoredEvent) o;
    return points == that.points &&
        Objects.equals(team, that.team);
  }

  @Override
  public int hashCode() {
    return Objects.hash(team, points);
  }

  @Override
  public String toString() {
    return "TeamScoredEvent{" +
        "team='" + team + '\'' +
        ", points=" + points +
        '}';
  }
}
