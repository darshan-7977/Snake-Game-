package com.SnakeGame;

import java.util.LinkedList;

public class Snake {
	private LinkedList<Points> body;
	private Direction direction;
	private Grid grid;

	public Snake(Grid grid) {
		this.grid = grid;
		this.body = new LinkedList<>();
		this.direction = Direction.RIGHT; // Snake initially moves right

		// Initialize the snake with a few body segments (e.g., three segments)
		int initialX = grid.getWidth() / 2;
		int initialY = grid.getHeight() / 2;
		for (int i = 0; i < 3; i++) {
			body.addLast(new Points(initialX - i, initialY));
		}
	}

	public LinkedList<Points> getBody() {
		return body;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		// Ensure the snake can't reverse its direction (e.g., can't go from left to
		// right)
		if (this.direction == Direction.LEFT && direction != Direction.RIGHT
				|| this.direction == Direction.RIGHT && direction != Direction.LEFT
				|| this.direction == Direction.UP && direction != Direction.DOWN
				|| this.direction == Direction.DOWN && direction != Direction.UP) {
			this.direction = direction;
		}
	}

	public void move() {
		// Get the head of the snake
		Points head = body.getFirst();

		// Calculate the new head position based on the current direction
		int newHeadX = head.getX();
		int newHeadY = head.getY();

		switch (direction) {
		case UP:
			newHeadY--;
			break;
		case DOWN:
			newHeadY++;
			break;
		case LEFT:
			newHeadX--;
			break;
		case RIGHT:
			newHeadX++;
			break;
		}

		// Create a new head and add it to the front of the body
		Points newHead = new Points(newHeadX, newHeadY);
		body.addFirst(newHead);

		// Check if the new head collides with food (you need to implement the eatFood()
		// method)

		// If not colliding with food, remove the tail (snake's last segment) to keep
		// the same length
		if (!eatFood()) {
			body.removeLast();
		}
	}

	public boolean eatFood() {
		Points head = body.getFirst();
		Points foodPosition = grid.getFoodPosition();

		if (head.equals(foodPosition)) {
			return true;
		}
		return false;
	}

	public boolean isCollidedWithWall() {
		Points head = body.getFirst();
		int headX = head.getX();
		int headY = head.getY();

		// Implement collision detection with grid boundaries
		return headX < 0 || headX >= grid.getWidth() || headY < 0 || headY >= grid.getHeight();
	}

	public boolean isCollidedWithItself() {
		Points head = body.getFirst();

		// Implement collision detection with the snake's own body
		for (int i = 1; i < body.size(); i++) {
			if (head.equals(body.get(i))) {
				return true;
			}
		}

		return false;
	}
}
