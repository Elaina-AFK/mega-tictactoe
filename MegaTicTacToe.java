import java.util.Scanner;

public class MegaTicTacToe {
    private MegaBoard allBoards = new MegaBoard();

    public void showBoard() {
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
            showBoard();
            System.out.println("----> " + MegaBoard.player + " turn! <----");
            System.out.println("Playable at: " + allBoards.availablePosition.toText());
            Position position = Position.getUserPosition(sc, allBoards);
            allBoards.playAt(position, MegaBoard.player, sc);
            if (allBoards.isWin(MegaBoard.player)) {
                System.out.println(MegaBoard.player + " winnnnn!");
                return;
            }
        }
    }
}
