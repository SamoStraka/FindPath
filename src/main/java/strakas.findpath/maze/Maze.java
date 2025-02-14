package strakas.findpath.maze;


import java.util.List;

public class Maze {
    private final char[][] grid;
    private final int rows;
    private final int cols;
    private int startRow, startCol;
    private int targetRow, targetCol;

    public Maze(char[][] gridAsChar) {
        this.grid = new char[gridAsChar.length][gridAsChar[0].length];
        this.rows = grid.length;
        this.cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gridAsChar[i][j] == 'S') {

                    startRow = i;
                    startCol = j;
                }
                if (gridAsChar[i][j] == 'X') {
                    targetRow = i;
                    targetCol = j;
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
    public char[][] getGrid() { return grid; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }
    public int getTargetRow() { return targetRow; }
    public int getTargetCol() { return targetCol; }
}
