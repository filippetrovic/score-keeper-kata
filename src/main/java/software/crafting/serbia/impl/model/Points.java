package software.crafting.serbia.impl.model;

import java.util.Objects;

public class Points {

  private final int points;

  private Points(int points) {
    this.points = points;
  }

  public static Points of(int points) {
    return new Points(points);
  }

  public static Points zero() {
    return Points.of(0);
  }

  public static Points one() {
    return Points.of(1);
  }

  public static Points two() {
    return Points.of(2);
  }

  public static Points three() {
    return Points.of(3);
  }

  public int asInt() {
    return points;
  }

  public Points plus(Points other) {
    return Points.of(points + other.points);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Points points1 = (Points) o;
    return points == points1.points;
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }

  @Override
  public String toString() {
    return "Points{" +
        "points=" + points +
        '}';
  }
}
