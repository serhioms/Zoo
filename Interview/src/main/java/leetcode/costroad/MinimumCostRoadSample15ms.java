package leetcode.costroad;

import java.util.Arrays;

public class MinimumCostRoadSample15ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int [] rCosts = new int[specialRoads.length];
        for (int i = 0; i < rCosts.length; i++){
            rCosts[i] = dist(start[0], start[1], specialRoads[i][0],  specialRoads[i][1]);
        }

        Integer [] ind = new Integer[specialRoads.length];
        for (int i = 0; i < ind.length; i++){
            ind[i] = i;
        }

        int cost = dist(start[0], start[1], target[0], target[1]);
        for (int i = 0; i < specialRoads.length; i++){
            Arrays.sort(ind, (x, y) -> rCosts[x] - rCosts[y]);
            //System.out.println(Arrays.toString(rCosts)+ " , " + cost);
            int endCost = rCosts[ind[i]] + specialRoads[ind[i]][4];
            for (int j = i + 1; j < rCosts.length; j++){
                rCosts[ind[j]] = Math.min(rCosts[ind[j]], endCost + dist(specialRoads[ind[i]][2], specialRoads[ind[i]][3], specialRoads[ind[j]][0], specialRoads[ind[j]][1]));
            }
            cost = Math.min(cost, endCost + dist(specialRoads[ind[i]][2], specialRoads[ind[i]][3],target[0], target[1]));
        }
        return cost;
    }

    static int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}