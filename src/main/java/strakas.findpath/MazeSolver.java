package strakas.findpath;

import strakas.findpath.find.MazePathFinder;
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
                reader = new FindPathInputReaderFile(args[0]);
            } else {
                reader = new FindPathInputReaderStdIn();
            }
            Maze maze = reader.readMaze();
            MazePathFinder mazePathFinder = new MazePathFinder();
            String path = mazePathFinder.findPath(maze);

            System.out.println("Path: " + path);

        } catch (IOException e) {
            System.err.println("Error reading maze: " + e.getMessage());
        }
    }
}