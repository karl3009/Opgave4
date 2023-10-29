public class GameOfLifeMain {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(4);
        System.out.println(game.AliveNeighbours(1, 1));
        System.out.println("aa");
        //StdDraw.setCanvasSize(1000, 1000);
        game.nextState();
        game.nextState();
        game.nextState();
    }
}