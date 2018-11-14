/**
 *
 */
package com.gamigo.player;

import java.util.Random;

import com.gamigo.config.Move;
import com.gamigo.config.Strategy;

/**
 * @author Raksha
 *
 */
public class MoveCreatorImpl implements MoveCreator{

	private Move move;

	public MoveCreatorImpl() {

	}
	public MoveCreatorImpl(Move move) {
		this.move = move;
	}
	public Move getMove() {
		return move;
	}
	public void setMove(Move move) {
		this.move = move;
	}

	@Override
	public Move generateMove(Strategy strategy) {
		if(strategy.equals(Strategy.FIX)) {
			return getMove();
		} else {
			return createRandomMove();

		}
	}
	/**
	 * @return
	 */
	private Move createRandomMove() {
		Move[] moves = Move.values();
		Random random = new Random();
		return moves[random.nextInt(moves.length)];
	}

}
