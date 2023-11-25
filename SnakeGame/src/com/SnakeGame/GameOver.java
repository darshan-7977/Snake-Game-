package com.SnakeGame;

import java.util.Scanner;

public class GameOver {
	private int score;
	private Grid grid;

	public GameOver(Grid grid) {
		this.grid = grid;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void displayGameOverScreen() {
		clearScreen();

		System.out.println("== Game Over ==");
		System.out.println("Your Score: " + score);
		System.out.println("===============");

		// You can provide options for restarting the game
		System.out.println("Press 'R' to restart or 'Q' to quit.");
		char choice = getUserChoice();
		handleUserChoice(choice);
	}

	private char getUserChoice() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toUpperCase().charAt(0);
	}

	private void handleUserChoice(char choice) {
		if (choice == 'R') {
			// Restart the game
			grid.reset();
		} else if (choice == 'Q') {
			// Quit the game
			System.exit(0);
		}
	}

	private void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
