import java.util.Scanner;

public class TicTacToe {
    private TicTacData data = new TicTacData();

    private void showBoard() {
        System.out.println("  _0_ _1_ _2_");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "| " + data.getData(new Position(i, 0)) + " | " + data.getData(new Position(i, 1))
                    + " | " + data.getData(new Position(i, 2)) + " |");
            System.out.println(" |___|___|___|");
        }
    }

    private Position getUserPosition(Scanner sc) {
        while (true) {
            System.out.print("Input your play position: ");
            String input = sc.nextLine();
            try {
                String[] posString = input.trim().split(" ");
                Position position = new Position(posString[0], posString[1]);
                if (data.isAlreadyPlay(position)) {
                    throw new Exception("Can't play there");
                }
                return position;
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
        }
    }

    public char getWinner() {
        return data.winner;
    }

    protected void play(Scanner sc) {
        int turn = 0;
        while (true) {
            showBoard();
            if (data.isOWin()) {
                System.out.println("O win!!");
                return;
            }
            if (data.isXWin()) {
                System.out.println("X win!!!");
                return;
            }
            Position pos;
            if (turn % 2 == 0) {
                System.out.println("----> O turn <----");
                pos = getUserPosition(sc);
                data.playAt(pos, 'O');
            } else {
                System.out.println("----> X turn <----");
                pos = getUserPosition(sc);
                data.playAt(pos, 'X');
            }
            turn++;
        }
    }

    public Position playOnce(char player, Scanner sc) {
        showBoard();
        Position pos = getUserPosition(sc);
        System.out.println("----> " + player + " turn <----");
        data.playAt(pos, player);
        if (data.isOWin()) {
            System.out.println("O win!!!");
        }
        if (data.isXWin()) {
            System.out.println("X win!!!");
        }
        if (data.isDraw()) {
            data.winner = data.mostCharacter();
            System.out.println("Draw!!... " + data.winner + " is magically won this board!");
        }
        return pos;
    }
}
