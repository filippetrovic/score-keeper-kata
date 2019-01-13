package software.crafting.serbia;

import org.junit.Ignore;
import org.junit.Test;
import software.crafting.serbia.impl.ScoreKeeperImpl;

import static org.assertj.core.api.Assertions.*;

public class ScoreKeeperAcceptanceTest {

  private ScoreKeeper scoreKeeper = new ScoreKeeperImpl(null, null);

  @Test
  public void shouldReturnZeroZeroAsInitialState() {
    // Given
    // nothing happens - initial state

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("000:000");

  }

  @Test
  @Ignore
  public void shouldReturn001ForTeamAAfterTeamAScoresOnePoint() {
    // Given
    scoreKeeper.scoreTeamA1();

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("001:000");

  }
}
