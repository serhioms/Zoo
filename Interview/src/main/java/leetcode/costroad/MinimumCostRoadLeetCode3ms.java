package leetcode.costroad;

public class MinimumCostRoadLeetCode3ms implements MinimumCostRoad {

    @Override
    public int solution(int[] start, int[] target, int[][] specialRoads) {
        Road startPoint = new Road(start);
        Road targetPoint = new Road(new int[]{target[0], target[1], target[0], target[1], 0}, startPoint);
        if (targetPoint.distance == 0)
            return 0;
        Road last = startPoint.next = targetPoint;
        for (int[] data : specialRoads) {
            Road road = new Road(data, startPoint);
            if (road.isUseful())
                last = last.next = road;
        }
        Road defined = startPoint;
        do {
            int minDist = Integer.MAX_VALUE;
            Road prev = startPoint;
            Road preMin = null;
            while (true) {
                Road road = prev.next;
                if (road == null)
                    break;
                int dist = road.updateDistance(defined);
                if (dist < minDist) {
                    minDist = dist;
                    preMin = prev;
                }
                prev = road;
            }
            defined = preMin.next;
            preMin.next = defined.next;
        } while (defined != targetPoint);
        return targetPoint.distance;
    }

    private static class Road {
        final int x1;
        final int y1;
        final int x2;
        final int y2;
        final int cost;
        int distance; // from startPoint to (x2, y2)
        Road next;

        // startPoint
        Road(int[] data) {
            x1 = x2 = data[0];
            y1 = y2 = data[1];
            cost = 0;
        }

        Road(int[] data, Road startPoint) {
            x1 = data[0];
            y1 = data[1];
            x2 = data[2];
            y2 = data[3];
            cost = data[4];
            distance = Math.abs(startPoint.x1 - x2) + Math.abs(startPoint.y1 - y2);
        }

        boolean isUseful() {
            return cost < distance && cost < Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        int updateDistance(Road defined) {
            return distance = Math.min(distance,
                    defined.distance + Math.abs(defined.x2 - x1) + Math.abs(defined.y2 - y1) + cost);
        }
    }


}
