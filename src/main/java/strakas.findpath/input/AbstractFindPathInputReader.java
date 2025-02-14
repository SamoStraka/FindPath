package strakas.findpath.input;

import strakas.findpath.maze.Maze;

import java.io.IOException;

public abstract class AbstractFindPathInputReader {
    public abstract Maze readMaze() throws IOException;
}
