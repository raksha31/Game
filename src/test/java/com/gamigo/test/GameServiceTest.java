package com.gamigo.test;


import static org.junit.Assert.*;

import com.gamigo.config.Move;
import com.gamigo.config.Strategy;
import com.gamigo.player.MoveCreator;
import com.gamigo.player.MoveCreatorImpl;
import com.gamigo.player.Player;
import com.gamigo.service.GameService;
import com.gamigo.service.GameServiceImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GameServiceTest {

	private GameService gameService;
	private MoveCreator moveCreator;
	private Player playerA;
	private Player playerB;
	private Move playerAMove;
	private int numberOfGames = 100;

	@Before
	public void setup() {
		gameService = new GameServiceImpl();
		moveCreator = new MoveCreatorImpl(Move.PAPER);
		 playerA = new Player(1);
		 playerB = new Player(2);
		 playerAMove = Move.PAPER;

	}

	@Test
	public void testGenerateMove_random() {
		Move randomMove = moveCreator.generateMove(Strategy.RANDOM);
		assertNotNull(randomMove);
		assertTrue(randomMove.equals(Move.PAPER) || randomMove.equals(Move.ROCK)
				|| randomMove.equals(Move.SCISSORS));
	}

	@Test
	public void testGenerateMove_fix() {
		Move randomMove = moveCreator.generateMove(Strategy.FIX);
		assertNotNull(randomMove);
		assertTrue(randomMove.equals(Move.PAPER));
	}
	@Test
	public void testFindWinner_playerA_Alwayswins() {
		Move playerBMove = Move.ROCK;
		getUltimateWinner(playerBMove);
		Assert.assertTrue(numberOfGames == gameService.getPlayerAScore());
	}


	@Test
	public void testFindWinner_playerB_Alwayswins() {
		Move playerBMove = Move.SCISSORS;
		getUltimateWinner(playerBMove);
		Assert.assertTrue(numberOfGames == gameService.getPlayerBScore());

	}
	@Test
	public void testFindWinner_Tie_Always() {
		Move playerBMove = Move.PAPER;
		getUltimateWinner(playerBMove);
		Assert.assertTrue(numberOfGames == gameService.getTies());

	}
	private void getUltimateWinner(Move playerBMove) {
		for(int i=0; i<numberOfGames; i++) {
		gameService.findWinner(playerAMove, playerBMove, Move.getWinningMap());
		}
	}
}
