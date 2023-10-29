public class GameOfLife {
    // felter
    private int[][] matrix;
    private int Size;

    // konstruktører
    public GameOfLife(int n) {
        this.Size = n;
        initGame();
    }

    /*public GameOfLife(int[][] initialState) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = rand.nextInt(1);
            }
        }
    }*/

    public void initGame() {
        this.matrix = new int[Size][Size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = j;
            }
        }

    }

    // instants-metoder
    public int liveNeighbours(int x, int y) {
        return matrix[x][y];
        /*
         * for (int i = 0; i < 3; i++) {
         * for(int j = 0; j<3; j++){
         * }
         * }
         */
    }

    public void nextState() {

    }

    /*
     * public void nextState() {
     * int cell = n;
     * if (cell==1){
     * if (nCount==1){
     * cell = 0;
     * } if (nCount>=4){
     * cell = 0;
     * }
     * }elif (cell==1){
     * if (nCount==3){
     * cell = 1;
     * }
     * }
     * }
     */

}
