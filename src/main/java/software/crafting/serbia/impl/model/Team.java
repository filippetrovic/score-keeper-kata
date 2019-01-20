package software.crafting.serbia.impl.model;

import java.util.Objects;

public class Team {

  private final String name;
  private final Home home;

  public Team(String name, Home home) {
    this.name = name;
    this.home = home;
  }

  public String getName() {
    return name;
  }

  public Home getHome() {
    return home;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Team team = (Team) o;
    return Objects.equals(name, team.name) &&
        home == team.home;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, home);
  }

  @Override
  public String toString() {
    return "Team{" +
        "name='" + name + '\'' +
        ", home=" + home +
        '}';
  }
}
