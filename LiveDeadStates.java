package com.project.statesoflife;

import java.util.Scanner;

public class LiveDeadStates {

	public final static int DEAD = 0;
	public final static int LIVE = 1;

	public final static void main(String[] args) {
		LiveDeadStates liveDeadStates = new LiveDeadStates();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of cells in 2D grid: ");
		int numberOfCells = sc.nextInt();
		int rows = (int) Math.sqrt(numberOfCells);
		int columns = rows;

		int[][] cellGrid = new int[rows][columns];
		System.out.println("Enter the all cell elements row by row: ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int cellValue = sc.nextInt();
				cellGrid[i][j] = cellValue;
			}
		}
		System.out.println("Enter the number of ticks: ");
		int inputTicks = sc.nextInt();
		liveDeadStates.test(inputTicks, cellGrid);
	}

	private void test(int nrIterations, int[][] grid) {
		System.out.println("Seed system: ");
		printGrid(grid);
		System.out.println();
		
		System.out.println("Next " + nrIterations + " ticks are: ");
		for (int i = 0; i < nrIterations; i++) {
			System.out.println();
			grid = getNextGrid(grid);
			printGrid(grid);
		}
	}

	private void printGrid(int[][] grid) {
		for (int i = 0, rLeng = grid.length; i < rLeng; i++) {

			for (int j = 0, cLeng = grid[i].length; j < cLeng; j++) {
				System.out.print(Integer.toString(grid[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public int[][] getNextGrid(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			throw new IllegalArgumentException("Grid should have a positive number of rows and columns");
		}

		int numberOfRows = grid.length;
		int numberOfColumns = grid[0].length;

		int[][] tempGrid = new int[numberOfRows][numberOfColumns];

		for (int row = 0; row < numberOfRows; row++) {

			for (int column = 0; column < numberOfColumns; column++) {
				tempGrid[row][column] = getTransitionsState(grid[row][column], getLiveNeighbours(row, column, grid));
			}
		}
		return tempGrid;
	}

	private int getLiveNeighbours(int rowCell, int columnCell, int[][] grid) {
		int liveNeighbours = 0;
		int rowEnd = Math.min(grid.length, rowCell + 2);
		int colEnd = Math.min(grid[0].length, columnCell + 2);

		for (int row = Math.max(0, rowCell - 1); row < rowEnd; row++) {
			for (int col = Math.max(0, columnCell - 1); col < colEnd; col++) {
				if ((row != rowCell || col != columnCell) && grid[row][col] == LIVE) {
					liveNeighbours++;
				}
			}
		}
		return liveNeighbours;
	}

	private int getTransitionsState(int currentState, int liveNeighbours) {
		int newState = currentState;

		switch (currentState) {
		case LIVE:

			if (liveNeighbours < 2) {
				newState = DEAD;
			}

			if (liveNeighbours == 2 || liveNeighbours == 3) {
				newState = LIVE;
			}

			if (liveNeighbours > 3) {
				newState = DEAD;
			}
			break;

		case DEAD:
			if (liveNeighbours == 3) {
				newState = LIVE;
			}
			break;

		default:
			throw new IllegalArgumentException("State of cell either LIVE or DEAD");
		}
		return newState;
	}
}
