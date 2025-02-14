package strakas.findpath.distance;

public class DistanceCalculator {
    /**
     * Manhattan distance between (row, col) and the target.
     * @param x1 - row of the current node
     * @param y1 - column of the current node
     * @param x2 - row of the target node
     * @param y2 - column of the target node
     * @return - the Manhattan distance between the two nodes
     */
    public static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
