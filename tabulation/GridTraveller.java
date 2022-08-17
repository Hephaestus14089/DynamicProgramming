public class GridTraveller {

    static int numberOfPaths(int rows, int cols) {
        if (rows == 0 || cols == 0)
            return 0;
        if (rows == 1 && cols == 1)
            return 1;

        int matrix[][] = new int[rows][cols];
        matrix[0][0] = 1;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                matrix[i + 1][j] += matrix[i][j]; // down cell
                matrix[i][j + 1] += matrix[i][j]; // right cell
            }
            matrix[i + 1][cols - 1] += matrix[i][cols - 1]; // last cell
        }
        for (int j = 0; j < cols - 1; j++) // last row
            matrix[rows - 1][j + 1] += matrix[rows - 1][j];

        return matrix[rows - 1][cols - 1];
    }

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

        int paths = numberOfPaths(rows, cols);
        System.out.println("Number of paths: " + paths);
    }
}
