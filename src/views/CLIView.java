package views;

import java.util.List;
import java.util.Scanner;

import interfaces.ITicTacToeService;
import interfaces.IView;
import types.Player;

public class CLIView implements IView {
    private ITicTacToeService ticTacToeService;
    private int turn = 0;
    private Scanner input;

    public CLIView(ITicTacToeService ticTacToeService) {
        this.ticTacToeService = ticTacToeService;
        this.input = new Scanner(System.in);
    }

    @Override
    public void StartGame() {
        List<List<Character>> board = ticTacToeService.GetBoard();

        do {
            System.out.printf(" %c %c %c\n %c %c %c\n %c %c %c\nPlayer %c's turn, pick a number from the board [1-9]: ", 
                board.get(0).get(0) == ' ' ? '1' :  board.get(0).get(0), 
                board.get(0).get(1) == ' ' ? '2' : board.get(0).get(1), 
                board.get(0).get(2) == ' ' ? '3' : board.get(0).get(2), 
                board.get(1).get(0) == ' ' ? '4' : board.get(1).get(0), 
                board.get(1).get(1) == ' ' ? '5' : board.get(1).get(1), 
                board.get(1).get(2) == ' ' ? '6' : board.get(1).get(2), 
                board.get(2).get(0) == ' ' ? '7' : board.get(2).get(0), 
                board.get(2).get(1) == ' ' ? '8' : board.get(2).get(1), 
                board.get(2).get(2) == ' ' ? '9' : board.get(2).get(2),
                turn % 2 == 0 ? 'O' : 'X'
            );

            int numberPicked = input.nextInt();

            try {
                switch (numberPicked) {
                    case 1:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 0, 0);
                        break;
                    case 2:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 0, 1);
                        break;
                    case 3:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 0,2);
                        break;
                    case 4:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 1, 0);
                        break;
                    case 5:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 1, 1);
                        break;
                    case 6:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 1, 2);
                        break;
                    case 7:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 2, 0);
                        break;
                    case 8:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 2, 1);
                        break;
                    case 9:
                        ticTacToeService.Write(turn % 2 == 0 ? Player.O : Player.X, 2,2);
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception e) {
                continue;
            }

            if (ticTacToeService.CheckWinner(Player.O)) {
                System.out.println("Player O Wins!");
                System.exit(0);
            } else if (ticTacToeService.CheckWinner(Player.X)) {
                System.out.println("Player X Wins!");
                System.exit(0);
            } else if (ticTacToeService.IsBoardFull()) {
                System.out.println("DRAW!");
                System.exit(0);
            }

            turn++;
        } while (ticTacToeService.IsBoardFull() == false);
    }
}
