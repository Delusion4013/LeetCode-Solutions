import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Reorganize given edges into one data structure
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<Integer>();
            }
        }
        for(int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        } 
        for(int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        } 
        // Initiate distance calculation
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0,0});
        queue.offer(new int[]{0,1});
        
        // Calculate distance 
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];
            for (int y : next[1-t][x]) {
                if (dist[1-t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1-t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1-t});
            }
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dist[0][i], dist[1][i]);
            if (res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        } 

        return res;
    }
}
// @lc code=end

