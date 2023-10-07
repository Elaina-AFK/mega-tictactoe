import java.util.Scanner;

public class MegaTicTacToe {
    private MegaBoard allBoards = new MegaBoard();

    public void showBoard() {
        System.out.println("-_-_-_- At Main Board -_-_-_-");
        System.out.println("  _0_ _1_ _2_");
        for (int i = 0; i < 3; i++) {
            System.out.println(
                    i + "| " + allBoards.getWinner(new Position(i, 0)) + " | " + allBoards.getWinner(new Position(i, 1))
                            + " | " + allBoards.getWinner(new Position(i, 2)) + " |");
            System.out.println(" |___|___|___|");
        }
    }

    public void play(Scanner sc) {
        while (true) {
            new ClearScreen();
            System.out.println("-------> Now " + MegaBoard.player + " turn! <-------");
            showBoard();
            System.out.println("Playable at: " + allBoards.availablePosition.toText());
            Position position = Position.getUserPosition(sc, allBoards);
            allBoards.playAt(position, MegaBoard.player, sc);
            if (allBoards.winner != ' ') {
                return;
            }
        }
    }
}
