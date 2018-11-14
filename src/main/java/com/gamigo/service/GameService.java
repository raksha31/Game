/**
 *
 */
package com.gamigo.service;

import java.util.Map;

import com.gamigo.config.Move;
import com.gamigo.player.Player;

/**
 * @author Raksha
 *
 */
public interface GameService {
	public void startGame(int numberOfGames);

	public void startplaying(Player playerOne, Player playerTwo, int numberOfGames);

	public void printResult();

	public void findWinner(Move playerAMove,
			Move playerBMove, Map<Move, Move> winningMap);

	int getPlayerAScore();

	int getPlayerBScore();

	int getTies();


}
