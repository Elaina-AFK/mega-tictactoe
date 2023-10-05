public class TicTacData {
    public char winner = ' ';
    public int playCount = 0;
    private char[][] data = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
    };

    public char getData(Position position) {
        return this.data[position.row][position.column];
    }

    private boolean isWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (getData(new Position(i, 0)) == player && getData(new Position(i, 1)) == player
                    && getData(new Position(i, 2)) == player) {
                this.winner = player;
                return true;
            }
            if (getData(new Position(0, i)) == player && getData(new Position(1, i)) == player
                    && getData(new Position(2, i)) == player) {
                this.winner = player;
                return true;
            }
        }
        if (getData(new Position(0, 0)) == player && getData(new Position(1, 1)) == player
                && getData(new Position(2, 2)) == player) {
            this.winner = player;
            return true;
        }
        if (getData(new Position(0, 2)) == player && getData(new Position(1, 1)) == player
                && getData(new Position(2, 0)) == player) {
            this.winner = player;
            return true;
        }
        return false;
    }

    private void setData(Position position, char character) {
        data[position.row][position.column] = character;
    }

    public boolean isAlreadyPlay(Position position) {
        if (getData(position) != ' ') {
            return true;
        }
        return false;
    }

    public void playAt(Position position, char player) {
        setData(position, player);
    }

    public boolean isOWin() {
        return isWin('O');
    }

    public boolean isXWin() {
        return isWin('X');
    }

    public boolean isDraw() {
        return playCount == 9;
    }

    public char mostCharacter() {
        int playerX = 0;
        int playerO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getData(new Position(i, j)) == 'O') {
                    playerO++;
                }
                if (getData(new Position(i, j)) == 'X') {
                    playerX++;
                }
            }
        }
        return playerO > playerX ? 'O' : 'X';
    }

}
