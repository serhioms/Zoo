package leetcode.costroad;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostRoadSample8ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int dist = dist(start[0],specialRoads[i][0],start[1],specialRoads[i][1]) + specialRoads[i][4];
            dp[i] = dist;
            pq.offer(new int[]{dist, i});
        }
        int minCost = Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] >= minCost || temp[0] != dp[temp[1]]) {
                continue;
            }
            minCost = Math.min(minCost, temp[0] + dist(target[0],specialRoads[temp[1]][2],target[1],specialRoads[temp[1]][3]));
            for (int i = 0; i < n; i++) {
                int dist = temp[0] + dist(specialRoads[temp[1]][2],specialRoads[i][0],specialRoads[temp[1]][3],specialRoads[i][1]) + specialRoads[i][4];
                if (dist >= minCost || dist >= dp[i]) {
                    continue;
                }
                dp[i] = dist;
                pq.offer(new int[]{dist, i});
            }
        }
        return minCost;
    }

    private int dist(int a, int b, int c, int d) {
        return Math.abs(a - b) + Math.abs(c - d);
    }

}