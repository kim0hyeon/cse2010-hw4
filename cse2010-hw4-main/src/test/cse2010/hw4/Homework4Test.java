package cse2010.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class Homework4Test {
    /**
     * BinToDec tests
     */

    @Test
    void testBinToDecBaseCase1() {
        assertEquals(0, BinToDec.binToDec("0"));
    }

    @Test
    void testBinToDecBaseCase2() {
        assertEquals(1, BinToDec.binToDec("1"));
    }

    @ParameterizedTest
    @CsvSource({
            "000, 0",
            "001, 1",
            "010, 2",
            "011, 3",
            "100, 4",
            "101, 5",
            "110, 6",
            "111, 7",
    })
    void testBinToDecRecurseCase(String number, int result) {
        assertEquals(result, BinToDec.binToDec(number));
    }

    @Test
    void testBinToDecBaseCaseTR1() {
        assertEquals(0, BinToDec.binToDec("0"));
    }

    @Test
    void testBinToDecBaseCaseTR2() {
        assertEquals(1, BinToDec.binToDec("1"));
    }

    @ParameterizedTest
    @CsvSource({
            "000, 0",
            "001, 1",
            "010, 2",
            "011, 3",
            "100, 4",
            "101, 5",
            "110, 6",
            "111, 7",
    })
    void testBinToDecRecurseCaseTR(String number, int result) {
        assertEquals(result, BinToDec.binToDecTR(number,0));
    }

    /**
     * Maze Tests
     */

    private Maze maze;

    private int[][] testMaze = new int[][] {
            { 0, 1, 0, 1, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 1, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 0 }
    };

    @Test
    void testMaze1_1() {
        maze = new Maze(testMaze, new Location(0, 0), new Location(4, 4));
        String expectedPath = "[4,4] <-- [3,4] <-- [3,3] <-- [2,3] <-- [1,3] <-- [1,2] <-- [1,1] <-- [1,0] <-- [0,0] <-- Start";

        assertTrue(maze.findPath());
        assertEquals(expectedPath, maze.showPath());
    }

    @Test
    void testMaze1_2() {
        maze = new Maze(testMaze, new Location(4, 4), new Location(0, 0));
        String expectedPath = "[0,0] <-- [1,0] <-- [1,1] <-- [1,2] <-- [2,2] <-- [2,3] <-- [3,3] <-- [3,4] <-- [4,4] <-- Start";

        assertTrue(maze.findPath());
        assertEquals(expectedPath, maze.showPath());
    }

    @Test
    void testMaze1_3() {
        maze = new Maze(testMaze, new Location(2, 0), new Location(4, 4));
        String expectedPath = "[4,4] <-- [3,4] <-- [3,3] <-- [2,3] <-- [1,3] <-- [1,2] <-- [1,1] <-- [1,0] <-- [2,0] <-- Start";

        assertTrue(maze.findPath());
        assertEquals(expectedPath, maze.showPath());
    }

    @Test
    void testMaze1_4() {
        maze = new Maze(testMaze, new Location(0, 4), new Location(4, 4));
        String expectedPath = "[4,4] <-- [3,4] <-- [3,3] <-- [2,3] <-- [2,2] <-- [1,2] <-- [1,3] <-- [1,4] <-- [0,4] <-- Start";

        assertTrue(maze.findPath());
        assertEquals(expectedPath, maze.showPath());
    }

    @Test
    void testMaze1_5() {
        maze = new Maze(testMaze, new Location(0, 4), new Location(4, 0));
        String expectedPath = "Start";

        assertFalse(maze.findPath());
        assertEquals(expectedPath, maze.showPath());
    }
}
