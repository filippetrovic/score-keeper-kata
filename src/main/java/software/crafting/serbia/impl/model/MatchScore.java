package software.crafting.serbia.impl.model;

import java.util.Objects;

public class MatchScore {

  private final int teamAScore;
  private final int teamBScore;

  public MatchScore(int teamAScore, int teamBScore) {
    this.teamAScore = teamAScore;
    this.teamBScore = teamBScore;
  }

  public int getTeamAScore() {
    return teamAScore;
  }

  public int getTeamBScore() {
    return teamBScore;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchScore that = (MatchScore) o;
    return teamAScore == that.teamAScore &&
        teamBScore == that.teamBScore;
  }

  @Override
  public int hashCode() {
    return Objects.hash(teamAScore, teamBScore);
  }

  @Override
  public String toString() {
    return "MatchScore{" +
        "teamAScore=" + teamAScore +
        ", teamBScore=" + teamBScore +
        '}';
  }
}
