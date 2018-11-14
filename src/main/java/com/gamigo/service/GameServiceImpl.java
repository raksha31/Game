/**
 *
 */
package com.gamigo.service;

import java.util.Map;

import com.gamigo.config.Move;
import com.gamigo.config.Strategy;
import com.gamigo.player.MoveCreator;
import com.gamigo.player.MoveCreatorImpl;
import com.gamigo.player.Player;

/**
 * @author Raksha
 *
 */
public class GameServiceImpl implements GameService {

private MoveCreator moveCreator;

	private int playerAScore=0;
	private int playerBscore=0;
	private int ties=0;

	private Player playerA;
	private Player playerB;

	@Override
	public void startGame(int numberOfGames) {
		playerA = new Player(1);
		playerB = new Player(2);
		startplaying(playerA, playerB, numberOfGames);
	}


	@Override
	public void startplaying(Player playerA, Player playerB, int numberOfGames) {
		this.playerA = playerA;
		this.playerB = playerB;
		moveCreator = new MoveCreatorImpl(Move.PAPER);
		Move playerAMove = moveCreator.generateMove(Strategy.FIX);
		Map<Move, Move> winningMap = Move.getWinningMap();
		for(int i=0; i<numberOfGames; i++) {
			Move playerBMove = moveCreator.generateMove(Strategy.RANDOM);
			findWinner(playerAMove, playerBMove, winningMap);
		}
	}


	/**
	 * @param playerAMove
	 * @param winningMap
	 * @param playerBMove
	 */
	@Override
	public void findWinner(Move playerAMove, Move playerBMove,
			Map<Move, Move> winningMap) {
		if (playerAMove.equals(playerBMove)) {
			ties++;
		} else if (playerAMove.equals(winningMap.get(playerBMove))) {
			playerBscore++;
		} else {
			playerAScore++;
		}
	}

	@Override
	public int getPlayerAScore() {
		return playerAScore;
	}
	@Override
	public int getPlayerBScore() {
		return playerBscore;
	}
	@Override
	public int getTies() {
		return ties;
	}
	@Override
	public void printResult() {
		System.out.println("Player A wins " + playerAScore + " out of 100 games");
		System.out.println("Player B wins " + playerBscore + " out of 100 games");
		System.out.println("Tie: " +  ties + " of 100 games");

		if(playerAScore > playerBscore) {
			System.out.println("Winner is Player A (" + playerAScore + " to " + playerBscore +" wins )");
		} else if(playerAScore < playerBscore) {
			System.out.println("Winner is Player B (" + playerBscore + " to " + playerAScore +" wins )");
		}
	}

}
