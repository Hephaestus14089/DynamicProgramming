import java.util.*;

public class Fibonacci {

    int values[];
    boolean isFilled[];

    Fibonacci(int limit) {
        int length = limit + 1;

        values = new int[length];
        isFilled = new boolean[length];

        for (int i = 0; i < length; i++)
            isFilled[i] = false;
    } // end of parameterised constructor

    int getSeries(int n) {
        if (isFilled[n])
            return values[n];

        int element = 0;

        if (n == 0)
            element = 0;
        else if (n == 1)
            element = 1;
        else
            element = getSeries(n - 1) + getSeries(n - 2);

        values[n] = element;
        isFilled[n] = true;

        return element;
    } // end of printSeries(int)

    void displaySeries() {
        System.out.print("Series: ");
        for (int i = 0; i < values.length; i++)
            System.out.print(values[i] + " ");
        System.out.println();
    } // end of displaySeries()

    public static void main(String args[]) {
        System.out.print("Enter limit for series display: ");

        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt() - 1;
        Fibonacci ob = new Fibonacci(limit);
        sc.close();

        if (limit < 0)
            System.out.println("Invalid Input!");
        else {
            ob.getSeries(limit);
            ob.displaySeries();
        }
    } // end of main()
} // end of Fibonacci class
