import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Position {
    public int row;
    public int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position getUserPosition(Scanner sc, TicTacData data) {
        while (true) {
            System.out.print("Input your play position: ");
            String input = sc.nextLine();
            try {
                String[] posString = input.trim().split(" ");
                if (posString.length > 2) {
                    System.out.println("Invalid Input: more than 2 spaces seperated value");
                    continue;
                }
                Position position = new Position(Integer.parseInt(posString[0]), Integer.parseInt(posString[1]));
                if (!isValid(position.row, position.column)) {
                    System.out.println("Invalid Input: The Input Number is not in range 0 - 2");
                    continue;
                }
                if (data.isAlreadyPlay(position)) {
                    System.out.println("Can't play there");
                    continue;
                }
                return position;
            } catch (NumberFormatException e) {
                System.out.println("Invalid String Input");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Input: There is only 0 or 1 value (space seperated)");
                continue;
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
        }
    }

    public static Position getUserPosition(Scanner sc, MegaBoard data) {
        while (true) {
            System.out.print("Input your play position: ");
            String input = sc.nextLine();
            try {
                String[] posString = input.trim().split(" ");
                if (posString.length > 2) {
                    System.out.println("Invalid Input: more than 2 spaces seperated value");
                    continue;
                }
                Position position = new Position(Integer.parseInt(posString[0]), Integer.parseInt(posString[1]));
                if (!isValid(position.row, position.column)) {
                    System.out.println("Invalid Input: The Input Number is not in range 0 - 2");
                    continue;
                }
                if (data.getWinner(position) != '#') {
                    System.out.println("Can't play there");
                    continue;
                }
                return position;
            } catch (NumberFormatException e) {
                System.out.println("Invalid String Input");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Input: There is only 0 or 1 value (space seperated)");
                continue;
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
        }
    }

    public static boolean isValid(int row, int column) {
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
