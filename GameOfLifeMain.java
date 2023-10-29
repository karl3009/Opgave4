import java.util.Scanner;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 4;
        GameOfLife game = new GameOfLife(n);
        System.out.println(game.AliveNeighbours(2, 0));
        StdDraw.show();
        while (true) {
            int in = checkInput(input);
            if(in == 1){
                game.nextState();
            }
            else{
                System.exit(0);
            }
        }
        
    }
        public static int checkInput(Scanner input) {
        if (!input.hasNextInt()) {
            throw new IllegalArgumentException("Input is not an integer ");
        }
        int verifiedInput = input.nextInt();
        if (verifiedInput < 1) {
            System.out.println("Input is under 1");
            return 0;
        }
        else {
            return verifiedInput;
        }
    }
}