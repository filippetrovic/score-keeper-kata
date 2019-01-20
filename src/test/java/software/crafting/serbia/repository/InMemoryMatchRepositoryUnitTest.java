package software.crafting.serbia.repository;

import org.junit.Test;
import software.crafting.serbia.impl.model.Home;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.Points;
import software.crafting.serbia.impl.model.Team;
import software.crafting.serbia.impl.model.TeamScoredEvent;
import software.crafting.serbia.impl.repository.InMemoryMatchRepository;

import static org.assertj.core.api.Assertions.*;

public class InMemoryMatchRepositoryUnitTest {

  private InMemoryMatchRepository repository = new InMemoryMatchRepository();

  @Test
  public void shouldRecordTwoPointForTeamA() {
    // Given
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), Points.one()));
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), Points.one()));

    // When
    final MatchScore currentScore = repository.getCurrentScore();

    // Then
    assertThat(currentScore)
        .isEqualTo(new MatchScore(Points.two(), Points.zero()));

  }

  @Test
  public void shouldRecordOnePointForTeamA() {
    // Given
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), Points.one()));
    repository.updateScore(TeamScoredEvent.of(new Team("B", Home.AWAY), Points.two()));

    // When
    final MatchScore currentScore = repository.getCurrentScore();

    // Then
    assertThat(currentScore)
        .isEqualTo(new MatchScore(Points.one(), Points.two()));

  }

}
