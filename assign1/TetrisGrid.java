//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

import java.util.ArrayList;
import java.util.List;

public class TetrisGrid {
	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid. Does not make a copy.
	 * 
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for (int y = 0; y < grid[0].length; y++) {
			if (checkRow(y)) {
				getDownRows(y);
				y--;
			}
		}
	}

	private void getDownRows(int row) {
		for(int i = row + 1; i < grid[0].length; i++) {
			for ( int x = 0; x < grid.length; x++ ) {
				grid[x][i - 1] = grid[x][i];
			}
		}
		
		//Fill last row with false
		int lastRow = grid[0].length - 1;
		for ( int x = 0; x < grid.length; x++ ) {
			grid[x][lastRow] = false;
		}
	}

	// Helper to check rows
	private boolean checkRow(int y) {
		for (int x = 0; x < grid.length; x++) {
			if (!grid[x][y])
				return false;
		}
		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * 
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // TODO YOUR CODE HERE
	}
}
