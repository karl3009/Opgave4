public class GameOfLife {
    // felter
    private int[][] matrix;
    private int Size;

    // konstruktører
    public GameOfLife(int n) {
        this.Size = n;
        initGame();
    }

    public GameOfLife(int[][] initialState) {
        int is1 = Random.c(1,0);
        int is2 = Random.c(1,0);
        int is3 = Random.c(1,0);
        int is4 = Random.c(1,0);
        int is5 = Random.c(1,0);
        int is6 = Random.c(1,0);
        int is7 = Random.c(1,0);
        int is8 = Random.c(1,0);
        int is9 = Random.c(1,0);
        this.matrix[0][0]={{is1,is2,is3},{is4,is5,is6},{is7,is8,is9}};
    }

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
