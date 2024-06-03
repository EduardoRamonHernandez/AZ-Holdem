package view_controller;

import java.util.Scanner;

import model.Game;

/**
 * This plays a console game of Arizona Hold-Em, 
 * a reduced version of Texas Hold-Em
 * part
 * @author Rick Mercer and Eduardo Hernandez
 */
public class Main {

	public static void main(String[] args) {
  // Commented out since you might a different name for Game in Iteration 2
	    Game game = new Game();
	    game.start();
  }
}