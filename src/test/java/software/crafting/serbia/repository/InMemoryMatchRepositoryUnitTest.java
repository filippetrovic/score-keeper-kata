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
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), new Points(1)));
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), new Points(1)));

    // When
    final MatchScore currentScore = repository.getCurrentScore();

    // Then
    assertThat(currentScore)
        .isEqualTo(new MatchScore(new Points(2), new Points(0)));

  }

  @Test
  public void shouldRecordOnePointForTeamA() {
    // Given
    repository.updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), new Points(1)));
    repository.updateScore(TeamScoredEvent.of(new Team("B", Home.AWAY), new Points(2)));

    // When
    final MatchScore currentScore = repository.getCurrentScore();

    // Then
    assertThat(currentScore)
        .isEqualTo(new MatchScore(new Points(1), new Points(2)));

  }

}
