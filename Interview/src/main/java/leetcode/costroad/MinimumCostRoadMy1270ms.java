package leetcode.costroad;

import java.util.HashMap;
import java.util.Map;

/*
1044 / 1044 test cases passed.
Status: Accepted
Runtime: 1270 ms
Memory Usage: 43.9 MB
 */
public class MinimumCostRoadMy1270ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int[] newTarget = closeMoreExpensiceRoads(specialRoads, start, target);

        return (newTarget==null? 0: cost(newTarget[0], newTarget[1], target[0], target[1]))
                +minimumCost(start, newTarget==null?target:newTarget, specialRoads, 0, "", cost(start[0], start[1], target[0], target[1]));
    }

    private int[] closeMoreExpensiceRoads(int[][] specialRoads, int[] start, int[] target) {
        int[] newTarget = new int[]{start[0],start[1]};
        Map<String, int[]> roadsSoFar = new HashMap<>(specialRoads.length);

        for (int i=0, max=specialRoads.length; i<max; ++i ) {
            int[] curRoad = specialRoads[i];

            newTarget = max(newTarget, curRoad);

            String key = curRoad[0] + "," + curRoad[1] + ">" + curRoad[2] + "," + curRoad[3];
            int[] prevRoad = roadsSoFar.get(key);

            if( prevRoad != null ){
                if( curRoad[4] >= prevRoad[4] ){
                    specialRoads[i] = null;             // Close current road
                } else {
                    specialRoads[prevRoad[5]] = null;   // Close previous road
                }
            } else {
                roadsSoFar.put(key, new int[]{curRoad[0], curRoad[1], curRoad[2], curRoad[3], curRoad[4], i });
            }

        }
        newTarget = min(newTarget, target);
        return newTarget;
    }

    private int[] max(int[] target, int[] road) {
        if( target[0] < road[0] ){
            target[0] = road[0];
        }
        if( target[0] < road[2] ){
            target[0] = road[2];
        }
        if( target[1] < road[1] ){
            target[1] = road[1];
        }
        if( target[1] < road[3] ){
            target[1] = road[3];
        }
        return target;
    }

    private int[] min(int[] target, int[] max) {
        if( target[0] > max[0] ){
            target[0] = max[0];
        }
        if( target[1] > max[1] ){
            target[1] = max[1];
        }
        return target;
    }

    public int minimumCost(int[] start, int[] target, int[][] specialRoads, int costSoFar, String path, int minCostSoFar) {
        int prevCostSoFar = -1;
        path += "(" + start[0] + "," + start[1] + ")";
        try {
            for (int[] special: specialRoads) {
                if( special == null ){
                    continue;
                }

                String nextStep = "(" + special[2] + "," + special[3] + ")";
                if (!path.contains(nextStep)) {

                    int currCost = costSoFar
                            + special[4]
                            + (start[0] == special[0] && start[1] == special[1] ? 0 : cost(start[0], start[1], special[0], special[1]));

                    if (currCost < minCostSoFar) {
                        minCostSoFar = Math.min(minCostSoFar, minimumCost(new int[]{special[2], special[3]}, target, specialRoads,
                                currCost,
                                path + "(" + special[0] + "," + special[1] + ")",
                                minCostSoFar
                                ));
                    }
                }
            }
            prevCostSoFar = costSoFar;
            costSoFar += cost(start[0], start[1], target[0], target[1]);
            minCostSoFar = Math.min(minCostSoFar, costSoFar);
            return minCostSoFar;
        } finally {
            //System.out.println((path += "(" + target[0] + "," + target[1] + ")")+" = "+prevCostSoFar+" -> "+costSoFar+" => "+minCostSoFar);
        }
    }

    public int cost(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

}
