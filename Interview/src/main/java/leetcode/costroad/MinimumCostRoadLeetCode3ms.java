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
            if (road.isUseful()) // exclude roads which cost more then distance from the linked list
                last = last.next = road;
        }
        // LinkedList: startPoint, targetPoint, specialPoint1, 2, 3, ..., N where N.next == null
        Road defined = startPoint;
        do {
            int minDist = Integer.MAX_VALUE;
            Road prev = startPoint; // always start from the beginning of the linked list
            Road preMin = null;
            while (true) {
                Road road = prev.next;
                if (road == null)
                    break;
                int dist = road.updateDistance(defined); // calculate distance from last minimal/defined point and save it into current point holded by prev point
                if (dist < minDist) {
                    minDist = dist; // memorize new minimal distance
                    preMin = prev;  // memorize minimal road holder (previous in the linked list)
                }
                prev = road;
            }
            defined = preMin.next;          // next minimal road added to the root so far
            preMin.next = defined.next;     // exclude min road from the linked list
        } while (defined != targetPoint);   // linked list get empty of roads
        return targetPoint.distance;        // targetPoint is holder for the minimal road
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
            distance = distance(startPoint.x1, x2, startPoint.y1, y2);
        }

        boolean isUseful() {
            return cost < distance; // && cost < distance(x1, x2, y1, y2); // already calculated in #62
        }

        int distance(int x1, int x2, int y1, int y2){
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        int updateDistance(Road defined) {
            int distanceBetweenRoads = distance(defined.x2, x1, defined.y2, y1);
            int distanceSoFar = defined.distance;
            int combinedDistance = distanceSoFar
                    + distanceBetweenRoads
                    + cost;
            return distance = Math.min(distance, combinedDistance);
        }
    }


}
