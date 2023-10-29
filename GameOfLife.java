import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfLife {

    private int[][] matrix;
    private int Size;

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

    public void nextState() { // virker ikke ordenligt.
        for (int i = 0; i < Size - 1; i++) {
            for (int j = 0; j < Size - 1; j++) {
                if (matrix[i][j] == 1 && AliveNeighbours(i, j) < 2) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 1 && AliveNeighbours(i, j) > 3) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 0 && AliveNeighbours(i, j) == 3) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 1;
                }
            }
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
}
