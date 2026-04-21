package graph;

public class GraphProblems {
	
	
	/*
	 * -------------------
	 * Graph Problems
	 * -------------------
	 * 
	 * 1. Number of Islands
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * 1. Number of Islands
	 *
	 * <pre>
	 * Description:
	 * Given a 2D grid of 0's (water) and 1's (land),
	 * count the number of islands.
	 *
	 * An island is surrounded by water and is formed by
	 * connecting adjacent lands horizontally or vertically.
	 *
	 * Example:
	 * Input:
	 * [
	 *   [1,1,0,0],
	 *   [1,1,0,0],
	 *   [0,0,1,0],
	 *   [0,0,0,1]
	 * ]
	 * Output: 3
	 *
	 * Approach:
	 * - Traverse each cell in the grid.
	 * - When a land cell (1) is found:
	 *      - Perform DFS to mark the entire island as visited (convert to 0)
	 *      - Increment island count
	 *
	 * - DFS explores all 4 directions (up, down, left, right).
	 *
	 * Time Complexity: O(m * n)
	 * Space Complexity: O(m * n) (recursion stack in worst case)
	 *
	 * </pre>
	 *
	 * @param grid 2D grid representing land and water
	 * @return number of islands
	 */
	public static int numberOfIslands(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int islandCount = 0;
		int totalRows = grid.length;
		int totalCols = grid[0].length;

		for (int row = 0; row < totalRows; row++) {
			for (int col = 0; col < totalCols; col++) {
				// If land found, explore entire island
				if (grid[row][col] == 1) {
					exploreIsland(grid, row, col);
					islandCount++;
				}
			}
		}
		return islandCount;
	}

	private static void exploreIsland(int[][] grid, int row, int col) {
		// Boundary check + water check
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return;
		}

		// Mark current cell as visited
		grid[row][col] = 0;

		// Explore all 4 directions
		exploreIsland(grid, row - 1, col);
		exploreIsland(grid, row + 1, col);
		exploreIsland(grid, row, col - 1);
		exploreIsland(grid, row, col + 1);
	}
}
