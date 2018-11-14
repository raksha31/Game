package com.gamigo;



import com.gamigo.service.GameService;
import com.gamigo.service.GameServiceImpl;

/**
 * Hello world!
 *
 */
public class Main
{
	private static final int numberOfGames = 100;


	public static void main( String[] args )
	{
		GameService gameService = new GameServiceImpl();
		gameService.startGame(numberOfGames);
		gameService.printResult();
	}
}
