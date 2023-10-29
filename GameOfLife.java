public class GameOfLife {
    // felter
    private int[][] matrix;
    private int Size;

    // konstruktører
    public GameOfLife(int n) {
        this.Size = n;
        initGame();
    }

    /*
     * public GameOfLife(int[][] initialState) {
     * Random rand = new Random();
     * for (int i = 0; i < 3; i++) {
     * for (int j = 0; j < 3; j++) {
     * matrix[i][j] = rand.nextInt(1);
     * }
     * }
     * }
     */

    public void initGame() {
        this.matrix = new int[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                matrix[i][j] = 1;
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }

    }

    public void drawBoard(String[][] board){
        for (int i = 0; i < 3; i++) { //line 88
            for (int j = 0; j < 3; j++) {
                int r = board.length;
                int c = board[0].length;
                double R = new Double(r);
                double C = new Double(c);
    
            StdDraw.setXscale(0,C);
            StdDraw.setYscale(0,R);
            StdDraw.setCanvasSize(500,500);
            StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.rectangle((C/2), (R/2), (C/2), (R/2));
            StdDraw.close();
            }
        }

    // instants-metoder
    public int AliveNeighbours(int x, int y) {
        int counter = 0;
        for (int i = -1; i < 2; i++) {
            if (x == 0 && y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x][y + j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x + 1][y + j] == 1) {
                        counter = +1;
                    }
                }
            } else if (x == Size && y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x - 1][y + j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x][y + j] == 1) {
                        counter = +1;
                    }
                }
            } else if (x == 0 && y == Size) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x][y - j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x + 1][y - j] == 1) {
                        counter = +1;
                    }
                }
            } else if (x == Size && y == Size) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x][y - j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x - 1][y - j] == 1) {
                        counter = +1;
                    }
                }
            }

            else if (x == 0) {
                if (matrix[x][y + i] == 1) {
                    counter = +1;
                }
                if (matrix[x + 1][y + i] == 1) {
                    counter = +1;
                }
            } else if (y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x + 1][y + j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x][y + j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x - 1][y + j] == 1) {
                        counter = +1;
                    }
                }
            } else if (x == Size) {
                if (matrix[x][y + i] == 1) {
                    counter = +1;
                }
                if (matrix[x - 1][y + i] == 1) {
                    counter = +1;
                }
            } else if (y == Size) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x + 1][y - j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x][y - j] == 1) {
                        counter = +1;
                    }
                    if (matrix[x - 1][y - j] == 1) {
                        counter = +1;
                    }
                }
            } else {
                if (matrix[x + 1][y + i] == 1) {
                    counter = +1;
                }
                if (matrix[x][y + i] == 1) {
                    counter = +1;
                }
                if (matrix[x - 1][y + i] == 1) {
                    counter = +1;
                }
            }

        }
        if (matrix[x][y] == 1) {
            counter -= 1;
        }
        return counter;
    }

    public void nextState() {
        for (int i = 0; i < Size-1; i++) {
            for (int j = 0; j < Size-1; j++) {
                if (matrix[i][j] == 1 && (AliveNeighbours(i, j) < 2 || AliveNeighbours(i, j) > 3)) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 0 && AliveNeighbours(i, j) == 3) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        printMatrix(matrix);
    }

    public void printMatrix(int[][] m) {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
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
