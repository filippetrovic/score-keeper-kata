package software.crafting.serbia.repository;

import org.junit.Test;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.repository.InMemoryMatchRepository;

import static org.assertj.core.api.Assertions.*;

public class InMemoryMatchRepositoryUnitTest {

  private InMemoryMatchRepository repository = new InMemoryMatchRepository();

  @Test
  public void shouldRecordTwoPointForTeamA() {
    // Given
    repository.updateScore("A", 1);
    repository.updateScore("A", 1);

    // When
    final MatchScore currentScore = repository.getCurrentScore();

    // Then
    assertThat(currentScore)
        .isEqualTo(new MatchScore(2, 0));

  }


}
