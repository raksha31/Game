/**
 *
 */
package com.gamigo.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raksha
 *
 */
public enum Move {
	ROCK, PAPER, SCISSORS;
	private static Map<Move, Move> winningMap = new HashMap<Move, Move>();


	public static Map<Move, Move> getWinningMap() {
		winningMap.put(ROCK,SCISSORS); // Rock beats Scissors
		winningMap.put(PAPER, ROCK); // Paper beats Rock
		winningMap.put(SCISSORS, PAPER); // Scissors beats Paper
		return winningMap;
	}
}


