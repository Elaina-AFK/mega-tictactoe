import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MegaTicTacToe m = new MegaTicTacToe();
        m.play(sc);
        sc.close();
    }
}
