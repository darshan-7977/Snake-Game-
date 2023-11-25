package com.SnakeGame;

import java.util.Scanner;

public class SnakeGame {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Grid grid = new Grid(20, 20); // Create a 20x20 grid
		Snake snake = new Snake(grid);
		Food food = new Food(grid);
		GameOver gameOver = new GameOver(grid);

		boolean gameOverCondition = false;

		while (!gameOverCondition) {
			grid.clear();
			snake.move();

			if (snake.eatFood()) {
				food.spawn();
			}

			grid.draw(snake, food);

			if (snake.isCollidedWithWall() || snake.isCollidedWithItself()) {
				gameOverCondition = true;
//                gameOver.setScore(snake.getScore());
				gameOver.displayGameOverScreen();
				char choice = scanner.nextLine().toUpperCase().charAt(0);
				if (choice == 'R' || choice == 'r') {
					grid.reset();
					snake = new Snake(grid);
					food = new Food(grid);
					gameOverCondition = false;
				} else if (choice == 'Q' || choice == 'q') {
					System.exit(0);
				}
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
