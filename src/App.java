import interfaces.ITicTacToeService;
import interfaces.IView;
import service.TicTacToeService;
import views.CLIView;

public class App {
    public static void main(String[] args) throws Exception {
        ITicTacToeService ticTacToeService = new TicTacToeService();
        IView cliView = new CLIView(ticTacToeService);

        cliView.StartGame();
    }
}
