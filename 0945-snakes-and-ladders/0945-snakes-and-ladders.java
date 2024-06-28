  class Solution {
public int snakesAndLadders(int[][] board) {
if (board == null || board.length == 0) return 0; // Check for invalid board input
    
    int n = board.length; // Size of the board (assuming square board)
    boolean[] used = new boolean[n * n + 1]; // Array to track visited positions

    Queue<Integer> q = new LinkedList<>(); // Queue to perform BFS
    q.offer(1); // Start from position 1

    int moves = 0; // Initialize moves counter
    int min = n * n; // Initialize minimum moves to a large number

    while (!q.isEmpty()) {
        int size = q.size(); // Size of current level

        for (int i = 0; i < size; i++) {
            int cur = q.poll(); // Dequeue current position

            if (cur == n * n) { // If reached the last cell
                min = Math.min(min, moves); // Update minimum moves
            }

            for (int j = 1; j <= 6; j++) { // Consider dice rolls from 1 to 6
                if (j + cur > n * n) break; // Skip if next position exceeds board size

                if (!used[j + cur]) { // If position hasn't been visited
                    used[j + cur] = true; // Mark as visited

                    // Calculate row and column from the position
                    int row = n - (j + cur - 1) / n - 1;
                    int col = ((n - row) % 2 != 0) ? (j + cur - 1) % n : n - (j + cur - 1) % n - 1;

                    // Skip if the position is a snake leading back to the current position
                    if (board[row][col] == cur) continue;

                    // Add next position to the queue based on board configuration
                    if (board[row][col] == -1) {
                        q.offer(j + cur); // If no snake or ladder, add next position
                    } else {
                        q.offer(board[row][col]); // Move to the position of snake or ladder
                    }
                }
            }
        }

        moves++; // Increment moves for each level in BFS
    }

    return min == n * n ? -1 : min; // Return minimum moves or -1 if last cell is unreachable
}
  }