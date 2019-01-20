package software.crafting.serbia;

import org.junit.Test;
import software.crafting.serbia.impl.ScoreKeeperImpl;
import software.crafting.serbia.impl.formatter.SemaphoreScoreFormatter;
import software.crafting.serbia.impl.repository.InMemoryMatchRepository;

import static org.assertj.core.api.Assertions.*;

public class ScoreKeeperAcceptanceTest {

  private ScoreKeeper scoreKeeper = new ScoreKeeperImpl(
      new SemaphoreScoreFormatter(),
      new InMemoryMatchRepository());

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
  public void shouldReturn001ForTeamAAfterTeamAScoresOnePoint() {
    // Given
    scoreKeeper.scoreTeamA1();

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("001:000");

  }

  @Test
  public void shouldReturn001vs002AfterTeamAScoresOnePointAndTeamBScoresTwoTimesOnePoint() {
    // Given
    scoreKeeper.scoreTeamA1();
    scoreKeeper.scoreTeamB1();
    scoreKeeper.scoreTeamB1();

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("001:002");

  }

  @Test
  public void shouldReturn004vs003AfterTeamAScoresTwoTimesTwoPointsAndTeamBScoresOneAndTwoPoints() {
    // Given
    scoreKeeper.scoreTeamA2();
    scoreKeeper.scoreTeamB1();
    scoreKeeper.scoreTeamA2();
    scoreKeeper.scoreTeamB2();

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("004:003");

  }

  @Test
  public void shouldReturn006vs006AfterBothTeamsScoreOneTwoAndThreePoints() {
    // Given
    scoreKeeper.scoreTeamB2();
    scoreKeeper.scoreTeamB3();
    scoreKeeper.scoreTeamA1();
    scoreKeeper.scoreTeamA3();
    scoreKeeper.scoreTeamB1();
    scoreKeeper.scoreTeamA2();

    // When
    String result = scoreKeeper.getScore();

    // Then
    assertThat(result)
        .isEqualTo("006:006");

  }

}
