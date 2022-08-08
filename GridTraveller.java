class Container {
    int val;
    boolean isFilled;

    Container() {
        val = 0;
        isFilled = false;
    } // end of default constructor

    void fill(int value) {
        val = value;
        isFilled = true;
    } // end of fill(int)
} // end of class Container

public class GridTraveller {
    int rows;
    int cols;
    Container matrix[][];

    GridTraveller(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new Container[rows + 1][cols + 1];

        for (int i = 0; i <= rows; i++)
            for (int j = 0; j <= cols; j++)
                matrix[i][j] = new Container();
    } // end of parameterised constructor

    int numberOfPaths(int rows, int cols) {
        if (rows == 0 || cols == 0) return 0;
        if (rows == 1 && cols == 1) return 1;

        if (!matrix[rows][ cols].isFilled) {
            int pathsAfterMovingRight = numberOfPaths(rows, cols - 1);
            int pathsAfterMovingDown = numberOfPaths(rows - 1, cols);

            matrix[rows][cols].fill(pathsAfterMovingRight + pathsAfterMovingDown);
        }

        return matrix[rows][cols].val;
    } // end of numberOfPaths(int, int)

    public static void main(String args[]) {

        String usgMsg = "Usage:\n  $ java GridTraveller.java {no. of rows} {no. of columns}";

        if (args.length < 2) {
            System.out.println(usgMsg);
            System.exit(0);
        }

        int rows = 0;
        int cols = 0;

        try {
            rows = Integer.parseInt(args[0]); // no. of rows
            cols = Integer.parseInt(args[1]); // no. of columns
        }
        catch (Exception e) {
            System.out.println("INVALID INPUT!");
            System.out.println(usgMsg);
            System.exit(0);
        }

        GridTraveller ob = new GridTraveller(rows, cols);

        int paths = ob.numberOfPaths(rows, cols);

        System.out.println("Number of paths: " + paths);
    } // end of main(String[])
} // end of class GridTraveller
