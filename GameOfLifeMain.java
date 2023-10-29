public class GameOfLifeMain {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(3);
        System.out.println(game.liveNeighbours(2, 2));
        //StdDraw.setCanvasSize(1000, 1000);
    }
}