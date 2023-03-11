package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface ITicTacToeService {
    boolean IsBoardFull();
    void WriteX();
    void WriteO();
    List<List<Character>> GetBoard();
}
 