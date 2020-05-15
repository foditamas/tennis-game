package hu.sonrisa.TennisGameDojo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	TennisGame game = new TennisGame("Boris Becker" , "Bjørn Borg");

	@Test
	public void testNewGameShouldReturnLoveAll()
	{
		String score = game.getScore();

		assertEquals("Love all", score);
	}

	@Test
	public void testPlayerOneWinsFirstBall()
	{
		game.playerOneScores();

		String score = game.getScore();
		assertEquals("Fifteen,Love", score);
	}

	@Test
	public void testFifteenAll(){
		game.playerOneScores();
		game.playerTwoScores();

		String score = game.getScore();
		assertEquals("Fifteen all", score);
	}

	@Test
	public void testPlayerTwoWinsFirstTwoBalls() {
		createScore(0, 2);

		String score = game.getScore();
		assertEquals("Love,Thirty", score);
	}

	@Test
	public void testPlayerOneWinsFirstThreeBalls(){
		createScore(3, 0);
		String score = game.getScore();
		assertEquals("Forty,Love", score);
	}

	@Test
	public void testPlayersAreDeuce() {
		createScore(3, 3);

		String score = game.getScore();
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerOneWinsGame()
	{
		createScore(4, 0);

		String score = game.getScore();
		assertEquals("Boris Becker wins", score);
	}

	@Test
	public void testPlayerTwoWinsGame(){
		createScore(1,4);

		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}

	@Test
	public void testPlayersAreDuce4() {
		createScore(4, 4);
		String score = game.getScore();
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerTwoAdvantage(){
		createScore(4, 5);

		String score = game.getScore();
		assertEquals("Advantage Bjørn Borg", score);
	}

	@Test
	public void testPlayerOneAdvantage(){
		createScore(5, 4);

		String score = game.getScore();
		assertEquals("Advantage Boris Becker", score);
	}

	@Test
	public void testPlayerTwoWins(){
		createScore(2, 4);
		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}

	@Test
	public void testPlayerTwoWinsAfterAdvantage() {
		createScore(6, 8);
		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}

	@Test
	public void testPlayerOneWinsAfterAdvantage() {
		createScore(8, 6);
		String score = game.getScore();
		assertEquals("Boris Becker wins", score);
	}

	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			game.playerTwoScores();
		}
	}

}
