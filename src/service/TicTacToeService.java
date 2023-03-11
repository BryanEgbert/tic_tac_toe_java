package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.ITicTacToeService;
import types.Player;

public class TicTacToeService implements ITicTacToeService{

    private List<List<Character>> board;
    
    public TicTacToeService() {
        this.board = new ArrayList<List<Character>>() {{
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
            add(new ArrayList<>(Arrays.asList(' ', ' ', ' ')));
        }};
    }

    public TicTacToeService(List<List<Character>> board) {
        this.board = board;
    }

    @Override
    public boolean IsBoardFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.get(i).get(j) == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void Write(Player player, int x, int y) throws Exception {
        if (board.get(x).get(y) == ' ') {
            switch (player) {
                case O:
                    board.get(x).set(y, 'O');
                    return;
                case X:
                    board.get(x).set(y, 'X');
                    return;
                default:
                    return;
            }
        }

        throw new Exception("Cannot replace 'X' and 'O'");
    }

    @Override
    public List<List<Character>> GetBoard() {
        return this.board;
    }

    @Override
    public boolean CheckWinner(Player player) {
        switch (player) {
            case O:
                for (int i = 0; i < 3; ++i) {
                    if (board.get(i).get(0) == 'O' && board.get(i).get(1) == 'O' && board.get(i).get(2) == 'O') {
                        return true;
                    }
                    if (board.get(0).get(i) == 'O' && board.get(1).get(i) == 'O' && board.get(2).get(i) == 'O') {
                        return true;
                    }
                }

                if (board.get(2).get(0) == 'O' && board.get(1).get(1) == 'O' && board.get(0).get(2) == 'O') {
                    return true;
                }

                if (board.get(0).get(0) == 'O' && board.get(1).get(1) == 'O' && board.get(2).get(2) == 'O') {
                    return true;
                }
                
                return false;     
            case X:
                for (int i = 0; i < 3; ++i) {
                    if (board.get(i).get(0) == 'X' && board.get(i).get(1) == 'X' && board.get(i).get(2) == 'X') {
                        return true;
                    }
                    if (board.get(0).get(i) == 'X' && board.get(1).get(i) == 'X' && board.get(2).get(i) == 'X') {
                        return true;
                    }
                }

                if (board.get(2).get(0) == 'X' && board.get(1).get(1) == 'X' && board.get(0).get(2) == 'X') {
                    return true;
                }

                if (board.get(0).get(0) == 'X' && board.get(1).get(1) == 'X' && board.get(2).get(2) == 'X') {
                    return true;
                }
                
                return false;   
            default:
                return false;
        }
    }
}
