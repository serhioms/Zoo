package leetcode.costroad;

import java.util.HashMap;
import java.util.Map;

/*
1044 / 1044 test cases passed.
Status: Accepted
Runtime: 1270 ms
Memory Usage: 43.9 MB
 */
public class MinimumCostRoadMyOptimize implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {

        Quicksort.quickSort(specialRoads, 1, 0, specialRoads.length-1);

        //print(specialRoads, start, target);


        int[] newTarget = closeMoreExpensiveRoads(specialRoads, start, target);

        return (newTarget==null? 0: cost(newTarget[0], newTarget[1], target[0], target[1]))
                +minimumCost(start, newTarget==null?target:newTarget, specialRoads, 0, "", cost(start[0], start[1], target[0], target[1]));
    }

    private int[] closeMoreExpensiveRoads(int[][] specialRoads, int[] start, int[] target) {
        if( specialRoads.length == 1 ){
            return new int[]{specialRoads[0][2],specialRoads[0][3]};
        }

        int[] newTarget = new int[]{start[0],start[1]};
        Map<String, int[]> roadsSoFar = new HashMap<>(specialRoads.length);
//        Map<String, int[]> enter = new HashMap<>(specialRoads.length);
//        Map<String, int[]> exit = new HashMap<>(specialRoads.length);

        for (int i=0, max=specialRoads.length; i<max; ++i ) {
            int[] road = specialRoads[i];
            int cost = cost(road[0],road[1],road[2],road[3]);

            if( cost < road[4] ){
                specialRoads[i] = null; // close extra cost road
                continue;
            }

            newTarget = max(newTarget, road);

            String keyEnter = road[0] + "," + road[1];
            String keyExit = road[2] + "," + road[3];
            String key = keyEnter + ">" + keyExit;
            int[] prevRoad = roadsSoFar.get(key);

            // remove doubling road
            if( prevRoad != null ){
                if( road[4] >= prevRoad[4] ){
                    specialRoads[i] = null;             // Close current road
                    road = prevRoad;
                } else {
                    specialRoads[prevRoad[5]] = null;   // Close previous road
                }
            } else {
                roadsSoFar.put(key, new int[]{road[0], road[1], road[2], road[3], road[4], i });
            }

            // merge 2 roads into 1
//            if( exit.containsKey(keyEnter) ){
//                int[] secondRoad = exit.get(keyEnter);
//                if( secondRoad[0] < secondRoad[2] && secondRoad[1] < secondRoad[3] ) { // if enter higher then exit
//                    secondRoad[2] = road[2];
//                    secondRoad[3] = road[3];
//                    secondRoad[4] += road[4];
//                    specialRoads[i] = null;             // Close double
//                }
//            }
//            if( enter.containsKey(keyEnter) ){
//                int[] firstRoad = enter.get(keyEnter);
//                if( firstRoad[0] < firstRoad[2] && firstRoad[1] < firstRoad[3] ) { // if first road enter higher then exit
//                    firstRoad[0] = road[0];
//                    firstRoad[1] = road[1];
//                    firstRoad[4] += road[4];
//                    specialRoads[i] = null;             // Close double
//                }
//            }
//            exit.put(keyExit, road);
//            enter.put(keyEnter, road);
        }
        newTarget = min(newTarget, target);
        return newTarget;
    }

    private void print(int[][] specialRoads, int[] start, int[] target) {
        for (int i=0,j=0, max=specialRoads.length; i<max; ++i ) {
            int[] road = specialRoads[i];
            int cost = cost(road[0],road[1],road[2],road[3]);
            if( cost <= road[4] ){
                continue;
            }
            System.out.printf("%3d)height=%5d %4s $%d\n", ++j,
                    road[1]-start[1],
                    direction(road[0],road[1],road[2],road[3]),
                    cost <= road[4]? -road[4]: road[4] // 181 -> 136
                    );
        }
        System.exit(0);
    }

    private String direction(int x0, int y0, int x1, int y1) {
        if( x0 == x1 ){
            return y0 < y1? "DN": y0 > y1? "UP": "*";
        } else if( y0 == y1 ){
            return x0 < x1? "RT": x0 > x1? "LF": "*";
        } else if ( x0 < x1 && y0 < y1 ){
            return "DN->";
        } else if ( x0 < x1 && y0 > y1 ){
            return "UP->";
        } else if ( x0 > x1 && y0 > y1 ){
            return "<-UP";
        } else if ( x0 > x1 && y0 < y1 ){
            return "<-DN";
        }
        return "?";
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
