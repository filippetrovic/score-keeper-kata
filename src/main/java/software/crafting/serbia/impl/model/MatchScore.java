package software.crafting.serbia.impl.model;

import java.util.Objects;

public class MatchScore {

  private final int homeScore;
  private final int awayScore;

  public MatchScore(int homeScore, int awayScore) {
    this.homeScore = homeScore;
    this.awayScore = awayScore;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
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
    return homeScore == that.homeScore &&
        awayScore == that.awayScore;
  }

  @Override
  public int hashCode() {
    return Objects.hash(homeScore, awayScore);
  }

  @Override
  public String toString() {
    return "MatchScore{" +
        "homeScore=" + homeScore +
        ", awayScore=" + awayScore +
        '}';
  }
}
