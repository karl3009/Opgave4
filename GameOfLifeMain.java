public class GameOfLifeMain {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(4);
        System.out.println(game.AliveNeighbours(2, 2));
        //StdDraw.setCanvasSize(1000, 1000);
    }
}