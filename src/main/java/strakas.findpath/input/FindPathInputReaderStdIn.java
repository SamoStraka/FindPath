package strakas.findpath.input;

import strakas.findpath.maze.Maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {
    @Override
    public Maze readMaze() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var lines = new ArrayList<String>();

        String line;
        System.out.println("Enter maze lines (terminate input with an empty line):");
        while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
            lines.add(line);
        }

        return Maze.fromLines(lines);
    }
}