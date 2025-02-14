import org.junit.jupiter.api.Test;
import strakas.findpath.MazePathFinder;
import strakas.findpath.maze.Maze;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazePathFinderTest {

    @Test
    public void testPathFinder() {
        // Maze layout:
        // S . .
        // . # .
        // . . X
        String[] mazeData = {
                "S..",
                ".#.",
                "..X"
        };
        Maze maze = Maze.fromLines(Arrays.asList(mazeData));
        String path = MazePathFinder.findPath(maze);

        assertEquals("ddrr", path);
    }
}
