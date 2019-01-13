package software.crafting.serbia.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.crafting.serbia.impl.formatter.ScoreFormatter;
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
    when(matchRepository.getTeamACurrentScore())
        .thenReturn(1);

    when(matchRepository.getTeamBCurrentScore())
        .thenReturn(0);

    // When
    scoreKeeper.getScore();

    // Then
    verify(formatter)
        .format(1, 0);

  }
}