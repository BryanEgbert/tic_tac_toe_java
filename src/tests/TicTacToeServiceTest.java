package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import service.TicTacToeService;

public class TicTacToeServiceTest {
    @Test
    public void ShouldReturn3By3EmptyArrayList_WhenGetBoard_IsCalled() {
        List<List<Character>> expectedOutput = new ArrayList<List<Character>>() {{
            add(new ArrayList<>());
            add(new ArrayList<>());
            add(new ArrayList<>());
        }};

        TicTacToeService sut = new TicTacToeService();

        assertEquals(expectedOutput, sut.GetBoard());
    }

    @Test
    public void IsBoardFull_ShouldReturnsFalse_WhenBoardContainsEmptyChar() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList(' ', 'O', ' '));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList(' ', ' ', 'O'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertFalse(sut.IsBoardFull());
    }

    @Test 
    public void IsBoardFull_ShouldReturnTrue_IfBoardIsDoesNotContainEmptyChar() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.IsBoardFull());
    }
}