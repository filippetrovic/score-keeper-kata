package software.crafting.serbia;

import software.crafting.serbia.impl.ScoreKeeperImpl;
import software.crafting.serbia.impl.formatter.ScoreFormatter;
import software.crafting.serbia.impl.formatter.SemaphoreScoreFormatter;
import software.crafting.serbia.impl.repository.InMemoryMatchRepository;
import software.crafting.serbia.impl.repository.MatchRepository;

public class Main {

  public static void main(String[] args) {

    ScoreFormatter formatter = new SemaphoreScoreFormatter();
    MatchRepository repository = new InMemoryMatchRepository();
    ScoreKeeper scoreKeeper = new ScoreKeeperImpl(formatter, repository);

    scoreKeeper.scoreTeamA1();
    scoreKeeper.scoreTeamA2();
    scoreKeeper.scoreTeamA3();

    scoreKeeper.scoreTeamB3();
    scoreKeeper.scoreTeamB2();
    scoreKeeper.scoreTeamB1();

    System.out.println(scoreKeeper.getScore());

    scoreKeeper.scoreTeamA1();
    scoreKeeper.scoreTeamB2();

    System.out.println(scoreKeeper.getScore());


  }

}
