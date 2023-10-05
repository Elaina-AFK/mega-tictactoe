import java.util.ArrayList;
import java.util.List;

public class Position {
    public int row;
    public int column;

    public Position(String row, String column) throws Exception {
        try {
            int tempRow = Integer.parseInt(row);
            int tempColumn = Integer.parseInt(column);
            if (isValid(tempRow, tempColumn)) {
                this.row = tempRow;
                this.column = tempColumn;
            } else {
                throw new Exception("PLEASE INPUT A VALID POSITION");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Position(int row, int column) {
        if (isValid(row, column)) {
            this.row = row;
            this.column = column;
        } else {
            System.out.println("PLEASE INPUT VALID POSITION");
        }
    }

    private boolean isValid(int row, int column) {
        ArrayList<Integer> validNum = new ArrayList<Integer>(List.of(0, 1, 2));
        if (validNum.contains(row) && validNum.contains(column)) {
            return true;
        }
        return false;
    }

    public String toText() {
        return "(" + row + ", " + column + ")";
    }
}
