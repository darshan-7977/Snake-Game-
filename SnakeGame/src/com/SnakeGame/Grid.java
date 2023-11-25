package com.SnakeGame;

import java.util.LinkedList;

public class Grid {
	private int width;
	private int height;
	private char[][] cells;
	private Snake snake;
	private Food food;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new char[width][height];
		this.snake = new Snake(this);
		this.food = new Food(this);
	}

	public void clear() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[j][i] = ' ';
			}
		}
	}

	public void draw(Snake snake, Food food) {
		clear();

		// Draw the snake on the grid
		LinkedList<Points> body = snake.getBody();
		for (Points segment : body) {
			int x = segment.getX();
			int y = segment.getY();
			if (x >= 0 && x < width && y >= 0 && y < height) {
				cells[x][y] = 'O';
			}
		}

		Points foodPosition = food.getPosition();
		int foodX = foodPosition.getX();
		int foodY = foodPosition.getY();
		if (foodX >= 0 && foodX < width && foodY >= 0 && foodY < height) {
			cells[foodX][foodY] = 'F';
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(cells[j][i] + " ");
			}
			System.out.println();
		}
	}

	public Food getFood() {
		return food;
	}

	public Points getFoodPosition() {
		return food.getPosition();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Snake getSnake() {
		return snake;
	}

	public void reset() {
		clear();
	}
}
