package software.crafting.serbia.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.crafting.serbia.impl.formatter.ScoreFormatter;
import software.crafting.serbia.impl.model.Home;
import software.crafting.serbia.impl.model.MatchScore;
import software.crafting.serbia.impl.model.Points;
import software.crafting.serbia.impl.model.Team;
import software.crafting.serbia.impl.model.TeamScoredEvent;
import software.crafting.serbia.impl.repository.MatchRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScoreKeeperImplUnitTest {

  @Mock
  private ScoreFormatter formatter;

  @Mock
  private MatchRepository matchRepository;

  @InjectMocks
  private ScoreKeeperImpl scoreKeeper;

  @Test
  public void shouldInvokeFormatterWithCurrentScore() {
    // Given
    when(matchRepository.getCurrentScore())
        .thenReturn(new MatchScore(Points.one(), Points.zero()));

    // When
    scoreKeeper.getScore();

    // Then
    verify(formatter)
        .format(new MatchScore(Points.one(), Points.zero()));

  }

  @Test
  public void shouldInvokeUpdateOnMatchRepository() {
    // Given

    // When
    scoreKeeper.scoreTeamA1();

    // Then
    verify(matchRepository)
        .updateScore(TeamScoredEvent.of(new Team("A", Home.HOME), Points.one()));

  }
}
