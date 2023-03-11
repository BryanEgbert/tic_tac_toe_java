package service;

import java.util.ArrayList;
import java.util.List;

import interfaces.ITicTacToeService;

public class TicTacToeService implements ITicTacToeService{

    private List<List<Character>> board;
    
    public TicTacToeService() {
        this.board = new ArrayList<List<Character>>() {{
            add(new ArrayList<>());
            add(new ArrayList<>());
            add(new ArrayList<>());
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
    public void WriteX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'WriteX'");
    }

    @Override
    public void WriteO() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'WriteO'");
    }

    @Override
    public List<List<Character>> GetBoard() {
        return this.board;
    }
}
