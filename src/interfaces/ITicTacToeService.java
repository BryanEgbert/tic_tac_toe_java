package interfaces;

import java.util.List;

import types.Player;

public interface ITicTacToeService {
    boolean IsBoardFull();
    void Write(Player player, int x, int y);
    List<List<Character>> GetBoard();
    boolean CheckWinner(Player player);
}
 