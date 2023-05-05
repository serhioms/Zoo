package leetcode.costroad;

public class MinimumCostRoadSample5ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        int max = specialRoads.length;
        int[] specialDistance = new int[max];
        for (int i = 0; i < max; ++i) {
            specialDistance[i] = dist(specialRoads[i][0],start[0],specialRoads[i][1],start[1]) + specialRoads[i][4];
        }
        for (int i = 0; i < max; ++i) {
            int dist1 = specialDistance[i];
            int dist2 = dist(specialRoads[i][2],start[0],specialRoads[i][3],start[1]);
            dist1 = Math.min(dist1, dist2);
            for (int j = 0; j < max; j++) {
                int dist3 = specialDistance[j] + dist(specialRoads[j][2],specialRoads[i][0],specialRoads[j][3],specialRoads[i][1]) + specialRoads[i][4];
                dist1 = Math.min(dist1, dist3);
            }
            specialDistance[i] = dist1;
        }
        int dist4 = dist(start[0],target[0],start[1],target[1]);
        for (int i = 0; i < max; ++i) {
            int dist5 = specialDistance[i] + Math.abs(specialRoads[i][2] - target[0]) + Math.abs(specialRoads[i][3] - target[1]);
            dist4 = Math.min(dist4, dist5);
        }
        return dist4;
    }

    private int dist(int x1, int x2, int y1, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
