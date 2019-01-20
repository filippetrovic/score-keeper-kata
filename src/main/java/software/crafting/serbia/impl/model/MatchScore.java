package software.crafting.serbia.impl.model;

import java.util.Objects;

public class MatchScore {

  private final Points homeScore;
  private final Points awayScore;

  public MatchScore(Points homeScore, Points awayScore) {
    this.homeScore = homeScore;
    this.awayScore = awayScore;
  }

  public Points getHomeScore() {
    return homeScore;
  }

  public Points getAwayScore() {
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
    return Objects.equals(homeScore, that.homeScore) &&
        Objects.equals(awayScore, that.awayScore);
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
