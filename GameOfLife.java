public class GameOfLife {
    public GameOfLife(int n) {
        nextState();
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
        initialState = int matrix[]={{is1,is2,is3},{is4,is5,is6},{is7,is8,is9}};
    }

    public void liveNeighbours(int x, int y) {
        int[][] neighbours = {{1,0,1,0},{1,0,1,0},{1,0,1,0},{1,0,1,0}};
        System.out.println(neighbours[0][0]);
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j<3; j++){
            }
        }
    }

    public void nextState() {
        int cell = n;
        if (cell==1){
            if (nCount==1){
                cell = 0;
            } if (nCount>=4){
                cell = 0;
            } 
        }elif (cell==1){
            if (nCount==3){
                cell = 1;
            }
        }
    }

}
