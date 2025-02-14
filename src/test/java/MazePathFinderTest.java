import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import strakas.findpath.find.MazePathFinder;
import strakas.findpath.maze.Maze;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazePathFinderTest {

    private final MazePathFinder mazePathFinder = new MazePathFinder();

    @Test
    public void testPathFinder() {
        String[] mazeData = {
                "S..",
                ".#.",
                "..X"
        };
        Maze maze = Maze.fromLines(Arrays.asList(mazeData));
        String path = mazePathFinder.findPath(maze);

        assertEquals("d,d,r,r", path);
    }

    @Test
    void testPathFinderNoPath() {
        String[] mazeData = {
                "S..",
                "###",
                "..X"
        };
        Maze maze = Maze.fromLines(Arrays.asList(mazeData));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mazePathFinder.findPath(maze);
        });
    }

    @Test
    void testPathFinderBiggerMaze() {
        String[] mazeData = {
                "S...",
                ".#..",
                "..#.",
                "###.",
                "..X."
        };
        Maze maze = Maze.fromLines(Arrays.asList(mazeData));
        String path = mazePathFinder.findPath(maze);

        assertEquals("r,r,d,r,d,d,d,l", path);
    }

    @Test
    void testPathFinderBigMaze() {
        String[] mazeData = {
                "....................................",
                "..S...#......................#......",
                "......#......................#......",
                ".............................#......",
                "....................................",
                "....................................",
                "..............#.....................",
                "............#.......................",
                "..........#.........................",
                "....................................",
                ".....................#..........#...",
                ".....................#....X.....#...",
                ".....................#..........#...",
                "....................................",
        };
        Maze maze = Maze.fromLines(Arrays.asList(mazeData));
        String path = mazePathFinder.findPath(maze);

        assertEquals("r,r,d,r,d,r,r,d,d,r,r,r,r,r,r,r,r,d,d,r,d,d,r,r,r,r,r,r,d,d,r,r,r,r", path);
    }

}
