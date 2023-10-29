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

    public void readFile() throws FileNotFoundException {
        Scanner input = new Scanner(new File("./gol/toad.gol"));
        String n = input.nextLine();
        int rows = n.length();
        int cols = 0;
        while (input.hasNextInt()==false){
            cols += 1;
        }
        if (input.nextInt()==1){
            matrix[rows][cols]=1;
        }
    }
    
    public void initGame() {
        double scale = Size + Size / 4;
        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-scale, scale);
        StdDraw.setPenRadius(0.5 / scale);
        StdDraw.setPenColor(StdDraw.BLACK);
        this.matrix = new int[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                matrix[i][j] = j;
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        drawMatrix(matrix);

    }

    public void drawFiletrix(int[][] m) {

        try {
            int rows = 0;
            int cols = 0;
            readFile();
            
            for (int i = 0; i <= rows; i++) {
                for (int j = 0; j <= cols; j++) {
                    if (matrix[rows][cols] == 1) {
                        StdDraw.point(i, j);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            for (int i = 0; i <= Size; i++) {
                for (int j = 0; j <= Size; j++) {
                    if (matrix[i][j] == 1) {
                        StdDraw.point(i, j);
                    }
                }
            }
        }

    }
    
    public void drawMatrix(int[][] m) {
        StdDraw.clear();
        for (int i = 0; i <= Size; i++) {
            for (int j = 0; j <= Size; j++) {
                if (matrix[i][j] == 1) {
                    StdDraw.point(i, j);
                }
            }
        }
    }

    // instants-metoder
    public int AliveNeighbours(int x, int y) {
        int counter = 0;
        System.out.println("matrix x,y: " + matrix[x][y]);
        for (int i = 0; i < 3; i++) {
            if (x == 0) {
                // skip next
            } else if (matrix[x - 1][i] == 1) {
                counter += 1;
            }
            if (matrix[x][i] == 1) {
                counter += 1;
            }
            if (x == Size) {
                // skip next
            } else if (matrix[x + 1][i] == 1) {
                counter += 1;
            }
        }
        if (matrix[x][y] == 1) {
            counter -= 1;
        }
        return counter;
    }

    public void nextState() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
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
        drawMatrix(matrix);
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
