package strakas.findpath.maze;

public class Node {
    private final int row;
    private final int col;
    private int cost;
    private char value;
    Node prev;
    char move;

    Node(char value, int row, int col, Node prev, char move, int cost) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.prev = prev;
        this.move = move;
        this.cost = cost;
    }

    public boolean isWall() {
        return value == Maze.WALL;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setMove(char move) {
        this.move = move;
    }

    public char getMove() {
        return move;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
