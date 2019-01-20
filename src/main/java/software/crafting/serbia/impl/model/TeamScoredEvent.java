package software.crafting.serbia.impl.model;

import java.util.Objects;

public class TeamScoredEvent {

  private final Team team;
  private final Points points;

  private TeamScoredEvent(Team team, Points points) {
    this.team = team;
    this.points = points;
  }

  public static TeamScoredEvent of(Team team, Points points) {
    return new TeamScoredEvent(team, points);
  }

  public Team getTeam() {
    return team;
  }

  public Points getPoints() {
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
    return Objects.equals(points,that.points) &&
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
