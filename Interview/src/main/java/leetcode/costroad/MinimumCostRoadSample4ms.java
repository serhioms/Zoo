package leetcode.costroad;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostRoadSample4ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int minCost = dist(start[0], start[1], target[0], target[1]);
        int max = specialRoads.length;
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{max, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                int i = pos[0];
                int costI = pos[1];
                if (costI <= dp[i]) {
                    int x2i = (i == max ? start[0] : specialRoads[i][2]);
                    int y2i = (i == max ? start[1] : specialRoads[i][3]);
                    for (int j = 0; j < max; j++) {
                        int x1j = specialRoads[j][0];
                        int y1j = specialRoads[j][1];
                        int x2j = specialRoads[j][2];
                        int y2j = specialRoads[j][3];
                        int costJ = specialRoads[j][4];
                        dp[j] = Math.min(dp[j], costI + dist(x2i, y2i, x2j, y2j));
                        int take = costI + costJ + dist(x2i, y2i, x1j, y1j);
                        if (take < dp[j]) {
                            dp[j] = take;
                            q.add(new int[]{j, take});
                            minCost = Math.min(minCost, take + dist(x2j, y2j, target[0], target[1]));
                        }
                    }
                }
            }
        }
        return minCost;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
