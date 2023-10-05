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

    private Position getPosition(Scanner sc) {
        while (true) {
            System.out.print("Input your play position: ");
            String input = sc.nextLine();
            try {
                String[] posString = input.trim().split(" ");
                Position position = new Position(posString[0], posString[1]);
                if (!allBoards.availablePosition.havePosition(position)) {
                    throw new Exception("Can't play there");
                }
                return position;
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
        }
    }

    public void play(Scanner sc) {
        while (true) {
            showBoard();
            System.out.println("Playable at: " + allBoards.availablePosition.toText());
            Position position = getPosition(sc);
            allBoards.playAt(position, MegaBoard.player, sc);
            if (allBoards.isWin(MegaBoard.player)) {
                System.out.println(MegaBoard.player + " winnnnn!");
                return;
            }
        }
    }
}
