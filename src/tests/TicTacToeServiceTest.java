package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import service.TicTacToeService;
import types.Player;

public class TicTacToeServiceTest {
    @Test
    public void ShouldReturn3By3EmptyArrayList_WhenGetBoard_IsCalled() {
        List<List<Character>> expectedOutput = new ArrayList<List<Character>>() {{
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
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

    @Test
    public void WritePlayerO_ShouldReplaceEmptyCharWithO() {
        TicTacToeService sut = new TicTacToeService();
        Character expected = 'O';

        sut.Write(Player.O, 0, 0);

        assertEquals(expected, sut.GetBoard().get(0).get(0));
    }

    @Test
    public void WritePlayerO_ShouldNotReplaceNonEmptyCharWithO() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        Character expected = 'X';
        TicTacToeService sut = new TicTacToeService(board);

        sut.Write(Player.O, 0, 0);

        assertEquals(expected, sut.GetBoard().get(0).get(0));
    }

    @Test
    public void WritePlayerX_ShouldReplaceEmptyCharWithX() {
        TicTacToeService sut = new TicTacToeService();
        Character expected = 'X';

        sut.Write(Player.X, 0, 0);

        assertEquals(expected, sut.GetBoard().get(0).get(0));
    }

    @Test
    public void WritePlayerX_ShouldNotReplaceNonEmptyCharWithX() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        Character expected = 'O';
        TicTacToeService sut = new TicTacToeService(board);

        sut.Write(Player.X, 0, 2);

        assertEquals(expected, sut.GetBoard().get(0).get(2));
    }

    @Test
    public void CheckWinner_PlayerO_ShouldReturnsTrue_IfOWasConnectedInAColumn() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'O', 'O'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.O));
    } 

    @Test
    public void CheckWinner_PlayerO_ShouldReturnsTrue_IfOWasConnectedInARow() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'O', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.O));
    } 

    @Test
    public void CheckWinner_PlayerO_ShouldReturnsTrue_IfOWasConnectedInARightSidedDiagonal() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('O', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.O));
    }

    @Test
    public void CheckWinner_PlayerO_ShouldReturnsTrue_IfOWasConnectedInALeftSidedDiagonal() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('O', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.O));
    }

    @Test
    public void CheckWinner_PlayerX_ShouldReturnsTrue_IfOWasConnectedInAColumn() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'X'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('X', 'O', 'O'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'X', 'O'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.X));
    } 

    @Test
    public void CheckWinner_PlayerX_ShouldReturnsTrue_IfOWasConnectedInARow() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'O', 'X'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.X));
    } 

    @Test
    public void CheckWinner_PlayerX_ShouldReturnsTrue_IfOWasConnectedInARightSidedDiagonal() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('X', 'O', 'O'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.X));
    }

    @Test
    public void CheckWinner_PlayerX_ShouldReturnsTrue_IfOWasConnectedInALeftSidedDiagonal() {
        List<Character> firstColumn = new ArrayList<>(Arrays.asList('X', 'X', 'O'));
        List<Character> secondColumn = new ArrayList<>(Arrays.asList('O', 'X', 'X'));
        List<Character> thirdColumn = new ArrayList<>(Arrays.asList('O', 'O', 'X'));
        List<List<Character>> board = new ArrayList<List<Character>>(3){{
            add(firstColumn);
            add(secondColumn);
            add(thirdColumn);
        }};

        TicTacToeService sut = new TicTacToeService(board);

        assertTrue(sut.CheckWinner(Player.X));
    }
}