// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minRow = grid.length; 
		int maxRow = -1;
		int minCol = grid[0].length;
		int maxCol = -1;
		
		boolean contains = false;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == ch) {
					contains = true;
					if(i < minRow) {
						minRow = i;
					} 
					if(i >= maxRow) {
						maxRow = i;
					}
					if(j < minCol) {
						minCol = j;
					}  
					if(j >= maxCol) {
						maxCol = j;
					}
				}
			}
		}
		
		if(!contains) return 0; //If 2D array doesn't contians character then ares is 0
		
		return (maxRow - minRow + 1) * (maxCol - minCol + 1); // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int result = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(isPlus(i, j, grid[i][j])) result++;
			}
		}
			
		return result; // TODO ADD YOUR CODE HERE
	}


	//Helper method to determine whether current position is centre of plus or not
	//In othwer words if it is plus
	private boolean isPlus(int i, int j, char ch) {
		//Vertical
		int v1 = 0;
		int tmp = j - 1;
		while(tmp >= 0) {
			if(grid[i][tmp] == ch) {
				v1++;
			} else {
				break;
			}
			tmp--;
		}
		int v2 = 0;
		tmp = j + 1;
		while(tmp < grid[0].length) {
			if(grid[i][tmp] == ch) {
				v2++;
			} else {
				break;
			}
			tmp++;
		}
		if(v1 != v2) return false;
		
		//Horizontal
		int h1 = 0;
		tmp = i - 1;
		while(tmp >= 0) {
			if(grid[tmp][j] == ch) {
				h1++;
			} else {
				break;
			}
			tmp--;
		}
		int h2 = 0;
		tmp = i + 1;
		while(tmp < grid.length) {
			if(grid[tmp][j] == ch) {
				h2++;
			} else {
				break;
			}
			tmp++;
		}
		if(h1 != 0 && h1 == h2 && h1 == v1) return true;
		return false;
	}
}
