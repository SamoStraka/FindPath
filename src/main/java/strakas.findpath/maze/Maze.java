package strakas.findpath.maze;


import java.util.List;

public class Maze {

    public static final char WALL = '#';
    private static final char START = 'S';
    private static final char END = 'X';

    private final Node[][] grid;
    private final int rows;
    private final int cols;
    private Node startNode;
    private Node endNode;

    public Maze(char[][] gridAsChar) {
        this.grid = new Node[gridAsChar.length][gridAsChar[0].length];
        this.rows = grid.length;
        this.cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Node(gridAsChar[i][j], i, j, null, ' ', Integer.MAX_VALUE);

                if (gridAsChar[i][j] == START) {
                    startNode = grid[i][j];
                }
                if (gridAsChar[i][j] == END) {
                    endNode = grid[i][j];
                }
            }
        }
    }

    // Factory method to create Maze from list of strings
    public static Maze fromLines(List<String> lines) {
        int rows = lines.size();
        int cols = lines.getFirst().length();
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        return new Maze(grid);
    }

    // Getters
    public Node[][] getGrid() { return grid; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
}
