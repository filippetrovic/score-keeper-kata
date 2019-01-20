package software.crafting.serbia.formatter;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import software.crafting.serbia.impl.formatter.SemaphoreScoreFormatter;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.Points;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SemaphoreScoreFormatterUnitTest {

  @Parameters(name = "{index}: {0} -> {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new MatchScore(new Points(0), new Points(0)), "000:000"},
        {new MatchScore(new Points(1), new Points(0)), "001:000"},
        {new MatchScore(new Points(0), new Points(1)), "000:001"},
        {new MatchScore(new Points(10), new Points(109)), "010:109"},
        {new MatchScore(new Points(200), new Points(201)), "200:201"},
    });
  }


  private MatchScore matchScore;
  private String expected;

  private SemaphoreScoreFormatter formatter = new SemaphoreScoreFormatter();

  public SemaphoreScoreFormatterUnitTest(MatchScore matchScore, String expected) {
    this.matchScore = matchScore;
    this.expected = expected;
  }

  @Test
  public void test() {

    String formattedScore = formatter.format(matchScore);

    Assertions.assertThat(formattedScore)
        .isEqualTo(expected);

  }
}
