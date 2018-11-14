/**
 *
 */
package com.gamigo.player;

import com.gamigo.config.Move;
import com.gamigo.config.Strategy;

/**
 * @author Raksha
 *
 */
public interface MoveCreator {
	public Move generateMove(Strategy strategy);

}
