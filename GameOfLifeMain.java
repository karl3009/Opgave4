public class GameOfLifeMain {
    public static void main(String[] args) {
        int n = 4;
        GameOfLife game = new GameOfLife(n);
        System.out.println(game.AliveNeighbours(2, 2));
    }

}
