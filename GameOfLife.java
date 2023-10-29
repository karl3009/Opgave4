public class GameOfLife {
    // felter
    private int[][] matrix;
    private int Size;

    // konstruktører
    public GameOfLife(int n) {
        this.Size = n;
        initGame();
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
                matrix[i][j] = 1;
            }
        }
        drawMatrix(matrix);
    }

    public void drawMatrix(int[][] m) {
        StdDraw.clear();
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                System.out.print(m[i][j]);
                if (m[j][i] == 1) {
                    StdDraw.point(i, -j);
                }
            }
            System.out.println("");
        }
    }

    // instants-metoder
    public int AliveNeighbours(int x, int y) {
        int counter = 0;
        for (int i = -1; i < 2; i++) {
            if (x == 0 && y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x][y + j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x + 1][y + j] == 1) {
                        counter += 1;
                    }
                }
                if (matrix[x][y] == 1) {
                    counter -= 1;
                }
                break;
            } else if (x == Size - 1 && y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x - 1][y + j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x][y + j] == 1) {
                        counter += 1;
                    }

                }
                if (matrix[x - 1][y] == 1) {
                    counter -= 1;
                }
                break;
            } else if (x == 0 && y == Size - 1) {
                for (int j = 1; j <= 2; j++) {
                    if (matrix[x][y - j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x + 1][y - j] == 1) {
                        counter += 1;
                    }
                }
                if (matrix[x][y - 1] == 1) {
                    counter -= 1;
                }
                break;
            } else if (x == Size - 1 && y == Size - 1) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x][y - j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x - 1][y - j] == 1) {
                        counter += 1;
                    }
                }
                if (matrix[x - 1][y - 1] == 1) {
                    counter -= 1;
                }
                break;
            } else if (x == 0) {
                if (matrix[x][y + i] == 1) {
                    counter += 1;
                }
                if (matrix[x + 1][y + i] == 1) {
                    counter += 1;
                }
                if (i == 1) {
                    if (matrix[x][y] == 1) {
                        counter -= 1;
                    }
                }
            } else if (y == 0) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x + 1][y + j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x][y + j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x - 1][y + j] == 1) {
                        counter += 1;
                    }
                }
                if (matrix[x][y] == 1) {
                    counter -= 1;
                }
                break;
            } else if (x == Size - 1) {
                if (matrix[x][y + i] == 1) {
                    counter += 1;
                }
                if (matrix[x - 1][y + i] == 1) {
                    counter += 1;
                }
                if (i == 1) {
                    if (matrix[x][y] == 1) {
                        counter -= 1;
                    }
                }
            } else if (y == Size - 1) {
                for (int j = 0; j < 2; j++) {
                    if (matrix[x + 1][y - j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x][y - j] == 1) {
                        counter += 1;
                    }
                    if (matrix[x - 1][y - j] == 1) {
                        counter += 1;
                    }
                }
                if (matrix[x][y - 1] == 1) {
                    counter -= 1;
                }
                break;
            } else {
                if (matrix[x + 1][y + i] == 1) {
                    counter += 1;
                }
                if (matrix[x][y + i] == 1) {
                    counter += 1;
                }
                if (matrix[x - 1][y + i] == 1) {
                    counter += 1;
                }
                if (i == 1) {
                    if (matrix[x][y] == 1) {
                        counter -= 1;
                    }
                }
            }

        }
        return counter;
    }

    public void nextState() {
        System.out.println(matrix[2][0] == 1 && AliveNeighbours(3, 1)>3);
        for (int i = 0; i < Size - 1; i++) {
            for (int j = 0; j < Size - 1; j++) {
                if (matrix[i][j] == 1 && AliveNeighbours(i, j) < 2) {
                    matrix[i][j] = 0;
                    System.out.println('x');
                } else if (matrix[i][j] == 1 && AliveNeighbours(i, j) > 3) {
                    matrix[i][j] = 0;
                    System.out.println('z');
                }
                else if (matrix[i][j] == 0 && AliveNeighbours(i, j) == 3) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        // printMatrix(matrix);
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
}
