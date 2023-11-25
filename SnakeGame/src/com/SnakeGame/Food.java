package com.SnakeGame;

public class Food {
	private Points position;
	private Grid grid;

	public Food(Grid grid) {
		this.grid = grid;
		spawn(); // Initialize food position
	}

	public Points getPosition() {
		return position;
	}

	public void spawn() {
		// Generate a new random position for food within the grid
		int maxWidth = grid.getWidth();
		int maxHeight = grid.getHeight();

		// Generate random coordinates for the food
		int x, y;
		do {
			x = (int) (Math.random() * maxWidth);
			y = (int) (Math.random() * maxHeight);
		} while (isCollidingWithSnake(x, y));

		position = new Points(x, y);
	}

	private boolean isCollidingWithSnake(int x, int y) {
		// Check if the generated food position collides with the snake's body
		for (Points segment : grid.getSnake().getBody()) {
			if (segment.getX() == x && segment.getY() == y) {
				return true;
			}
		}
		return false;
	}
}
