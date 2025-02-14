package strakas.findpath;

import strakas.findpath.input.AbstractFindPathInputReader;
import strakas.findpath.input.FindPathInputReaderFile;
import strakas.findpath.input.FindPathInputReaderStdIn;
import strakas.findpath.maze.Maze;

import java.io.IOException;

public class MazeSolver {
    public static void main(String[] args) {
        AbstractFindPathInputReader reader;
        try {
            if (args.length > 0) {
                // Read maze from file (first argument is the filename).
                reader = new FindPathInputReaderFile(args[0]);
            } else {
                // Read maze from standard input.
                reader = new FindPathInputReaderStdIn();
            }
            Maze maze = reader.readMaze();
            String path = MazePathFinder.findPath(maze);

            System.out.println("Path: " + path);

        } catch (IOException e) {
            System.err.println("Error reading maze: " + e.getMessage());
        }
    }
}