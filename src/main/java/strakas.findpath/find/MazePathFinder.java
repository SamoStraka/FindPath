package strakas.findpath.find;

import strakas.findpath.distance.DistanceCalculator;
import strakas.findpath.maze.Maze;
import strakas.findpath.maze.Node;

import java.util.*;


/**
 * Pathfinding algorithm to find the path in a maze.
 * <p></p>
 * This algorithm is based on the A* search algorithm.
 */
public class MazePathFinder {

    private static final List<Direction> DIRECTIONS = Arrays.asList(
            new Direction(-1, 0, 'u'),
            new Direction(1, 0, 'd'),
            new Direction(0, -1, 'l'),
            new Direction(0, 1, 'r')
    );

    private final PathReconstruct pathReconstruct = new PathReconstruct();

    /**
     * Public interface to find the path in the maze.
     * @param maze the maze object
     * @return a string of moves (e.g., "ddrr") or an error message if no path exists.
     */
    public String findPath(Maze maze) {
        Node endNode = search(maze);
        if (endNode == null) {
            throw new IllegalArgumentException("No path exists.");
        }
        return pathReconstruct.reconstruct(endNode);
    }

    /**
     * Performs the A* search on the maze.
     * @param maze the maze to search
     * @return the target Node if found; otherwise, null.
     */
    private Node search(Maze maze) {
        int targetRow = maze.getEndNode().getRow();
        int targetCol = maze.getEndNode().getCol();

        // Priority queue orders nodes by f(n) = cost so far + manhantan distance to finish.
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(
                node -> node.getCost() + DistanceCalculator.calculateDistance(node.getRow(), node.getCol(), targetRow, targetCol)
        ));

        var startNode = maze.getStartNode();
        startNode.setCost(0);
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current.getRow() == targetRow && current.getCol() == targetCol) {
                return current;
            }

            openSet.addAll(getNeighbors(current, maze));
        }
        return null;
    }

    /**
     * Retrieves all valid neighbor nodes from the current node.
     * @param current the current node
     * @param maze the maze
     * @return a list of valid neighbor nodes.
     */
    private List<Node> getNeighbors(Node current, Maze maze) {
        List<Node> neighbors = new ArrayList<>();

        for (Direction dir : DIRECTIONS) {
            int newRow = current.getRow() + dir.dr();
            int newCol = current.getCol() + dir.dc();

            if (!isWithinBounds(newRow, newCol, maze)) {
                continue;
            }

            Node neighbor = maze.getGrid()[newRow][newCol];
            if (neighbor.isWall()) {
                continue;
            }

            int newCost = current.getCost() + 1;  // Uniform cost for each move.
            if (newCost < neighbor.getCost()) {
                neighbor.setCost(newCost);
                neighbor.setPrev(current);
                neighbor.setMove(dir.move());
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private boolean isWithinBounds(int row, int col, Maze maze) {
        return row >= 0 && row < maze.getRows() && col >= 0 && col < maze.getCols();
    }

}
