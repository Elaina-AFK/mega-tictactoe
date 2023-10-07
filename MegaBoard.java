import java.util.Scanner;

public class MegaBoard {
    public char winner = ' ';
    static public char player = 'O';
    private TicTacToe[][] allTicTacToes = {
            { new TicTacToe(), new TicTacToe(), new TicTacToe() },
            { new TicTacToe(), new TicTacToe(), new TicTacToe() },
            { new TicTacToe(), new TicTacToe(), new TicTacToe() },
    };
    public char[][] allWinner = new char[3][3];
    public Available availablePosition;

    public MegaBoard() {
        setAllWinners();
        availablePosition = new Available();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Position position = new Position(i, j);
                if (getTicTacToe(position).getWinner() == ' ') {
                    availablePosition.addAvailable(position);
                }
            }
        }
    }

    public static void switchPlayer() {
        player = player == 'O' ? 'X' : 'O';
    }

    public void playAt(Position position, char player, Scanner sc) {
        new ClearScreen();
        System.out.println("-------> Now " + MegaBoard.player + " turn! <-------");
        System.out.println("-_-_-_- At " + position.toText() + " -_-_-_-");
        Position nextPos = getTicTacToe(position).playOnce(player, sc);
        setAllWinners();
        if (isWin(player)) {
            System.out.println("😳 player " + MegaBoard.player + " winnnnn!");
            return;
        }
        switchPlayer();
        setAvailablePosition(nextPos);
    }

    private TicTacToe getTicTacToe(Position position) {
        return allTicTacToes[position.row][position.column];
    }

    public void setAvailablePosition(Position nextPosition) {
        availablePosition = new Available();
        if (getTicTacToe(nextPosition).getWinner() == ' ') {
            availablePosition.addAvailable(nextPosition);
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Position position = new Position(i, j);
                if (getTicTacToe(position).getWinner() == ' ') {
                    availablePosition.addAvailable(position);
                }
            }
        }
    }

    public char getWinner(Position position) {
        return allWinner[position.row][position.column];
    }

    public void setAllWinners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char winner = getTicTacToe(new Position(i, j)).getWinner();
                if (winner == ' ') {
                    allWinner[i][j] = '#';
                    continue;
                }
                allWinner[i][j] = winner;
            }
        }
    }

    public boolean isWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (getWinner(new Position(i, 0)) == player && getWinner(new Position(i, 1)) == player
                    && getWinner(new Position(i, 2)) == player) {
                this.winner = player;
                return true;
            }
            if (getWinner(new Position(0, i)) == player && getWinner(new Position(1, i)) == player
                    && getWinner(new Position(2, i)) == player) {
                this.winner = player;
                return true;
            }
        }
        if (getWinner(new Position(0, 0)) == player && getWinner(new Position(1, 1)) == player
                && getWinner(new Position(2, 2)) == player) {
            this.winner = player;
            return true;
        }
        if (getWinner(new Position(0, 2)) == player && getWinner(new Position(1, 1)) == player
                && getWinner(new Position(2, 0)) == player) {
            this.winner = player;
            return true;
        }
        return false;
    }
}
