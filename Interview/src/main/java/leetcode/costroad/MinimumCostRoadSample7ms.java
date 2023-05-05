package leetcode.costroad;

import java.util.Arrays;

public class MinimumCostRoadSample7ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int max = specialRoads.length;
        boolean[] flag = new boolean[max];
        for (int i = 0; i < max; i++) {
            if (dist(specialRoads[i][0], specialRoads[i][1], specialRoads[i][2], specialRoads[i][3]) <= specialRoads[i][4]) {
                flag[i] = false;
            }
        }
        int[] cost = new int[max];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int minCost = dist(start[0], start[1], target[0], target[1]);
        for (int i = 0; i < max; i++)
            if (!flag[i]) {
                cost[i] = dist(start[0], start[1], specialRoads[i][0], specialRoads[i][1]);
            }
        boolean[] visited = new boolean[max];
        for (int i = 0; i < max; i++) {
            int index = -1;
            for (int j = 0; j < max; j++)
                if (!visited[j] && !flag[j]) {
                    if (index == -1 || cost[j] < cost[index]) {
                        index = j;
                    }
                }
            if (index == -1) {
                break;
            }
            visited[index] = true;
            minCost = Math.min(minCost,
                    cost[index] + Math.min(dist(specialRoads[index][0], specialRoads[index][1], target[0], target[1]),
                            dist(specialRoads[index][2], specialRoads[index][3], target[0], target[1]) + specialRoads[index][4]));
            for (int j = 0; j < max; j++)
                if (!visited[j] && !flag[j]) {
                    cost[j] = Math.min(cost[j],
                            cost[index] + Math.min(dist(specialRoads[index][0], specialRoads[index][1], specialRoads[j][0], specialRoads[j][1]),
                                    dist(specialRoads[index][2], specialRoads[index][3], specialRoads[j][0], specialRoads[j][1]) + specialRoads[index][4]));
                }
        }
        return minCost;
    }

    private int dist(int a, int b, int c, int d) {
        return Math.abs(c - a) + Math.abs(d - b);
    }
}