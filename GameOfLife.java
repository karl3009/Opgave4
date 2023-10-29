public class GameOfLife {
    public GameOfLife(int n){
        nextState(){
            int cell = n
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
        liveNeighbours(int x, int y){
            int nCount=0;
        }
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
        initialState = int matrix[]={{is1,is2,is3},{is4,is5,is6},{is7,is8,is9}}
    }

}
