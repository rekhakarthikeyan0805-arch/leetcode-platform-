import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        // Add all thieves to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n 
                    && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // Binary search safeness factor
        int left = 0;
        int right = 2 * n;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isPossible(dist, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean isPossible(int[][] dist, int safe) {
        int n = dist.length;

        if (dist[0][0] < safe)
            return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == n - 1 && curr[1] == n - 1)
                return true;

            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                    && !visited[nx][ny]
                    && dist[nx][ny] >= safe) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
