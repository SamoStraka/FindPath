package strakas.findpath.input;

import strakas.findpath.maze.Maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private final String filename;

    public FindPathInputReaderFile(String filename) {
        this.filename = filename;
    }

    @Override
    public Maze readMaze() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return Maze.fromLines(lines);
    }
}